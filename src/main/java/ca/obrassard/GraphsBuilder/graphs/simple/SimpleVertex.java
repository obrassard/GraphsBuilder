package ca.obrassard.GraphsBuilder.graphs.simple;

import ca.obrassard.GraphsBuilder.graphs.Edge;
import ca.obrassard.GraphsBuilder.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleVertex
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class SimpleVertex<T> extends Vertex<T> {

    private final List<Link<T>> neighbours;

    public SimpleVertex(T value) {
        super(value);
        neighbours = new ArrayList<>();
    }

    public SimpleVertex(T value, String identifier) {
        super(value, identifier);
        this.neighbours = new ArrayList<>();
    }

    public int getOrder() {
        return neighbours.size();
    }

    @Override
    public List<? extends Edge<T>> getLinkedVertices() {
        return new ArrayList<>(neighbours);
    }

    protected void link(Link<T> link) {
        neighbours.add(link);
    }

    protected void unlink(Link<T> link) {
        neighbours.remove(link);
    }
}
