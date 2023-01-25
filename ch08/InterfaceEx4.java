package ch08;

abstract class Tv{
	String color;
	boolean power;
	int ch;
	void onOffPower() {
		power =! power;
	}
	void upCh() {
		ch++;
	}
	void upDown() {
		ch--;
	}
	abstract void setModel();
}

class SMTv extends Tv{
	@Override
	void setModel() {}

}
class LGTv extends Tv{
	@Override
	void setModel() {}
}

interface RemoteControl{
	void turnOn();
	void turnOff();
	
}
public class InterfaceEx4 {

}
