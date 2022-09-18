package com.epam.rd.autotasks;

import java.util.*;

public class Words {

    public String countWords(List<String> lines) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        StringBuilder temp = new StringBuilder();

        for (String s : lines) {
            temp = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char ch = Character.toLowerCase(s.charAt(i));
                if (ch == ' '
                        || ch == '-'
                        || ch == '/'
                        || ch == '*'
                        || ch == '.'
                        || ch == ','
                        || ch == '?'
                        || ch == '!'
                        || ch == ':'
                        || ch == ';'
                        || ch == '\''
                        || ch == '“'
                        || ch == '”'
                        || ch == '—'
                        || ch == '’'
                        || ch == '('
                        || ch == ')'
                        || ch == '‘'
                        || ch == '\"') {
                    if (temp.length() >= 4) {

                        if (hashMap.containsKey(temp.toString())) {
                            hashMap.put(temp.toString(), hashMap.get(temp.toString()) + 1);
                        } else {
                            hashMap.put(temp.toString(), 1);
                        }
                    }
                    temp = new StringBuilder();
                    continue;
                }
                temp.append(ch);
            }
            if (temp.length() >= 4) {

                if (hashMap.containsKey(temp.toString())) {
                    hashMap.put(temp.toString(), hashMap.get(temp.toString()) + 1);
                } else {
                    hashMap.put(temp.toString(), 1);
                }
            }

        }


        LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(hashMap.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder stringBuilder = new StringBuilder();

        boolean count = false;
        for (Map.Entry<String, Integer> set : entries) {
            if (set.getValue() >= 10 && count)
                stringBuilder.append("\n");

            if (set.getValue() >= 10) {
                stringBuilder.append(set.getKey())
                        .append(" - ")
                        .append(set.getValue());
            }
            count = true;

        }
        return stringBuilder.toString();
    }

}
