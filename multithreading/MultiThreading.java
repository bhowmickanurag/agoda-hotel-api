package org.example.multithreading;

import java.util.*;
import java.util.concurrent.*;

public class MultiThreading {

    public Callable<Map<Character, int[]>> createCallable(String vote) {
        Callable<Map<Character, int[]>> callable = new Callable() {
            @Override
            public Map<Character, int[]> call() throws Exception {
                Map<Character, int[]> map = new HashMap<>();
                for(int i = 0 ; i < vote.length() ; i++) {
                    char ch = vote.charAt(i);
                    map.putIfAbsent(ch, new int[vote.length()]);
                    map.get(ch)[i]++;
                }
                return map;
            }
        };
        return callable;
    }

    public String rankTeams(String[] votes) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(votes.length);
        int l = votes[0].length();
        List<Callable<Map<Character, int[]>>> callableTasks = new ArrayList<>();

        for(String vote : votes) {
            callableTasks.add(createCallable(vote));
        }
        Map<Character, int[]> teamRankMap = new HashMap<>();
        List<Future<Map<Character, int[]>>> futures = executorService.invokeAll(callableTasks);
        for(Future<Map<Character, int[]>> future : futures) {
            Map<Character, int[]> subMap = future.get();
            for(Map.Entry<Character, int[]> entry : subMap.entrySet()) {
                subMap.putIfAbsent(entry.getKey(), entry.getValue());
                // update the value for existing key
            }
        }

        System.out.println(teamRankMap);
        ArrayList<Character> list = new ArrayList<>(teamRankMap.keySet());
        Collections.sort(list, (a, b) -> {
            for(int i = 0 ; i < l ; i++) {
                if(teamRankMap.get(a)[i] != teamRankMap.get(b)[i]) {
                    return teamRankMap.get(b)[i] - teamRankMap.get(a)[i];
                }
            }
            return a-b;
        });
        StringBuilder sb = new StringBuilder();
        for(char ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
