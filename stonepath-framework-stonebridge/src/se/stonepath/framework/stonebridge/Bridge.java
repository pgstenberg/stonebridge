package se.stonepath.framework.stonebridge;

import java.io.IOException;
import java.net.UnknownHostException;

public class Bridge {

	public static BridgeCommand sendCommand(String host,int port,BridgeCommand command) throws UnknownHostException, IOException{
		BridgeConnection bridgeConnection = new BridgeConnection(host, port);
		bridgeConnection.connect();
		bridgeConnection.send(command);
		BridgeCommand respondCommand = bridgeConnection.getRespond();
		bridgeConnection.disconnect();
		return respondCommand;
	}
}
