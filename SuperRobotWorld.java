
package robot_world;

import java.io.IOException;

public class SuperRobotWorld extends RobotWorld {

	// clockwise rotation = 1; anticlockwise rotation = 2; move forward = 3;
	private Stack<Integer> history = new LinkedListStack();
	private Stack<Integer> undoneCom = new LinkedListStack();
	
	
    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
    }
    
    public void rotateClockwise() {
    	history.push(1);
    	super.rotateClockwise();
    }
    
    public void rotateCounterClockwise() {
    	history.push(2);
    	super.rotateCounterClockwise();
    }
    
    public void moveForward() throws Exception{
    	history.push(3);
    	super.moveForward();
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        int x;
		try {
			x = history.pop();
		} catch (Exception e) {
			System.out.println("No commands to undo");
			return;
		}
		undoneCom.push(x);
        if (x == 1) {
        	super.rotateCounterClockwise();
        }
        if (x == 2) {
        	super.rotateClockwise();
        }
        if (x == 3) {
        	super.rotateClockwise();
        	super.rotateClockwise();
        	try {
				super.moveForward();
			} catch (Exception e) {
				return;
			}
        	super.rotateClockwise();
        	super.rotateClockwise();
        }
    }
    
    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
    	for (int i = 0; i < n; ++i) {
    		this.undoCommand();
    	}
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        int x;
    	try {
			x = undoneCom.pop();
		} catch (Exception e) {
			System.out.println("No commands to redo");
			return;
		}
        if (x == 1) {
        	super.rotateClockwise();
        }
        if (x == 2) {
        	super.rotateCounterClockwise();
        }
        if (x == 3) {
        	try {
				super.moveForward();
			} catch (Exception e) {
				return;
			}
        }
        
        
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
    	for (int i = 0; i < n; ++i) {
    		this.redoUndoneCommand();
    	}
    }
}
