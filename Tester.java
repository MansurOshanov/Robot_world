
package robot_world;

public class Tester {
    
    public static void main(String[] args) throws Exception {
        
        SuperRobotWorld rw = new SuperRobotWorld("src/robot_world/map1.txt");
        rw.printCurrentWorldMap();
        rw.rotateCounterClockwise();
        rw.printCurrentWorldMap();
        rw.moveForward();
        rw.printCurrentWorldMap();
        rw.rotateClockwise();
        rw.printCurrentWorldMap();
        rw.undoCommands(2);
        rw.printCurrentWorldMap();
        rw.redoUndoneCommands(2);
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.rotateClockwise();
        rw.moveForward();
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.printCurrentWorldMap();
       
    }
}
