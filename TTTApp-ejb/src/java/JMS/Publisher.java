/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import DTO.objecte.DTOMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author media
 */
public class Publisher{
      
        String topicConnectionFactoryName = "jms/topicConnectionFactory";
        Context jndiContext = null;
        TopicConnectionFactory topicConnectionFactory = null;
        TopicConnection topicConnection = null;
        TopicSession topicSession = null;
        

    public Publisher() {
        start();
    }
    
    public void start(){
        

        Properties props = new Properties();
      
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");// server ip  
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); //default is 3700  

        try {
            jndiContext = new InitialContext(props);
            topicConnectionFactory = (TopicConnectionFactory) jndiContext.lookup(topicConnectionFactoryName);
           
        } catch (NamingException e) {
            System.out.println("JNDI lookup failed: "
                    + e.toString());

        }
    }
        
    public void publish(DTOMessage messageToPublish) throws NamingException{
        String topicName = "";
        if(messageToPublish.getTopic() != null)topicName = messageToPublish.getTopic();
      
        try {
            Topic topic = (Topic) jndiContext.lookup("jms/" + topicName );
            topicConnection = topicConnectionFactory.createTopicConnection();
            topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            // create a topic publisher
            TopicPublisher topicPublisher = topicSession.createPublisher(topic);
            topicPublisher.setDeliveryMode(DeliveryMode.PERSISTENT);

            // create the  message
            ObjectMessage message = topicSession.createObjectMessage(messageToPublish);
           
            // publish the messages
            topicPublisher.publish(message);

            // print what we did
            System.out.println("published in  "+ topicName +" :" + ((DTOMessage)message.getObject()).getText());

            // close the topic connection
            topicSession.close();
            topicConnection.close();
            jndiContext.close();

        } catch (JMSException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }

    }
}
