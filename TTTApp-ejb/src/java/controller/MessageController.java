/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTO.objecte.DTOMessage;
import DTO.objecte.DTOTopicData;
import Domain.DAOFabrik;
import Hibernate.objecte.Benutzer;
import JMS.Publisher;
import RSSParser.Feed;
import RSSParser.RSSFeedParser;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author media
 */
public class MessageController {

    private static MessageController _instance = null;
    private List<DTOMessage> messageList;
    private String[] topicNames = ConstantContent.ConstantTopics.topicList;
    private DataManager dm = new DataManager();

    private MessageController() {
    }

    public static MessageController getInstance() {
        if (_instance == null) {
            _instance = new MessageController();
        }
        return _instance;
    }

    public List<DTOMessage> loadMessages() {
        RSSFeedParser parser = new RSSFeedParser("http://www.festivalticker.de/rss-festivalfeed/festivalkalender.xml");
        Feed feed = parser.readFeed();
        return feed.getMessages();
    }

    public String[] getTopicNames() {
        return topicNames;
    }

    public void publishMessage(DTOMessage message) throws NamingException {
        Publisher publisher = new Publisher();
        publisher.publish(message);
    }

   
    public ArrayList<DTOTopicData> getTopicsVonBenutzer(String userNamename) {
        Benutzer b = dm.getBentzerNachName(userNamename);
        String topics = DAOFabrik.getInstance().getBenutzerDAO().findById(b.getBenutzerId(), false).getTopics();
        ArrayList<DTOTopicData> result = new ArrayList<>();
        String[] x = topics.split(" ");
        for (int i = 0; i < x.length; i++){
            result.add(new DTOTopicData( x[i]));
        }
        return result;
    }
}
