package ca.obrassard.GraphsBuilder.graphs.directed;

import ca.obrassard.GraphsBuilder.graphs.Edge;
import ca.obrassard.GraphsBuilder.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * DirectedVertex
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class DirectedVertex<T> extends Vertex<T> {

    private final List<Arcs<T>> outerArcs;
    private final List<Arcs<T>> innerArcs;

    public DirectedVertex(T value) {
        super(value);
        innerArcs = new ArrayList<>();
        outerArcs = new ArrayList<>();
    }

    public DirectedVertex(T value, String identifier) {
        super(value, identifier);
        innerArcs = new ArrayList<>();
        outerArcs = new ArrayList<>();
    }

    /**
     * Return the outer order of this vertex
     * @return
     */
    @Override
    public int getOrder() {
        return outerArcs.size();
    }

    public int getInnerOrder() {
        return innerArcs.size();
    }

    @Override
    public List<? extends Edge<T>> getLinkedVertices() {
        return new ArrayList<>(outerArcs);
    }

    protected void linkStart(Edge<T> link) {

    }

    protected void linkDest(Edge<T> link) {

    }

    protected void unlink(Edge<T> link) {

    }
}
