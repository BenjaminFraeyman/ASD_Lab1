/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo1;

import java.util.LinkedList;

/**
 *
 * @author Benjamin
 */
public class JsonArray extends LinkedList<JsonValue> implements JsonValue{
    @Override
    public JsonArray asArray(){
        return this;
    }
    
    public void add(boolean value) {
        super.add( new JsonPrimitive(value));
    }
    
    public void add(int value) {
        super.add( new JsonPrimitive(value));
    }
    
    public void add(double value) {
        super.add( new JsonPrimitive(value));
    }
    
    public void add(String value) {
        super.add( new JsonPrimitive(value));
    }  
    
    @Override
    public JsonValue get(String key) {
        int number = Integer.parseInt(key); //lists uses index (= keys) -> string = integer
        JsonValue value = super.get(number);
        return value;
    }

    @Override
    public boolean has(String key) {
        int number = Integer.parseInt(key);
        if(number < size())
        {
            return true; //element exists
        }
        else
        {
            return false; //index number doesn't exist
        }
    } 
}