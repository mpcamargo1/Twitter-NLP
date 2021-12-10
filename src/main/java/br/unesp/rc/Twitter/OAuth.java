/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Twitter;

import br.unesp.rc.Model.associacaoTwitter;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author marco
 */
public class OAuth {
    
    
    public static ConfigurationBuilder getAuth(ConfigurationBuilder cb, associacaoTwitter at){
         cb.setDebugEnabled(true)
              .setOAuthConsumerKey(at.getApiKey())
              .setOAuthConsumerSecret(at.getApiSecretKey())
              .setOAuthAccessToken(at.getAccessToken())
              .setOAuthAccessTokenSecret(at.getAccessTokenSecret());
            return cb;
    }
    
}
