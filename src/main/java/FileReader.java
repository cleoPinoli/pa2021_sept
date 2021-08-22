import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {


    public List<String> readFile () {

        List<String> fileContent = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/Test.txt")));
        fileContent =  reader.lines().map( str -> str.split(" ")).collect(Collectors.toList());

        return  fileContent;
    }


}
