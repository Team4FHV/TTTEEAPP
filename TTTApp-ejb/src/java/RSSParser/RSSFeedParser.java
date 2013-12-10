/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSParser;

import DTO.objecte.DTOMessage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author media
 */
public class RSSFeedParser {
  static final String TITLE = "title";
  static final String DESCRIPTION = "description";
  static final String ITEM = "item";
 

  final URL url;

  public RSSFeedParser(String feedUrl) {
    try {
      this.url = new URL(feedUrl);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  public Feed readFeed() {
    Feed feed = null;
    try {
      boolean isFeedHeader = true;
      // Set header values intial to the empty string
      String description = "";
      String title = "";
     

      // First create a new XMLInputFactory
      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
      // Setup a new eventReader
      InputStream in = read();
      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
      // read the XML document
      while (eventReader.hasNext()) {
        XMLEvent event = eventReader.nextEvent();
        if (event.isStartElement()) {
          String localPart = event.asStartElement().getName()
              .getLocalPart();
          switch (localPart) {
          case ITEM:
            if (isFeedHeader) {
              isFeedHeader = false;
              feed = new Feed(title, description);
            }
            event = eventReader.nextEvent();
            break;
          case TITLE:
            title = getCharacterData(event, eventReader);
            break;
          case DESCRIPTION:
            description = getCharacterData(event, eventReader);
            break;
         
          }
        } else if (event.isEndElement()) {
          if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
            DTOMessage message = new DTOMessage(title, description, null, null);
          
            feed.getMessages().add(message);
            event = eventReader.nextEvent();
            continue;
          }
        }
      }
    } catch (XMLStreamException e) {
      throw new RuntimeException(e);
    }
    return feed;
  }

  private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
      throws XMLStreamException {
    String result = "";
    event = eventReader.nextEvent();
    if (event instanceof Characters) {
      result = event.asCharacters().getData();
    }
    return result;
  }

  private InputStream read() {
    try {
      return url.openStream();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

    
}
