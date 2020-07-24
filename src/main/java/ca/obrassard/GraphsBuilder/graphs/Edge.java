package ca.obrassard.GraphsBuilder.graphs;

/**
 * Edge
 * By: Olivier Brassard
 * Project : graphBuilder
 * Date: 2020-07-23
 */
public abstract class Edge<T> {
    protected Integer weight;

    public abstract Vertex<T> getEndpoint1();
    public abstract Vertex<T> getEndpoint2();

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean contains(Vertex<T> vertex) {
        return (getEndpoint1() == vertex || getEndpoint2() == vertex);
    }

    public Vertex<T> getDestinationVertex(Vertex<T> currentVertex) {
        if (getEndpoint1() == currentVertex) {
            return getEndpoint2();
        } else if (getEndpoint2() == currentVertex) {
            return getEndpoint1();
        }
        throw new IllegalArgumentException();
    }

}
