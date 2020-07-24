package ca.obrassard.GraphsBuilder.graphs.simple;

import ca.obrassard.GraphsBuilder.graphs.Edge;
import ca.obrassard.GraphsBuilder.graphs.Graph;
import ca.obrassard.GraphsBuilder.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleGraph
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class SimpleGraph<T> implements Graph<T> {

    private final List<SimpleVertex<T>> vertices;
    private final List<Link<T>> links;

    public SimpleGraph() {
        vertices = new ArrayList<>();
        links = new ArrayList<>();
    }

    /**
     * Get the graph's order (the number of vertices)
     *
     * @return the graph's order
     */
    @Override
    public int getOrder() {
        return vertices.size();
    }

    /**
     * Check if the graph is empty (doesn't have any vertex)
     *
     * @return true is the graph is empty
     */
    @Override
    public boolean isEmpty() {
        return getOrder() > 0;
    }

    /**
     * Get a collection of all vertices
     *
     * @return a List of vertices
     */
    @Override
    public List<SimpleVertex<T>> getVertices() {
        return new ArrayList<>(vertices);
    }

    /**
     * Get a collection of all edges
     *
     * @return a List of Edges
     */
    @Override
    public List<Link<T>> getEdges() {
        return new ArrayList<>(links);
    }

    /**
     * Get the first Vertex that was added to the graph
     *
     * @return A the first vertex object
     */
    @Override
    public SimpleVertex<T> getFirstVertex() {
        if (isEmpty())
            return null;
        return vertices.get(0);
    }

    /**
     * Add a new, unlinked vertex to the graph
     *
     * @param value The new vertex's value
     * @return The created vertex
     */
    @Override
    public SimpleVertex<T> addVertex(T value) {
        SimpleVertex<T> vertex = new SimpleVertex<>(value);
        vertices.add(vertex);
        return vertex;
    }

    /**
     * Add a new, unlinked vertex to the graph
     *
     * @param value      The new vertex's value
     * @param identifier A unique identifier for this vertex
     * @return The created vertex
     */
    @Override
    public SimpleVertex<T> addVertex(T value, String identifier) {
        SimpleVertex<T> vertex = new SimpleVertex<>(value, identifier);
        vertices.add(vertex);
        return vertex;
    }

    /**
     * Remove a given vertex (and all its links) from the graph
     *
     * @param vertex The vertex to remove
     */
    @Override
    public void removeVertex(Vertex<T> vertex) {
        unlinkVertex(vertex);
        vertices.remove(vertex);
    }

    /**
     * Creates a new edge without weight between two existing vertices of the graph
     *
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @return The new created edge
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    public Link<T> linkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2) throws IllegalStateException {
        return linkVertices(endpoint1,endpoint2, null);
    }

    /**
     * Creates a new edge whit a given weight between two existing vertices of the graph
     *
     * @param endpoint1 First vertex
     * @param endpoint2 Second vertex
     * @param weight    The weight
     * @return The new created edge
     * @throws IllegalStateException if one of the given vertices is not actually present in the graph
     */
    @Override
    public Link<T> linkVertices(Vertex<T> endpoint1, Vertex<T> endpoint2, Integer weight) throws IllegalStateException, IllegalArgumentException {
        if (!vertices.contains(endpoint1) || !vertices.contains(endpoint2)) {
            throw new IllegalStateException();
        } else {
            SimpleVertex<T> e1 = (SimpleVertex<T>) endpoint1;
            SimpleVertex<T> e2 = (SimpleVertex<T>) endpoint2;
            Link<T> link = new Link<>(e1, e2);

            if (weight != null && weight > 0) {
                link.setWeight(weight);
            }

            links.add(link);
            return link;
        }
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
        if (!vertices.contains(endpoint1) || !vertices.contains(endpoint2)) {
            throw new IllegalStateException();
        }
        for (int i = links.size() -1; i >= 0; i--) {
            Link<T> link = links.get(i);
            if (link.contains(endpoint1) && link.contains(endpoint2)) {
                unlink(link);
            }
        }
    }

    /**
     * Remove every existing links connected to a given vertex
     *
     * @param vertex Vertex to unlink
     * @throws IllegalStateException if the vertex is not actually present in the graph
     */
    @Override
    public void unlinkVertex(Vertex<T> vertex) throws IllegalStateException {
        if (!vertices.contains(vertex)) {
            throw new IllegalStateException();
        }
        for (int i = links.size() -1; i >= 0; i--) {
            Link<T> link = links.get(i);
            if (link.contains(vertex)) {
                unlink(link);
            }
        }
    }

    /**
     * Remove a given edge from the graph
     *
     * @param edge The edge to remove
     * @throws IllegalStateException if the edge is not actually present in the graph
     */
    @Override
    public void unlink(Edge<T> edge) throws IllegalStateException {
        if (!links.contains(edge)) throw new IllegalStateException();

        Link<T> link = (Link<T>) edge;
        link.getEndpoint1().unlink(link);;
        link.getEndpoint2().unlink(link);;
        links.remove(link);
    }

    /**
     * Find a specific vertex by it's id
     *
     * @param identifier The vertex id
     * @return The first vertex of the graph that have this identifier or null
     */
    @Override
    public SimpleVertex<T> findById(String identifier) {
        for (SimpleVertex<T> v: vertices) {
            if (v.getIdentifier().equals(identifier))
                return v;
        }
        return null;
    }

    @Override
    public SimpleGraph<T> clone() {
        //TODO
        throw new UnsupportedOperationException();
    }
}