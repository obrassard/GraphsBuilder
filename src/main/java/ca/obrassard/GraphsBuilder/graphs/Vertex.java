package ca.obrassard.GraphsBuilder.graphs;

import java.util.List;

/**
 * Vertex
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public abstract class Vertex<T> {
    private T value;
    private final String identifier;

    public Vertex(T value) {
        this.value = value;
        this.identifier = null;
    }

    public Vertex(T value, String identifier) {
        this.value = value;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract int getOrder();
    public abstract List<? extends Edge<T>> getLinkedVertices();

    @Override
    public String toString() {
        return "Vertex { value=" + value.toString() + " }";
    }
}
