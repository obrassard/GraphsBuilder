package ca.obrassard.GraphsBuilder.graphs;

import java.util.List;

/**
 * Graph
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public interface Graph<T> {

    /**
     * Get the graph's order (the number of vertices)
     * @return the graph's order
     */
    int getOrder();

    /**
     * Check if the graph is empty (doesn't have any vertex)
     * @return true is the graph is empty
     */
    boolean isEmpty();

    /**
     * Get a collection of all vertices
     * @return a List of vertices
     */
    List<? extends Vertex<T>> getVertices();

    /**
     * Get a collection of all edges
     * @return a List of Edges
     */
    List<? extends Edge<T>> getEdges();

    /**
     * Get the first Vertex that was added to the graph
     * @return A the first vertex object
     */
    Vertex<T> getFirstVertex();


    /**
     * Add a new, unlinked vertex to the graph
     * @param value The new vertex's value
     * @return The created vertex
     */
    Vertex<T> addVertex(T value);

    /**
     * Add a new, unlinked vertex to the graph
     * @param value The new vertex's value
     * @param identifier A unique identifier for this vertex
     * @return The created vertex
     */
    Vertex<T> addVertex(T value, String identifier);

    /**
     * Remove a given vertex (and all its links) from the graph
     * @param vertex The vertex to remove
     */
    void removeVertex(Vertex<T> vertex);

    /**
     * Creates a new edge without weight between two existing vertices of the graph
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @return The new created edge
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    Edge<T> linkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2) throws IllegalStateException;

    /**
     * Creates a new edge whit a given weight between two existing vertices of the graph
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @param weight The weight
     * @return The new created edge
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    Edge<T> linkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2, Integer weight) throws IllegalStateException;

    /**
     * Remove every existing links present between two vertices
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    void unlinkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2) throws IllegalStateException;

    /**
     * Remove every existing links connected to a given vertex
     * @param vertex Vertex to unlink
     * @throws IllegalStateException if the vertex is not actually present in the graph
     */
    void unlinkVertex(Vertex<T> vertex) throws IllegalStateException;

    /**
     * Remove a given edge from the graph
     * @param edge The edge to remove
     * @throws IllegalStateException if the edge is not actually present in the graph
     */
    void unlink(Edge<T> edge) throws IllegalStateException;

    /**
     * Find a specific vertex by it's id
     * @param identifier The vertex id
     * @return The first vertex of the graph that have this identifier or null
     */
    Vertex<T> findById(String identifier);

    Graph<T> clone();
}
