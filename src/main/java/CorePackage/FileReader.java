package CorePackage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public static List<String> readFile () {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(FileReader.class.getResourceAsStream("/Test.txt"))));
        return  reader.lines().flatMap( str -> Stream.of(str.split(" ")))
                .collect(Collectors.toList());
    }


}
