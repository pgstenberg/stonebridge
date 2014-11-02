package se.stonepath.framework.stonebridge;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;


public class BridgeConnection {
	
	private final static String ENCODING = "UTF-8";
	
	private String host;
	private int port;
	private Socket socket;
	private OutputStream outStream;
	private InputStream inputStream;
	public BridgeConnection(String host,int port){
		this.host = host;
		this.port = port;
	}
	
	public void connect() throws UnknownHostException, IOException{

		socket = new Socket();
		socket.connect(new InetSocketAddress(host, port), 2000);
		
		outStream = socket.getOutputStream();
		inputStream = socket.getInputStream();
	}
	
	public void send(BridgeCommand command) throws IOException{
		Gson gson = new Gson();
		String sendData = gson.toJson(command);
        byte[] paramBytes = sendData.getBytes(ENCODING);
        outStream.write(paramBytes);
        outStream.flush();
	}
	public BridgeCommand getRespond() throws IOException{
		StringWriter writer = new StringWriter();
		Gson gson = new Gson();
		IOUtils.copy(inputStream, writer, ENCODING);
		
		System.out.println("DEBUG " + writer.toString());
		
		return gson.fromJson(writer.toString(), BridgeCommand.class);
	}
	
	public void disconnect() throws IOException{
		outStream.close();
		socket.close();
	}
	
}
