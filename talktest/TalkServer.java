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
		System.out.println("*Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�.");
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

	// ���ӵ� ��� id ����Ʈ ���� ex) aaa;bbb;ccc;ddd;ȫ�浿;
	public String getIdList() {
		String ids = "";
		for (int i = 0; i < vc.size(); i++) {
			TalkThread ct = vc.get(i);
			ids += ct.id + ";";
		}
		return ids;
	}

	// �Ű����� id������ ClientThread3�� �˻�
	public TalkThread findClient(String id) {
		TalkThread ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if (ct.id.equals(id)) {// �Ű����� id�� Client�� id�� ���ٸ�...
				break;
			}
		} // --for
		return ct;
	}// --findClient

	class TalkThread extends Thread {

		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";

		public TalkThread(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter((sock.getOutputStream()), true);
				System.out.println(sock + " ���ӵ�...");
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
				System.err.println(sock + "[" + id + "] ������...");
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
					//�α��� ����
					TalkThread ct = findClient(cmd);
					if(ct!=null&&ct.id.equals(cmd)) {
						//��������
						sendMessage(ChatProtocol3.ID + ChatProtocol3.MODE + "C");
					}else {
						id = cmd;
						sendMessage(ChatProtocol3.ID + ChatProtocol3.MODE + "T");
						sendAllMessage(ChatProtocol3.CHATLIST + ChatProtocol3.MODE + getIdList());
						sendAllMessage(ChatProtocol3.CHATALL + ChatProtocol3.MODE + "[" +id + "]���� �����Ͽ����ϴ�.");
						
					}
				}else {
					sendMessage(ChatProtocol3.ID + ChatProtocol3.MODE + "F");
				}
			} else if (cmd.equals(ChatProtocol3.CHAT)) {// CHAT:bbb;�����
				idx = data.indexOf(';');
				cmd/* bbb */ = data.substring(idx);
				data/* ����� */ = data.substring(idx + 1);
				// id : bbb�� ���� Ŭ���̾�Ʈ�� ã�ƾ� �Ѵ�.
				TalkThread ct = findClient(cmd);
				if (ct != null) {// ����� �ڽſ��� ����
					ct.sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + id + "(S)]" + data); // bbb���� ���󰡴°�(����) , data =
																							// �ӼӸ�
					sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + id + "(S)]" + data); // �ڽ�(aaa)���� �����(sendMessage)
				} else {// �ڽſ��� �����°� (aaa)
					sendMessage(ChatProtocol3.CHAT + ChatProtocol3.MODE + "[" + cmd + "]���� �����ڰ� �ƴմϴ�.");
				}

			} else if (cmd.equals(ChatProtocol3.CHATALL)) {
				sendAllMessage(ChatProtocol3.CHATALL + ChatProtocol3.MODE + "[" + id + "]" + data);
			} else if (cmd.equals(ChatProtocol3.MESSAGE)) {
				//MESSAGE:ccc;���� ����?
				idx = data.indexOf(';');
				cmd = data.substring(0, idx);//ccc
				data = data.substring(idx+1);//���� ����?
				TalkThread ct = findClient(cmd);
				if(ct!=null) {
					//MESSAGE:aaa;���� ����?
					MessageBean3 bean = new MessageBean3();
					bean.setFid(id);//aaa
					bean.setTid(cmd);//bbb
					bean.setMsg(data);//���ù���?
					ct.sendMessage(ChatProtocol3.MESSAGE+
							ChatProtocol3.MODE+id+";"+data);
				}else {
					sendMessage(ChatProtocol3.CHAT+
							ChatProtocol3.MODE+"["+cmd+"]���� �����ڰ� �ƴմϴ�");
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
