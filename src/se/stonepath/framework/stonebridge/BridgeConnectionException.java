package se.stonepath.framework.stonebridge;

public class BridgeConnectionException extends Exception{

	private static final long serialVersionUID = 1L;

	public BridgeConnectionException(){
		super("Can't connect to bridge.");
	}
}
