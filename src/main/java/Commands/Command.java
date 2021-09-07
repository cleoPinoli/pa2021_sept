package Commands;
import CorePackage.MyPlane;

public interface Command {
    void execute (MyPlane plane);

    String getName();

}
