/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Monika
 */
public class DTOTopicList implements Serializable {
   ArrayList<String> _topics = new ArrayList();

    public DTOTopicList(ArrayList<String> topics) {
         this._topics = topics;
    }

    public ArrayList<String> getTopics() {
        return _topics;
    }   
}
