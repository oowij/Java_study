package talktest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class TalkServer {

	Vector<TalkThread> vc;
	ServerSocket server;
	int port = 8003;
	TalkMgr mgr;

	public TalkServer() {
		try {
			vc = new Vector<TalkThread>();
			server = new ServerSocket(port);
			mgr = new TalkMgr();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("****************************************");
		System.out.println("*Welcome Chat Server 3.0...");
		System.out.println("*클라이언트 접속을 기다리고 있습니다.");
		System.out.println("****************************************");
		try {
			while (true) {
				Socket sock = server.accept();
				TalkThread ct = new TalkThread(sock);
				ct.start();
				vc.addElement(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}

	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			TalkThread ct = vc.elementAt(i);
			ct.sendMessage(msg);
		}
	}

	public void removeClient(TalkThread ct) {
		vc.remove(ct);
	}

	// 접속된 모든 id 리스트 리턴 ex) aaa;bbb;ccc;ddd;홍길동;
	public String getIdList() {
		String ids = "";
		for (int i = 0; i < vc.size(); i++) {
			TalkThread ct = vc.get(i);
			ids += ct.id + ";";
		}
		return ids;
	}

	// 매개변수 id값으로 ClientThread3를 검색
	public TalkThread findClient(String id) {
		TalkThread ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {// 매개변수 id와 Client의 id와 같다면...
				break;
			}
		} // --for
		return ct;
	}// --findClient

	class TalkThread extends Thread {

		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "익명";

		public TalkThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter((sock.getOutputStream()), true);
				System.out.println(sock + " 접속됨...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String line = in.readLine();
					if (line == null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock + "[" + id + "] 끊어짐...");
			}
		}

		public void routine(String line) {
			System.out.println("line:" + line);
			int idx = line.indexOf(ChatProtocol3.MODE);
			String cmd = line.substring(0, idx); 
			String data = line.substring(idx + 1); 
			//ID:aaa;1234
			if (cmd.equals(ChatProtocol3.ID)) {
				idx = data.indexOf(";");
				cmd = data.substring(0, idx);//aaa
				data = data.substring(idx + 1);//1234
				if(mgr.loginChk(cmd, data)) {
					//로그인 성공
					TalkThread ct = findClient(cmd);
					if(ct!=null&&ct.id.equals(cmd)) {
						//이중접속
						sendMessage(ChatProtocol3.ID + ChatProtocol3.MODE + "C");
					}else {
						id = cmd;
						sendMessage(ChatProtocol3.ID + ChatProtocol3.MODE + "T");
						sendAllMessage(ChatProtocol3.CHATLIST + ChatProtocol3.MODE + getIdList());
						sendAllMessage(ChatProtocol3.CHATALL + ChatProtocol3.MODE + "[" +id + "]님이 입장하였습니다.");
						
					}
				}else {
					sendMessage(ChatProtocol3.ID + ChatProtocol3.MODE + "F");
				}
			} else if (cmd.equals(ChatProtocol3.CHAT)) {// CHAT:bbb;밥먹자
				idx = data.indexOf(';');
				cmd/* bbb */ = data.substring(idx);
				data/* 밥먹자 */ = data.substring(idx + 1);
				// id : bbb를 가진 클라이언트를 찾아야 한다.
				TalkThread ct = findClient(cmd);
				if (ct != null) {// 상대방과 자신에게 보냄
					ct.sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + id + "(S)]" + data); // bbb에게 날라가는것(상대방) , data =
																							// 귓속말
					sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + id + "(S)]" + data); // 자신(aaa)에게 날라옴(sendMessage)
				} else {// 자신에게 보내는것 (aaa)
					sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + cmd + "]님이 접속자가 아닙니다.");
				}

			} else if (cmd.equals(ChatProtocol3.CHATALL)) {
				sendAllMessage(ChatProtocol3.CHATALL + ChatProtocol3.MODE + "[" + id + "]" + data);
			} else if (cmd.equals(ChatProtocol3.MESSAGE)) {
				//MESSAGE:ccc;오늘 머해?
				idx = data.indexOf(';');
				cmd = data.substring(0, idx);//ccc
				data = data.substring(idx+1);//오늘 머해?
				TalkThread ct = findClient(cmd);
				if(ct!=null) {
					//MESSAGE:aaa;오늘 머해?
					MessageBean3 bean = new MessageBean3();
					bean.setFid(id);//aaa
					bean.setTid(cmd);//bbb
					bean.setMsg(data);//오늘뭐해?
					ct.sendMessage(ChatProtocol3.MESSAGE+
							ChatProtocol3.MODE+id+";"+data);
				}else {
					sendMessage(ChatProtocol3.CHAT+
							ChatProtocol3.MODE+"["+cmd+"]님이 접속자가 아닙니다");
				}
			}
		}

		public void sendMessage(String msg) {
			out.println(msg);
		}
	}

	public static void main(String[] args) {
		new TalkServer();
	}

	public boolean loginChk(String cmd, String data) {
		return false;
	}



}
