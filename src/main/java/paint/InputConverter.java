package paint;

import java.util.Optional;

import paint.commands.Command;
import paint.commands.DrawCanvasCommand;
import paint.commands.InvalidCommand;
import paint.commands.QuitCommand;
import paint.drawable.InvalidShapeException;
import paint.drawable.Line;
import paint.drawable.Rectangle;

public class InputConverter {

	private final String canvasCmdPattern = "[Cc]\\s+\\d+\\s+\\d+";
	private final String lineCmdPattern = "[Ll]\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+";
	private final String rectangleCmdPattern = "[Rr]\\s+\\d+\\s+\\d+\\s+\\d+\\s+\\d+";
	private final String quitCmdPattern = "[Qq]";
	
	private static final String CANVAS_MISSING_ERR_MSG = "You need to create a canvas first.";
	private static final String SHAPE_OUTSIDE_ERR_MSG = "Shape would not fit on canvas. Try again.";
	
	private DrawCanvasCommand canvas;

	public Command convert(String input) {
		String[] split = input.split(" ");
		
		if (input.matches(canvasCmdPattern)) {
			
			return canvas(split[1],split[2]);
			
		} else if (input.matches(lineCmdPattern)) {
			
			return canvasWithAddedLine(split[1], split[2], split[3], split[4]);
			
		} else if (input.matches(rectangleCmdPattern)) {
			
			return canvasWithAddedRectangle(split[1], split[2], split[3], split[4]);
			
		} else if (input.matches(quitCmdPattern)) {
			
			return new QuitCommand();
			
		} else {
			
			return new InvalidCommand();
		}
	}

	private Command canvas(String width, String height) {
		canvas = new DrawCanvasCommand(Integer.parseInt(width), Integer.parseInt(height));
		return canvas;
	}

	private Optional<Command> validate(String x1, String y1, String x2, String y2) {
		if (canvas == null) {
			return Optional.of(new InvalidCommand(CANVAS_MISSING_ERR_MSG));
		}
		
		if (canvas.isOutside(Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2))) {
			return Optional.of(new InvalidCommand(SHAPE_OUTSIDE_ERR_MSG));
		}
		return Optional.empty();
	}

	private Command canvasWithAddedRectangle(String x1, String y1, String x2, String y2) {
		Optional<Command> error = validate(x1, y1, x2, y2);
		if (error.isPresent()) {
			return error.get();
		}
		try {
			Rectangle rectangle = new Rectangle(Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2));
			canvas.add(rectangle);
			return canvas;
		}catch (InvalidShapeException e) {
			return new InvalidCommand(e.getMessage());
		}
	}

	private Command canvasWithAddedLine(String x1, String y1, String x2, String y2) {
		Optional<Command> error = validate(x1, y1, x2, y2);
		if (error.isPresent()) {
			return error.get();
		}
		try {
			Line line = new Line(Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2));
			canvas.add(line);
			return canvas;
		} catch (InvalidShapeException e) {
			return new InvalidCommand(e.getMessage());
		}
	}

}

/**
 * I dont really like if else's in the covert() method. If I was doing this excercise again 
 * I would probalby reuse below code that I just found in my old project I wrote year's ago. 
 * 
 * 
 * creates objects without exposing the instantiation logic to the client. 
 * refers to the newly created object through a common interface
 * 
 * The advantage is:New commands can be added without changing a single line of code in the
 * client code that uses the commands from the factory.
 * 
 * Note: Downside - each new command needs to register with a factory.
 * 
 * public final class CommandsFactory {

    public static Map<String, Class<? extends Command>> commands = new HashMap<String, Class<? extends Command>>();

    public static void registerNewCommand(String commandName, Class<? extends Command> instance) {
        commands.put(commandName, instance);
    }

    public static Command newCommand(String commandName) {
        Class<? extends Command> command = commands.get(commandName);
        if (command == null) {
            throw new IllegalCommandException("Wrong command: " + command);
        }
        try {
            return command.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalCommandException("");
    }

}

 *
 */