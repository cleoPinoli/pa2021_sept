package CorePackage;

import Commands.*;
import CorePackage.FileReader;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import Exceptions.ParsingException;

import java.util.*;
import java.util.function.Function;

public class BasicParser {

private static Map<String, CheckedFunction<Queue<String>, Command>> commandsMap;


    public BasicParser() {
        commandsMap = new HashMap<>();

        registerCommand("FORWARD", CmdMoveCursorFwd::new);
        registerCommand("BACKWARD", CmdMoveCursorBwd::new);
        registerCommand("RIGHT", CmdRotateRight::new);
        registerCommand("LEFT", CmdRotateLeft::new);
        registerCommand("PENUP", CmdPenUp::new);
        registerCommand("PENDOWN", CmdPenDown::new);
        registerCommand("HOME", CmdHome::new);
        registerCommand("REPEAT", CmdRepeat::new);
        registerCommand("SETFILLCOLOR", CmdSetFillColor::new);
        registerCommand("SETPENCOLOR", CmdSetPenColor::new);
        registerCommand("SETSCREENCOLOR", CmdSetBackgroundColor::new);
        registerCommand("SETPENSIZE", CmdSetPenSize::new);
        registerCommand("CLEARSCREEN", CmdClearPlane::new);
    }

    public static void registerCommand (String keyword, CheckedFunction<Queue<String>, Command> function) {
            commandsMap.put(keyword, function);
    }



    public static List<Command> parseInstructions(String path) {
        Queue<String> instructionsList = FileReader.readFile(path);
        return parseInstructions(instructionsList);
    }

    public static List<Command> parseInstructions(Queue<String> instructions) {
        List<Command> commandList = new LinkedList<>();
        try {
            while (!instructions.isEmpty()) {
                String token = instructions.remove();
                if (commandsMap.containsKey(token)) {
                    CheckedFunction<Queue<String>, Command> myFunction = commandsMap.get(token);
                    commandList.add(myFunction.apply(instructions) );
                }



            }

        } catch (ParsingException e) {
            System.out.println(e.getMessage());
        }

        return commandList;
    }


}
