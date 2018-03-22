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

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * This class represent TwitUsers.Followers of a TwitUsers.TwitUser
 * @author Simone Kslash Angeletti
 */
public class Following extends Friends {


    public Following(Twitter twitter, String username) throws TwitterException{
       super(twitter,username);
    }

    /**
     * Implements abstract method createIDs, with "TwitUsers.Following" IDs
     * @throws TwitterException
     */
    protected void createIDs() throws TwitterException {
        System.out.println("Creating following IDs...");
        long cursor =-1L;
        IDs ids;
        do {
            ids = super.getTwitter().getFriendsIDs(super.getUsername(),cursor);
            for(long userID : ids.getIDs()){
                super.getIDs().add(userID);
            }
        } while((cursor = ids.getNextCursor())!=0 );
    }


}
