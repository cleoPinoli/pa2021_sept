package CorePackage;

import Exceptions.InvalidArgumentException;
import Exceptions.MissingArgumentException;
import Exceptions.ParsingException;

import java.io.IOException;

@FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws ParsingException;
    }

