package CorePackage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class implementing a file reader for parsing purposes.
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class FileReader {

    public static Queue<String> readFile (String path) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(FileReader.class.getResourceAsStream(path))));
        return  reader.lines().flatMap( str -> Stream.of(str.split(" ")))
                .collect(Collectors.toCollection(LinkedList::new));
    }


}
