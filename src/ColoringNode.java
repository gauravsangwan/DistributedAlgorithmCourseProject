import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

// Uncomment the following class for 3 coloring algorithm
//public class ColoringNode extends Node {
//    public Node parent;
//
//    @Override
//    public void onStart() {
//        setColor(Color.getColorAt(getID()));
//    }
//}


// 6 coloring algorithm comment this if using 3 coloring algorithm
public class ColoringNode extends Node {
    public Node parent; // defined in Main()

    private int[] colorsUsed = new int[3]; // Array to keep track of colors used by neighbors
    private int myColor = -1; // Initialize with an undefined color

    @Override
    public void onStart() {
        // Color assignment based on node ID
        myColor = getID() % 3; // Colors 0, 1, 2
        setColor(getColorFromInt(myColor));

        // Inform neighbors about our color
        informNeighbors();
    }

    @Override
    public void onMessage(Message message) {
        int neighborColor = (int) message.getContent();
        if (neighborColor != -1) {
            colorsUsed[neighborColor] = 1;
        }
        chooseColor();
    }

    private void informNeighbors() {
        sendAll(new Message(myColor));
    }

    private void chooseColor() {
        for (int i = 0; i < 3; i++) {
            if (colorsUsed[i] == 0) {
                myColor = i;
                setColor(getColorFromInt(myColor));
                informNeighbors();
                break;
            }
        }
    }

    private Color getColorFromInt(int colorInt) {
        switch (colorInt) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            default:
                return Color.WHITE; // Default color if not within 0-2
        }
    }
}
