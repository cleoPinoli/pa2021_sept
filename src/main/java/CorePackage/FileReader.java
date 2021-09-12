package CorePackage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
            Objects.requireNonNull(new FileInputStream(path))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  reader.lines().flatMap( str -> Stream.of(str.split(" ")))
                .collect(Collectors.toCollection(LinkedList::new));
    }


}
