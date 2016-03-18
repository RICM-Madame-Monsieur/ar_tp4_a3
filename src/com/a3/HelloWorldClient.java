package com.a3;

import fr.dyade.aaa.agent.Agent;
import fr.dyade.aaa.agent.AgentId;
import fr.dyade.aaa.agent.Notification;

/**
 * Created by matthieu on 18/03/16.
 */
public class HelloWorldClient extends Agent {

    public AgentId dest;

    public HelloWorldClient(short to){
        super(to);
    }

    public void react(AgentId from, Notification n) throws Exception {

        if(n instanceof StartNot) {
            System.out.println("Start...");
            sendTo(dest, new HelloWorldNot());
        }
        else{
            super.react(from, n);
        }
    }
}
