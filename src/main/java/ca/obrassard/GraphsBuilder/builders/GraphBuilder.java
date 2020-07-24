package ca.obrassard.GraphsBuilder.builders;

import ca.obrassard.GraphsBuilder.graphs.Graph;
import ca.obrassard.GraphsBuilder.graphs.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * GraphBuilder
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public abstract class GraphBuilder<T> {

    protected Graph<T> graph;

    protected GraphBuilder(Graph<T> graph) {
        this.graph = graph;
    }
    
    /**
     * Create and add a new 'anonymous' vertex to the builded graph
     * @param vertexValue The vertex value
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> add(T vertexValue) {
        assertNotBuilt();
        graph.addVertex(vertexValue);
        return this;
    }

    /**
     * Create and add a new vertex with an identifer to the builded graph.
     *
     * This identifier should be unique and can be used to reference
     * this vertex in link() statements of this builder,
     * or to find a given vertex in the builded graph.
     *
     * @param vertexValue The value of the vertex to create
     * @param identifier An identifier for this vertex (should be unique in a graph)
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> add(T vertexValue, String identifier) {
        assertNotBuilt();
        graph.addVertex(vertexValue,identifier);
        return this;
    }

    /**
     * Link two previously added vertex with their identifiers.
     * @param identifier1 First vertex's identifier
     * @param identifier2 Second vertex's identifier
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> link(String identifier1, String identifier2) {
        return link(identifier1, identifier2,  0);
    }

    /**
     * Link two previously added vertex by their identifiers.
     * @param identifier1 First vertex's identifier
     * @param identifier2 Second vertex's identifier
     * @param linkWeight The weight to assign to the link
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> link(String identifier1, String identifier2, Integer linkWeight) {
        assertNotBuilt();
        Vertex<T> v1 = findOrFail(identifier1);
        Vertex<T> v2 = findOrFail(identifier2);
        graph.linkVertices(v1, v2, linkWeight);
        return this;
    }

    /**
     * Create a new 'anonymous' vertex and link it to a previously
     * added vertex based on its identifier.
     * @param vertexValue The value of the vertex to create
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> addAndlink(T vertexValue, String identifierToLink) {
        return addAndlink(vertexValue, null, identifierToLink, 0);
    }

    /**
     * Create a new 'anonymous' vertex and link it to a previously
     * added vertex based on its identifier.
     * @param vertexValue The value of the vertex to create
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @param linkWeight The weight to assign to the new link
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> addAndlink(T vertexValue, String identifierToLink, Integer linkWeight) {
        return addAndlink(vertexValue,null, identifierToLink, linkWeight);
    }

    /**
     * Create a new identified vertex, and link it to another vertex
     * @param vertexValue The value of the vertex to create
     * @param identifier The identifier for the new vertex
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> addAndlink(T vertexValue, String identifier, String identifierToLink) {
        return addAndlink(vertexValue, identifier, identifierToLink, 0);
    }

    /**
     * Create a new identified vertex, and link it to another vertex
     * @param vertexValue The value of the vertex to create
     * @param identifier The identifier for the new vertex
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @param linkWeight The weight to assign to the new link
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> addAndlink(T vertexValue, String identifier, String identifierToLink, Integer linkWeight) {
        assertNotBuilt();
        Vertex<T> v2 = findOrFail(identifierToLink);
        Vertex<T> v1 = graph.addVertex(vertexValue, identifier);

        graph.linkVertices(v1, v2, linkWeight);
        return this;
    }
    /**
     * Create N vertices and link them together
     * @param values The values of the vertices to create
     * @return The GraphBuilder instance
     */
    public GraphBuilder<T> addAndLinkAll(T... values) {
        assertNotBuilt();
        List<Vertex<T>> vertices = new ArrayList<>();

        for (T v: values) {
            Vertex<T> vertex = graph.addVertex(v);
            vertices.add(vertex);
        }

        for (int i = 0; i < vertices.size() - 1; i++) {
            for (int j = i+1; j < vertices.size(); j++) {
                graph.linkVertices(vertices.get(i), vertices.get(j));
            }
        }

        return this;
    }

    /**
     * Build and return the graph;
     * @return The builded graph
     */
    public Graph<T> build() {
        assertNotBuilt();
        Graph<T> finalGraph = graph;
        this.graph = null;
        return finalGraph;
    }

    private Vertex<T> findOrFail(String vertexId) {
        Vertex<T> vertex = graph.findById(vertexId);
        if (vertex == null)
            throw new IllegalArgumentException("Couldn't find vertex " + vertexId + ". This is not a valid identifier.");
        return vertex;
    }

    private void assertNotBuilt(){
        if (graph == null) {
            throw new IllegalStateException("This operation cannot be called after 'build()'.");
        }
    }
}
