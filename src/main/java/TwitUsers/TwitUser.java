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
package TwitUsers;

import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * This class represent a TwitUsers.TwitUser, it is some kind of higher abstraction (like a wrapping) of Twitter4J User.
 * @author Simone kslash Angeletti
 */
public class TwitUser {
    private String username;
    private Long id;
    private Twitter twitter;
    private Following following;
    private Followers followers;

    /**
     * Constructor of TwitUser
     * @param twitter
     * @param username
     * @throws TwitterException
     */
    public TwitUser(Twitter twitter, String username) throws TwitterException {
        this.twitter = twitter;
        this.username = username;
        this.id = twitter.showUser(username).getId();
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setFollowing() throws TwitterException{
        this.following = new Following(this.twitter,username);
    }

    public Following getFollowing() {
        return following;
    }

    public void setFollowers()throws TwitterException {
        this.followers = new Followers(this.twitter,username);
    }

    public Followers getFollowers() {
        return followers;
    }
}
