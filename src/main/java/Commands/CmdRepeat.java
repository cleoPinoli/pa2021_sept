package Commands;
import CorePackage.MyPlane;

import java.util.LinkedList;
import java.util.List;

public class CmdRepeat implements Command{

    private int times;
    private List<Command> commandList = new LinkedList<>(); //perhaps not the most optimal solution but i'll see

    public CmdRepeat (int times, List<Command> commands) {
        this.times = times;
        commandList.addAll(commands);
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute(MyPlane plane) {
        for (int i=0; i<times; i++) {
            commandList.stream().forEach(s-> s.execute(plane));

        }
        //TODO si farà. stay tuned, che si farà.
    }
}
