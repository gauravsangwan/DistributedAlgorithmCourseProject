import io.jbotsim.core.Topology;
import io.jbotsim.gen.basic.TopologyGenerators;
import io.jbotsim.ui.JTopology;
import io.jbotsim.ui.JViewer;

public class MainColoring {
    public final static int n = 11;
    public static void main(String[] args) {

        Topology tp = new Topology();
        tp.setDefaultNodeModel(ColoringNode.class);
        TopologyGenerators.generateRing(tp, n);
        tp.disableWireless();
        tp.shuffleNodeIds();

        for (int i = 0; i<n; i++){
            ColoringNode u = (ColoringNode) tp.getNodes().get(i);
            u.setLocation(u.getX()+250, u.getY()+100);
            u.parent = tp.getNodes().get((i+1) % n);
        }

        JTopology jtp = new JTopology(tp);
        jtp.addLinkPainter(new JParentLinkPainter());
        new JViewer(jtp);
        tp.start();
        tp.pause();
    }
}