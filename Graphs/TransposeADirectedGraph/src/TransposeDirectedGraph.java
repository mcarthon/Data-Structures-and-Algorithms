import java.util.ArrayList;
import java.util.List;

public class TransposeDirectedGraph {

    public GraphNode transpose ( GraphNode node ) {

        List<GraphNode> visited = new ArrayList<GraphNode>();

        return this.helper ( node, visited );

    }

    public GraphNode helper (GraphNode node, List<GraphNode> visited ) {

        ArrayList<GraphNode> copyOfNeighbors = new ArrayList<GraphNode>( node.neighbors );

        for ( GraphNode neighbor : copyOfNeighbors ) {

            if ( !visited.contains ( neighbor ) ) {

                node.neighbors.remove ( neighbor );

                GraphNode transposedNeighbor = this.helper ( neighbor, visited );

                transposedNeighbor.neighbors.add ( node );

                visited.add ( neighbor );

            }


        }

        return node;

    }

}