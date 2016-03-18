package com.a3;

/**
 * Created by matthieu on 18/03/16.
 */
import java.io.*;
import fr.dyade.aaa.agent.*;

public class Launch {

    public static void main (String args[]) {
        try {
            AgentServer.init(args); // initialisation du serveur

            /*
            * création des objets localement, réalisation des initialisations
            * nécessaires et déploiement de ceux-ci sur les serveurs qui leur ont
            * été respectivement affectés.
            */

            HelloWorld hl = new HelloWorld((short) 1);
            HelloWorldClient hlc = new HelloWorldClient((short)0);

            hlc.dest = hl.getId();

            hl.deploy();
            hlc.deploy();

            Channel.sendTo(hlc.getId(), new StartNot());

            AgentServer.start(); // lancement du serveur

        }catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
