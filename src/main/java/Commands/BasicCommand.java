package Commands;

import Exceptions.MissingArgumentException;

import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Not sure what I intended to do here: do we want the commands' execution to be using Path and JFX elements?
 * Do we want to register the commands left to execute so that we can add the dynamic execution?
 * I don't think providing the number of parameters required per command was my goal here, cause, like, we know that already.
 * It must have something to do with dynamic execution.
 *
 *
 *
 */


public abstract class BasicCommand implements Command {

    protected String getNextToken(Queue<String> context) throws MissingArgumentException {
        String token = ""; //TODO maybe throw another e in case token is still null
        try {
            token = context.remove();
        } catch (NoSuchElementException e) {
            throw new MissingArgumentException("Couldn't find any parameter for instruction: " + this.getName());
        }

        return token;
    }



}
