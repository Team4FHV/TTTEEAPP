/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RSSParser;

/**
 *
 * @author media
 */
public class FeedMessage {

  String title;
  String description;
 

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "FeedMessage [title=" + title + ", description=" + description;
  }

    
}
