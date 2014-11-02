package se.stonepath.framework.stonebridge;

public class BridgeDisconnectException extends Exception{

	private static final long serialVersionUID = 1L;

	public BridgeDisconnectException(){
		super("Coulden't disconnect from bridge.");
	}
}
