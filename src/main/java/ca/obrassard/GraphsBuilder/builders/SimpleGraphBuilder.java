package ca.obrassard.GraphsBuilder.builders;

import ca.obrassard.GraphsBuilder.graphs.simple.SimpleGraph;

/**
 * SimpleGraphBuilder
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public class SimpleGraphBuilder<T> extends GraphBuilder<T> {

    /**
     * Create a new SimpleGraphBuilder instance
     */
    public SimpleGraphBuilder() {
        super(new SimpleGraph<>());
    }

    /**
     * Build and return the graph;
     * @return The builded graph
     */
    @Override
    public SimpleGraph<T> build() {
        return (SimpleGraph<T>) super.build();
    }

    /**
     * Create and add a new 'anonymous' vertex to the builded graph
     *
     * @param vertexValue The vertex value
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> add(T vertexValue) {
        super.add(vertexValue);
        return this;
    }

    /**
     * Create and add a new vertex with an identifer to the builded graph.
     * <p>
     * This identifier should be unique and can be used to reference
     * this vertex in link() statements of this builder,
     * or to find a given vertex in the builded graph.
     *
     * @param vertexValue The value of the vertex to create
     * @param identifier  An identifier for this vertex (should be unique in a graph)
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> add(T vertexValue, String identifier) {
        super.add(vertexValue, identifier);
        return this;
    }

    /**
     * Link two previously added vertex with their identifiers.
     *
     * @param identifier1 First vertex's identifier
     * @param identifier2 Second vertex's identifier
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> link(String identifier1, String identifier2) {
        super.link(identifier1, identifier2);
        return this;
    }

    /**
     * Link two previously added vertex by their identifiers.
     *
     * @param identifier1 First vertex's identifier
     * @param identifier2 Second vertex's identifier
     * @param linkWeight  The weight to assign to the link
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> link(String identifier1, String identifier2, Integer linkWeight) {
        super.link(identifier1, identifier2, linkWeight);
        return this;
    }

    /**
     * Create a new 'anonymous' vertex and link it to a previously
     * added vertex based on its identifier.
     *
     * @param vertexValue      The value of the vertex to create
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> addAndlink(T vertexValue, String identifierToLink) {
        super.addAndlink(vertexValue, identifierToLink);
        return this;
    }

    /**
     * Create a new 'anonymous' vertex and link it to a previously
     * added vertex based on its identifier.
     *
     * @param vertexValue      The value of the vertex to create
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @param linkWeight       The weight to assign to the new link
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> addAndlink(T vertexValue, String identifierToLink, Integer linkWeight) {
        super.addAndlink(vertexValue, identifierToLink, linkWeight);
        return this;
    }

    /**
     * Create a new identified vertex, and link it to another vertex
     *
     * @param vertexValue      The value of the vertex to create
     * @param identifier       The identifier for the new vertex
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> addAndlink(T vertexValue, String identifier, String identifierToLink) {
        super.addAndlink(vertexValue, identifier, identifierToLink);
        return this;
    }

    /**
     * Create a new identified vertex, and link it to another vertex
     *
     * @param vertexValue      The value of the vertex to create
     * @param identifier       The identifier for the new vertex
     * @param identifierToLink The identifier of the vertex to link to the new vertex
     * @param linkWeight       The weight to assign to the new link
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> addAndlink(T vertexValue, String identifier, String identifierToLink, Integer linkWeight) {
        super.addAndlink(vertexValue, identifier, identifierToLink, linkWeight);
        return this;
    }

    /**
     * Create N vertices and link them together
     *
     * @param values The values of the vertices to create
     * @return The GraphBuilder instance
     */
    @Override
    public SimpleGraphBuilder<T> addAndLinkAll(T... values) {
        super.addAndLinkAll(values);
        return this;
    }
}

