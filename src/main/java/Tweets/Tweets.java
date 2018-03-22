/*
 * Copyright 2018 Simone Kslash Angeletti
 * I'm using the same License of Twitter4J which I used in this project.
 * Twitter4J: http://twitter4j.org/en/index.html
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package Tweets;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.QueryResult;

import java.util.List;

/**
 * This class represent Tweets.Tweets in general
 * @author Simone Kslash Angeletti
 */
public class Tweets{
    private Twitter twitter;
    private List<Status> statuses;

    /**
     * Constructor of Tweets
     * @param twitter
     */
    public Tweets(Twitter twitter){
        this.twitter = twitter;
    }

    /**
     * get latest tweets from specific user
     * @param username
     * @return
     * @throws TwitterException
     */
    public List<Status> getFromUser(String username) throws TwitterException {
        Query query = new Query("from:"+ username);

        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            statuses.add(status);
        }
        return statuses;
    }

    /**
     * Get latest tweets from your home
     * @return
     * @throws TwitterException
     */
    public List<Status> getFromYourHome() throws TwitterException{
        System.out.println("Getting home tweets.");
        statuses = twitter.getHomeTimeline();
        return statuses;
    }
}

