/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Twitter;

import br.unesp.rc.Model.associacaoTwitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author marco
 */
public class mostrarTweet {
    
    public mostrarTweet(){
        
    }
    
    
    public Status buscarTweet(String idTweet,associacaoTwitter at) throws TwitterException{
            ConfigurationBuilder cb = new twitter4j.conf.ConfigurationBuilder();
            cb = OAuth.getAuth(cb,at);
            
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
            Status status = twitter.showStatus(Long.parseLong(idTweet));
            return status;
    }
    
}
