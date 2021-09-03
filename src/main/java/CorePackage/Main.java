package CorePackage;

import Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] argv) {

        MyPlane blane = new MyPlane(100, 100);

        List<Command> commands = new ArrayList<>(BasicParser.getParser().parseInstructions("/Test.txt"));
        Program program = new Program(commands);
        program.run(blane);

        blane.printGrid();

    }
}
//TODO LIST: -line size; -close area; -tests; -exceptions; -javadoc; clear file?