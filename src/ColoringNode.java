import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

public class ColoringNode extends Node {
    public Node parent;

    @Override
    public void onStart() {
        setColor(Color.getColorAt(getID()));
    }
}