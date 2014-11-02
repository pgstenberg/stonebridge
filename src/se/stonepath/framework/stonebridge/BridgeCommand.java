package se.stonepath.framework.stonebridge;


public class BridgeCommand {
	private boolean ContainsError;
	private String ErrorMessage;
	private String Command;
	private String[] Arguments;
	
	public BridgeCommand(String command,String[] arguments){
		this.ContainsError = false;
		this.ErrorMessage = "";
		this.Command = command;
		this.Arguments = arguments;
	}
	
	public String getCommand(){
		return Command;
	}
	
	public String[] getArguments(){
		return Arguments;
	}
	
	public boolean containsErrors(){
		return ContainsError;
	}
	public String getErrorMessage(){
		return ErrorMessage;
	}
	
}
