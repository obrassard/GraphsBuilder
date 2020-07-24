package ca.obrassard.GraphsBuilder.graphs.directed;

import ca.obrassard.GraphsBuilder.graphs.Edge;
import ca.obrassard.GraphsBuilder.graphs.Vertex;

/**
 * Arcs
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class Arcs<T> extends Edge<T> {
    @Override
    public Vertex getEndpoint1() {
        return null;
    }

    @Override
    public Vertex getEndpoint2() {
        return null;
    }

    @Override
    public Vertex getDestinationVertex(Vertex currentVertex) {
        return super.getDestinationVertex(currentVertex);
    }
}
