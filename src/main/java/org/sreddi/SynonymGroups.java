package org.sreddi;

import java.util.*;

/**
 *
 * a: b, c
 * d: e, f
 * c: e
 * u: v
 *
 * (a, e): T
 * (a, u): F
 *
 * Created by swarup on 3/29/17.
 */
public class SynonymGroups {


    private Set<Character> reachable(Map<Character, Set<Character>> graph, Character node0) {
        Set<Character> visited = new HashSet<>();
        Stack<Character> todo = new Stack<>();
        todo.push(node0);
        while (!todo.isEmpty()) {
            Character node = todo.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Character neighbor: graph.get(node)) {
                    todo.push(neighbor);
                }
            }
        }
        return visited;
    }

    Map<Character, Integer> createThesaurus(char[][] nonDisjointSynonymGroups) {

        // create graph of synonyms
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (char[] group: nonDisjointSynonymGroups) {
            for (int i = 0; i < group.length; i++) {
                char from = group[i];
                char to = group[(i+1) % group.length];
                if (graph.containsKey(from)) {
                    graph.get(from).add(to);
                } else {
                    graph.put(from, new HashSet<>(Arrays.asList(to)));
                }
            }
        }

        // create the thesaurus by finding all the reachable nodes from an unvisited node
        int synGroupId = 0;
        Map<Character, Integer> thesaurus = new HashMap<>(); // map: char -> groupId
        for (Character startNode: graph.keySet()) {
            if (!thesaurus.containsKey(startNode)) {
                for (Character node: reachable(graph, startNode)) {
                    thesaurus.put(node, synGroupId);
                }
                synGroupId++;
            }
        }

        return thesaurus;
    }

    boolean isSynonym(Map<Character, Integer> t, char node1, char node2) {
        return t.containsKey(node1) && t.containsKey(node2) ? t.get(node1) == t.get(node2) : node1 == node2;
    }

}
