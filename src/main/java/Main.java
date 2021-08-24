

public class Main {

    public static void main (String[] argv) {

        //System.out.println("Hewwo");
        FileReader reader = new FileReader();
        reader.readFile();

        MyPlane blane = new MyPlane(50, 50);
        blane.printGrid();

        blane.moveCursor(10, true);

        blane.printGrid();

    }
}
//TODO LIST: -line size; -interpreter; -close area; -repeat n cmds; -tests; -exceptions; -javadoc;