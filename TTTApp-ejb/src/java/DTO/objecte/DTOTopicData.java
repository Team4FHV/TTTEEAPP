/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.io.Serializable;

/**
 *
 * @author Monika
 */
public class DTOTopicData implements Serializable{
    private String _name;

    public DTOTopicData() {
    }

    public DTOTopicData(String name) {
        this._name = name;
    }

    public String getName() {
        return _name;
    }   
}
