package CorePackage;


import Commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Class container that can contain both leaves and other containers;
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class Program {

    private List<Command> children;

    public Program (){
        this(new ArrayList<>());
    }

    public Program(List<Command> commands){
        children = commands; // deep copy?
    }

    public void run(MyPlane plane){
        for (Command cmd: children) {
            cmd.execute(plane);
            System.out.println("Executed command: " + cmd.getClass());
        }
    }

    public List<Command> getChildren() { return children; }

    public void add (Command cmd) {
        children.add(cmd);
    }

    public void remove (Command cmd) {
        children.remove(cmd);
    }

}
