package se.stonepath.framework.stonebridge;

public class BridgeSendCommandException extends Exception{

	private static final long serialVersionUID = 1L;

	public BridgeSendCommandException(){
		super("An error occured while sending command.");
	}
}
