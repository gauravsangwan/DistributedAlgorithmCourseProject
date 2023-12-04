import io.jbotsim.core.Color;
import io.jbotsim.core.Message;
import io.jbotsim.core.Node;

public class GeoNode extends Node {
    @Override
    public void onMessage(Message message) {
        Bundle bundle = (Bundle)message.getContent();
        if (bundle.target.equals(getLocation())) {
            System.out.println("Message reçu : " + bundle.text);
        }else{
            route(bundle);
        }
    }
    public void route(Bundle bundle){
        setColor(Color.red);
        // Make a routing choice (work to do)
    }
}