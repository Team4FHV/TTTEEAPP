/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.util.Date;
import java.io.Serializable;;
/**
 *
 * @author Monika
 */
public class DTOMessage implements Serializable{
    private String _title;
    private String _text;
    private Date _date;
    //private Integer _id;
    private String _topic; 

    public DTOMessage() {        
    }

    public DTOMessage(String title, String text, Date date, String topic) {
        this._title = title;
        this._text = text;
        this._date = date;
        this._topic = topic;
    }

    public String getTopic() {
        return _topic;
    }

    public void setTopic(String topic) {
        this._topic = topic;
    }
    
    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        this._text = text;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        this._date = date;
    }

}
