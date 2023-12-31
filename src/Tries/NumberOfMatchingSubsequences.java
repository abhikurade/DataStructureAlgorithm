package Tries;

//https://leetcode.com/problems/number-of-matching-subsequences/

import java.util.ArrayList;
import java.util.List;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String exp, String[] words) {

        int n = exp.length();
        List<Node>[] buckets = new ArrayList[26];

        for(int i=0; i<26; i++){
            buckets[i] = new ArrayList<>();
        }

        for(String word : words){
            char c = word.charAt(0);
            buckets[c-'a'].add(new Node(word, 0));
        }
        int count = 0;
        for(int i=0; i<n; i++){
            char c = exp.charAt(i);
            List<Node> list = buckets[c-'a'];
            buckets[c-'a'] = new ArrayList<>();
            for(Node node : list){
                node.idx += 1;
                if(node.idx == node.str.length()) count += 1;
                else {
                    char b = node.str.charAt(node.idx);
                    buckets[b-'a'].add(new Node(node.str, node.idx));
                }
            }
        }
        return count;

    }

    class Node{
        String str;
        int idx;
        public Node(String str, int idx){
            this.str = str;
            this.idx = idx;
        }
    }
}
