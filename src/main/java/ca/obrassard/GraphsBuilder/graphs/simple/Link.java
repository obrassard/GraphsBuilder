package ca.obrassard.GraphsBuilder.graphs.simple;

import ca.obrassard.GraphsBuilder.graphs.Edge;

/**
 * Link
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class Link<T> extends Edge<T> {
    private SimpleVertex<T> endpoint1;
    private SimpleVertex<T> endpoint2;

    public Link(SimpleVertex<T> endpoint1, SimpleVertex<T> endpoint2, Integer weight) {
        if (weight != null && weight <= 0) {
            throw new IllegalArgumentException();
        }
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        linkVertices(endpoint1,endpoint2);
        this.weight = weight;
    }

    public Link(SimpleVertex<T> endpoint1, SimpleVertex<T> endpoint2) {
        this.endpoint1 = endpoint1;
        this.endpoint2 = endpoint2;
        linkVertices(endpoint1,endpoint2);
        this.weight = null;
    }

    private void linkVertices(SimpleVertex<T> endpoint1, SimpleVertex<T> endpoint2) {
        endpoint1.link(this);
        endpoint2.link(this);
    }

    public SimpleVertex<T> getEndpoint1() {
        return endpoint1;
    }

    public SimpleVertex<T> getEndpoint2() {
        return endpoint2;
    }

    public SimpleVertex<T> getDestinationVertex(SimpleVertex<T> currentVertex) {
        return (SimpleVertex<T>) super.getDestinationVertex(currentVertex);
    }
}
