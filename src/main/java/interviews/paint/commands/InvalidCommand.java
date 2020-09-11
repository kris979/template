package interviews.paint.commands;

public class InvalidCommand implements Command {
	
	private final String DEFAULT_HELP = "Please, use one of the following commands:\n" + 
			"C w h\n" + 
			"L x1 y1 x2 y2\n" + 
			"R x1 y1 x2 y2\n" + 
			"Q - quit\n";
	
	private final  String msg;

	public InvalidCommand() {
		super();
		this.msg = DEFAULT_HELP;
	}
	
	public InvalidCommand(String msg) {
		super();
		this.msg = msg + "\n" + DEFAULT_HELP;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public void execute() {
		System.out.print(msg);
	}

}
