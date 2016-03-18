package com.a3;

import fr.dyade.aaa.agent.Agent;
import fr.dyade.aaa.agent.AgentId;
import fr.dyade.aaa.agent.Notification;

/**
 * Created by matthieu on 18/03/16.
 */
public class HelloWorld extends Agent {

    int cpt = 0;

    public HelloWorld(short to){
        super(to);
    }

    public void react(AgentId from, Notification n) throws Exception {
        if(n instanceof HelloWorldNot) {
            System.out.println("Message : HelloWorld! with cpt: " + cpt);
            cpt++;
            sendTo(from, new StartNot());
        }
        else{
            super.react(from, n);
        }
    }
}
