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
import twitter4j.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent friends of a TwitUsers.TwitUser it is an Abstract Class
 * specialized in TwitUsers.Following and TwitUsers.Followers (There is only 1 method different).
 * You can get a list of ids,Users(not TwitUsers.TwitUser),screenNames.
 * Obviously if you need other kind of info, you can take them from users.
 *
 * @author Simone Kslash Angeletti
 */
public abstract class Friends {
    private List<User> usersList = new ArrayList<User>();
    private List<Long> IDsList = new ArrayList<Long>();
    private List<String> screenNameList = new ArrayList<String>();
    private Twitter twitter;
    private String username;
    private long userId;

    /**
     * Constructor of Friends
     * @param twitter
     * @param username
     * @throws TwitterException
     */
    protected Friends(Twitter twitter, String username) throws TwitterException {
        this.twitter = twitter;
        this.username = username;
        userId = twitter.showUser(username).getId();


    }

    public Twitter getTwitter(){
        return this.twitter;
    }

    public String getUsername(){
        return this.username;
    }

    /**
     * Get the IDs of following or followers depending on the instance
     * which will call it (TwitUsers.Followers or TwitUsers.Following)
     * @abstract
     * @throws TwitterException
     */
    protected abstract void createIDs() throws TwitterException;

    /**
     * Get Users from twitter using ID that were taken with createIDs
     * @throws TwitterException
     */
    private void createUsers()throws TwitterException {
        System.out.println("Creating users...");
        if(IDsList.isEmpty()) {
            createIDs();
        }
        for(Long id : IDsList){
            usersList.add(twitter.showUser(id));
        }

    }

    /**
     * Get the screenNames from the list made of users
     * @throws TwitterException
     */
    private void createScreenName()throws TwitterException {
        System.out.println("Creating screenNames...");
        if(IDsList.isEmpty()) {
            createIDs();
        }
        for(Long id : IDsList){
            screenNameList.add(twitter.showUser(id).getScreenName());
        }

    }

    public List<Long> getIDs() throws TwitterException{
        if(this.IDsList.isEmpty()) {
            this.createIDs();
        }
        return IDsList;
    }

    public List<User> getUsers() throws TwitterException {
        if(this.usersList.isEmpty()) {
            this.createUsers();
        }
        return usersList;
    }

    public List<String> getScreenNames() throws TwitterException {
        if(this.screenNameList.isEmpty()) {
            this.createScreenName();
        }
        return screenNameList;
    }

    /**
     * search a user using the username passed into the parameters
     * @param userSearched
     * @return
     * @throws TwitterException
     */
    public boolean searchUsername(String userSearched)throws TwitterException{
       Long idSearched = this.twitter.showUser(userSearched).getId();
       boolean result = false;
        for(long id : this.IDsList){
            if(id == idSearched){
                result = true;
            }
        }
        return result;
    }


}
