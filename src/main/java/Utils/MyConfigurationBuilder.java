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

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * This class is an abstraction for ConfigurationBuilder, in order to use Twitter4J you need a
 * ConfigurationBuilder (However you can choose other ways but I used this...)
 * For more look at: http://twitter4j.org/en/configuration.html
 * @author Simone Kslash Angeletti
 */
public class MyConfigurationBuilder {
    private ConfigurationBuilder myConfigurationBuilder;
    private TwitterFactory tf;
    private Twitter myTwitter;

    /**
     * Constructor of MyConfigurationBuilder
     * It has 4 parameters which are needed for ConfigurationBuilder instance
     * @param OAuthConsumerKey
     * @param OAuthConsumerSecret
     * @param OAuthAccessToken
     * @param OAuthAccessTokenSecret
     */
    public MyConfigurationBuilder(String OAuthConsumerKey, String OAuthConsumerSecret, String OAuthAccessToken, String OAuthAccessTokenSecret){
        this.myConfigurationBuilder = new ConfigurationBuilder();
        myConfigurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(OAuthConsumerKey)
                .setOAuthConsumerSecret(OAuthConsumerSecret)
                .setOAuthAccessToken(OAuthAccessToken)
                .setOAuthAccessTokenSecret(OAuthAccessTokenSecret);
        tf = new TwitterFactory(myConfigurationBuilder.build());
        this.myTwitter = tf.getInstance();
    }


    public ConfigurationBuilder getMyConfigurationBuilderInstance() {
        return myConfigurationBuilder;
    }

    public Twitter getMyTwitter(){
        return myTwitter;
    }
}
