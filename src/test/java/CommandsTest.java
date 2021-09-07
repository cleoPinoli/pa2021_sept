import Commands.CmdMoveCursorFwd;
import Commands.Command;
import CorePackage.CursorPoint;
import CorePackage.MyPlane;
import CorePackage.Point2D;
import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import org.junit.jupiter.api.Test;
import CorePackage.BasicParser;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class CommandsTest {


    @Test
    void moveCursorFwdTest() {
        MyPlane plane = new MyPlane(800, 600);
        Queue<String> testContext = new LinkedList<>();
        Queue<Command> parsedInstructions = new LinkedList<>();

        testContext.add("FORWARD");
        testContext.add("1");

        parsedInstructions.addAll(BasicParser.getParser().parseInstructions(testContext));
        assertTrue(parsedInstructions.peek() instanceof CmdMoveCursorFwd);

        parsedInstructions.peek().execute(plane);
        assertTrue(plane.getMyCursor().getPosition().equals(new CursorPoint(401, 300))); //todo equals?
    }

    @Test
    void moveFwdInvalidArgumentTest () {
        Queue<String> testContext = new LinkedList<>();
        testContext.add("-10");


        assertThrows(InvalidArgumentException.class, () -> new CmdMoveCursorFwd(testContext));
    } //TODO test all possible mistakes

    @Test
    void moveFwdMissingArgumentTest() {
        Queue<String> testContext = new LinkedList<>();
        assertThrows(MissingArgumentException.class, () -> new CmdMoveCursorFwd(testContext));

    }

}
