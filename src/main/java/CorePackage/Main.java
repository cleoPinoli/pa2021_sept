package CorePackage;

public class Main {

    public static void main (String[] argv) {

        FileReader reader = new FileReader();
        reader.readFile("/Test.txt");


        MyPlane blane = new MyPlane(50, 50);
        blane.printGrid();

        blane.moveCursor(10, true);

        blane.printGrid();

    }
}
//TODO LIST: -line size; -interpreter; -close area; -tests; -exceptions; -javadoc; clear file?