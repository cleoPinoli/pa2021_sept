

public class Main {

    public static void main (String[] argv) {

        //System.out.println("Hewwo");
        FileReader reader = new FileReader();
        reader.readFile();

        MyPlane blane = new MyPlane(10, 10);
        blane.printGrid();

    }
}
