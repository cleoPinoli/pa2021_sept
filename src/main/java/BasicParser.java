import CorePackage.FileReader;
import java.util.LinkedList;
import java.util.List;

public class BasicParser {
    private FileReader fileReader; //filename aaa

    public BasicParser() {
        fileReader = new FileReader();

        //this.instructionsList = FileReader.readFile(); NOT SURE WE NEED THIS, Y'KNOW, MAYBE PASS A LIST TO THE METHOD
    }

    public void parseInstructions(List<String> instructionsList) {
        for (String word : instructionsList) { //this is the most terrible idea i was capable of doing


        }

    }


}
