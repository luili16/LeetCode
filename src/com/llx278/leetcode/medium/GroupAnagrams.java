package com.llx278.leetcode.medium;

import java.util.*;

public class GroupAnagrams {

    class Holder {
        Character c;
        int count = 1;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Holder holder = (Holder) o;
            return count == holder.count &&
                    Objects.equals(c, holder.c);
        }

        @Override
        public int hashCode() {

            return Objects.hash(c, count);
        }

        @Override
        public String toString() {
            return "Holder{" +
                    "c=" + c +
                    ", count=" + count +
                    '}';
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {


        Map<Set<Holder>,List<String>> maps = new HashMap<>();

        for (String str : strs) {
            Set<Holder> key = new HashSet<>();
            for (Character c:str.toCharArray()) {
                Holder holder = null;
                boolean found = false;
                Iterator<Holder> iterator = key.iterator();
                while (iterator.hasNext()) {
                    Holder h = iterator.next();
                    if (h.c == c) {
                        h.count++;
                        found = true;
                        holder = new Holder();
                        holder.c = c;
                        holder.count = h.count;
                        iterator.remove();
                    }
                }
                if (!found) {
                    holder = new Holder();
                    holder.c = c;
                    holder.count = 1;
                    key.add(holder);
                } else {
                    key.add(holder);
                }
            }

            List<String> values = maps.get(key);
            if (values == null) {
                values = new LinkedList<>();
                values.add(str);
                maps.put(key,values);
            } else {
                values.add(str);
            }
        }

        return new LinkedList<>(maps.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"};
        //String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(result);

        int a = -100 % 2;
        System.out.println(a);
    }
}
