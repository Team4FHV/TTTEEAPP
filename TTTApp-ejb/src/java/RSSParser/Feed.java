/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSParser;

/**
 *
 * @author media
 */
import DTO.objecte.DTOMessage;
import java.util.ArrayList;
import java.util.List;

/*
 * Stores an RSS feed
 */
public class Feed {

  final String title;
  final String description;
  final List<DTOMessage> entries = new ArrayList<DTOMessage>();

  public Feed(String title, String description) {
    this.title = title;
    this.description = description;
    
  }

  public List<DTOMessage> getMessages() {
    return entries;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }


  @Override
  public String toString() {
    return "description=" + description +" title=" + title;
  }

} 