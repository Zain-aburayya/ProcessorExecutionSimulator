import components.simulation.Simulator;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Simulator simulator = new Simulator();
        simulator.run();
    }
}