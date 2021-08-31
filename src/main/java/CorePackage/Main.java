package CorePackage;

import Commands.Command;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.List;

public class Main {

    public static void main (String[] argv) {

        MyPlane blane = new MyPlane(100, 100);
        List<Command> commands = new ArrayList<>();
        BasicParser basicParser = new BasicParser();
        commands.addAll(basicParser.parseInstructions("/Test.txt"));

        for (Command cmd: commands) {
            cmd.execute(blane);
            System.out.println(blane.getCursor().getDirection());
        }


        blane.printGrid();

    }
}
//TODO LIST: -line size; -close area; -tests; -exceptions; -javadoc; clear file?