package ca.obrassard.GraphsBuilder.graphs.directed;

import ca.obrassard.GraphsBuilder.graphs.Edge;
import ca.obrassard.GraphsBuilder.graphs.Graph;
import ca.obrassard.GraphsBuilder.graphs.Vertex;

import java.util.List;

/**
 * DirectedGraph
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class DirectedGraph<T> implements Graph<T> {
    /**
     * Get the graph's order (the number of vertices)
     *
     * @return the graph's order
     */
    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * Check if the graph is empty (doesn't have any vertex)
     *
     * @return true is the graph is empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Get a collection of all vertices
     *
     * @return a List of vertices
     */
    @Override
    public List<? extends Vertex<T>> getVertices() {
        return null;
    }

    /**
     * Get a collection of all edges
     *
     * @return a List of Edges
     */
    @Override
    public List<? extends Edge<T>> getEdges() {
        return null;
    }

    /**
     * Get the first Vertex that was added to the graph
     *
     * @return A the first vertex object
     */
    @Override
    public Vertex<T> getFirstVertex() {
        return null;
    }

    /**
     * Add a new, unlinked vertex to the graph
     *
     * @param value The new vertex's value
     * @return The created vertex
     */
    @Override
    public Vertex<T> addVertex(T value) {
        return null;
    }

    /**
     * Add a new, unlinked vertex to the graph
     *
     * @param value      The new vertex's value
     * @param identifier A unique identifier for this vertex
     * @return The created vertex
     */
    @Override
    public Vertex<T> addVertex(T value, String identifier) {
        return null;
    }

    /**
     * Remove a given vertex (and all its links) from the graph
     *
     * @param vertex The vertex to remove
     */
    @Override
    public void removeVertex(Vertex<T> vertex) {

    }

    /**
     * Creates a new edge without weight between two existing vertices of the graph
     *
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @return The new created edge
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    @Override
    public Edge<T> linkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2) throws IllegalStateException {
        return null;
    }

    /**
     * Creates a new edge whit a given weight between two existing vertices of the graph
     *
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @param weight    The weight
     * @return The new created edge
     * @throws IllegalStateException    if one of the given vertices is not actually present in the graph
     * @throws IllegalArgumentException If the weight is <= 0
     */
    @Override
    public Edge<T> linkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2, Integer weight) throws IllegalStateException, IllegalArgumentException {
        return null;
    }

    /**
     * Remove every existing links present between two vertices
     *
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    @Override
    public void unlinkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2) throws IllegalStateException {

    }

    /**
     * Remove every existing links connected to a given vertex
     *
     * @param vertex Vertex to unlink
     * @throws IllegalStateException if the vertex is not actually present in the graph
     */
    @Override
    public void unlinkVertex(Vertex<T> vertex) throws IllegalStateException {

    }

    /**
     * Remove a given edge from the graph
     *
     * @param edge The edge to remove
     * @throws IllegalStateException if the edge is not actually present in the graph
     */
    @Override
    public void unlink(Edge<T> edge) throws IllegalStateException {

    }

    /**
     * Find a specific vertex by it's id
     *
     * @param identifier The vertex id
     * @return The first vertex of the graph that have this identifier or null
     */
    @Override
    public Vertex<T> findById(String identifier) {
        return null;
    }

    @Override
    public Graph<T> clone() {
        return null;
    }
}
