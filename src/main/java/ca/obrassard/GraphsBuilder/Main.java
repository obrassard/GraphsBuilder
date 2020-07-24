package ca.obrassard.GraphsBuilder;

import ca.obrassard.GraphsBuilder.graphs.simple.SimpleGraph;
import ca.obrassard.GraphsBuilder.builders.SimpleGraphBuilder;

public class Main {
    public static void main(String[] args) {
        SimpleGraphBuilder<Character> builder = new SimpleGraphBuilder<>();
        SimpleGraph<Character> graph = builder.add('a', "a")
                .addAndlink('b', "a")
                .add('c').build();

        System.out.println(graph.getOrder());
    }
}
