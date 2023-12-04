import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;
import io.jbotsim.core.Point;
public class GeoNode extends Node {
    @Override
    public void onMessage(Message message) {
        Bundle bundle = (Bundle)message.getContent();
        if (bundle.target.equals(getLocation())) {
            System.out.println("Message received : " + bundle.text);
        }else{
            route(bundle);
        }
    }
    public void route(Bundle bundle){
        setColor(Color.red);
        Point targetLocation = bundle.target;
        double minDistance = Double.MAX_VALUE;
        Node closestNeighbor = null;

        for (Node neighbor : getNeighbors()) {
            Point neighborLocation = neighbor.getLocation();
            double distanceToTarget = neighborLocation.distance(targetLocation);
            if (distanceToTarget < minDistance) {
                minDistance = distanceToTarget;
                closestNeighbor = neighbor;
            }
        }

        if (closestNeighbor != null) {
            send(closestNeighbor, new Message(bundle));
        }
    }
}