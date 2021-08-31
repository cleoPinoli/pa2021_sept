package CorePackage;
import Exceptions.ParsingException;

@FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws ParsingException;
    }

