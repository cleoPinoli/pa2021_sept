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

    private int nextInstruction;

    public Program (){
        this(new ArrayList<>());
    }

    public Program(List<Command> commands){
        children = commands; // deep copy?
        nextInstruction = 0;
    }

    public void run(MyPlane plane){
        runFrom(plane, 0);
    }

    public void runNextInstruction (MyPlane plane) {
        if (nextInstruction<children.size()) {
        children.get(nextInstruction++).execute(plane); }
    }


    public void runFrom (MyPlane plane, int fromIndex){
        for (int i=fromIndex; i<children.size(); i++) {
            runNextInstruction(plane);
        }
        nextInstruction = children.size();
    }

    public void runFrom (MyPlane plane) {
        runFrom(plane, nextInstruction);
    }

    public List<Command> getChildren() { return children; }

    public void resetProgram () {
        nextInstruction = 0;
    }
    public void add (Command cmd) {
        children.add(cmd);
    }

    public void remove (Command cmd) {
        children.remove(cmd);
    }

}
