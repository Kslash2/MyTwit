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

package Utils;

import TwitUsers.TwitUser;
import twitter4j.*;
import java.io.*;
import java.util.List;


/**
 * Main class
 */
public class MyTwit {

    public static void  main(String Args[]) throws TwitterException,IOException {
        /*
         * Create your app here https://apps.twitter.com/
         * Then get the following necessary info.
         */
        String OAuthConsumerKey = "" ;
        String OAuthConsumerSecret  = "";
        String OAuthAccessToken = "";
        String OAuthAccessTokenSecret = "";

        MyConfigurationBuilder mycb = new MyConfigurationBuilder(OAuthConsumerKey,OAuthConsumerSecret,
                                                                    OAuthAccessToken,OAuthAccessTokenSecret);

        Twitter twitter = mycb.getMyTwitter();

        TwitUser kslash = new TwitUser(twitter,"Simone_Kslash"); //Follow me on Twitter ;) xD

        kslash.setFollowing();


        List<String> screenNamesOfFollowing = kslash.getFollowing().getScreenNames();


        Save<String> saveFollowing = new Save();
        saveFollowing.saveText(screenNamesOfFollowing,"screenNamesOfFollowing.txt");
    }
}
