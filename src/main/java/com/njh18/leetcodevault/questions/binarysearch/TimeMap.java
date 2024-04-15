package com.njh18.leetcodevault.questions.binarysearch;

import java.util.*;

public class TimeMap {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("robb", "talisa", 2);
        System.out.println(timeMap.get("robb",3)); // "talisa"
        timeMap.set("sansa", "tyrion", 3);
        timeMap.set("sansa", "ramsay", 5);
        System.out.println(timeMap.get("sansa", 5)); // "ramsay
        System.out.println(timeMap.get("sansa", 1)); // ""
        System.out.println(timeMap.get("bran", 7 )); // ""
    }

    public static class ValueTimeClass {
        public String val;
        public int timeStamp;

        public ValueTimeClass(String val, int timeStamp) {
            this.val = val;
            this.timeStamp = timeStamp;
        }

        public String getVal() {
            return val;
        }

        public int getTimeStamp() {
            return timeStamp;
        }
    }

    public Map<String, List<ValueTimeClass>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<ValueTimeClass> stack = map.getOrDefault(key, new ArrayList<>());
        stack.add(new ValueTimeClass(value, timestamp));
        map.put(key, stack);
    }

    public String get(String key, int timestamp) {
        List<ValueTimeClass> list = map.getOrDefault(key, new ArrayList<>());
        if (list.isEmpty() || list.get(0).timeStamp > timestamp) {
            return "";
        }
        if (list.get(list.size() - 1).timeStamp < timestamp) {
            return list.get(list.size()-1).val;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).timeStamp <= timestamp) {
                return list.get(i).val;
            }
        }
        return "";
    }
}
