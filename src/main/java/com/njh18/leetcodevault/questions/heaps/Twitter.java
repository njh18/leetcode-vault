package com.njh18.leetcodevault.questions.heaps;

import java.util.*;

public class Twitter {

    public int count;
    // key - userId
    // values - set of followerIds
    public Map<Integer, Set<Integer>> userFolloweeMap;

    // key - userId
    // values - list of tweets
    // int[0] - count;
    // int[1] - tweetIdl
    public Map<Integer, List<int[]>> userTweetMap;


    public Twitter() {
        this.count = 0;
        this.userFolloweeMap = new HashMap<>();
        this.userTweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<int[]> tweetList = userTweetMap
                .computeIfAbsent(userId, k -> new ArrayList<>());
        count++;
        int[] newTweet = new int[2];
        newTweet[0] = count;
        newTweet[1] = tweetId;
        tweetList.add(newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        Comparator<int[]> comparator = (a,b) -> Integer.compare(b[0], a[0]);
        PriorityQueue<int[]> newsFeed = new PriorityQueue<>(comparator);

        if (userFolloweeMap.containsKey(userId)) {
            for (Integer followee : userFolloweeMap.get(userId)) {
                addTweetsToFeed(followee, newsFeed);
            }
        }
        addTweetsToFeed(userId, newsFeed);

        List<Integer> tweets = new ArrayList<>();
        count = 0;
        while (count != 10 && !newsFeed.isEmpty()) {
            count++;
            tweets.add(newsFeed.poll()[1]);
        }
        return tweets;
    }

    private void addTweetsToFeed(Integer followee, PriorityQueue<int[]> newsFeed) {
        if (!userTweetMap.containsKey(followee)) {
            return;
        }
        List<int[]> numOfTweets = userTweetMap.get(followee);
        if (numOfTweets.isEmpty()) {
            return;
        }
        int maxCount = Math.min(numOfTweets.size(), 10);
        for (int i = 0; i < maxCount; i++) {
            newsFeed.add(numOfTweets.get(numOfTweets.size() - 1 - i));
        }
    }

    public void follow(int followerId, int followeeId) {
        userFolloweeMap
                .computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFolloweeMap.containsKey(followerId)) {
            Set<Integer> followees = userFolloweeMap.get(followerId);
            followees.remove(followeeId);
            if (followees.isEmpty()) {
                userFolloweeMap.remove(followerId);
            } else {
                userFolloweeMap.put(followerId, followees);
            }
        }
    }
}