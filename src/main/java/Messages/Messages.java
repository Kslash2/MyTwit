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

package Messages;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handle messages of the user
 *
 */
public class Messages {
    private Twitter twitter;
    private List<DirectMessage> messages;

    /**
     *Class constructor
     * @param twitter
     */
    public Messages(Twitter twitter){

        this.twitter = twitter;
    }

    /**
     * Send the user a String msg.
     * @param username
     * @param msg
     * @throws TwitterException
     */
    public void sendTo(String username, String msg) throws TwitterException {
        Long recipientId = twitter.showUser(username).getId();
        DirectMessage message = twitter.sendDirectMessage(recipientId, msg);
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
    }

    /**
     *  All your received messages
     * @return
     * @throws TwitterException
     */
    public List<DirectMessage>received() throws TwitterException{
        messages = twitter.getDirectMessages();
        return messages;
    }

    /**
     * Return a list with messages received from a specific user
     * @param user
     * @throws TwitterException
     */
    public List<DirectMessage> receivedFrom(String user) throws TwitterException{
        Long receivedFromId = twitter.showUser(user).getId();
        List<DirectMessage> messagesFromUser = new ArrayList<DirectMessage>();
        if(messages.isEmpty()){
            this.received();
            receivedFrom(user);
        }
        else {
            for (DirectMessage dm : messages) {
                if (dm.getId()==receivedFromId) {
                    messagesFromUser.add(dm);
                }
            }
        }
        return messagesFromUser;
    }
}
