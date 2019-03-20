/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Map;

/**
 *
 * @author Benjamin
 */

public class JsonObject extends LinkedHashMap<String, JsonValue> implements JsonValue{
    
    @Override
    public JsonObject asObject() {
        return this;
    }
    
    public void put(String key, Boolean value){
         super.put(key , new JsonPrimitive(value));
    }
    
    public void put(String key, int value){
        super.put(key , new JsonPrimitive(value));
    }
    
    public void put(String key, double value){
        super.put(key , new JsonPrimitive(value));
    }
    
    public void put(String key, String value){
        super.put(key , new JsonPrimitive(value));
    }
    
    @Override
    public JsonValue get(String key) {
        JsonValue value = super.get(key);
        return value;
    }

    @Override
    public boolean has(String key) {
        boolean value = super.containsKey(key);
        return value;
    }
    
    //all the values first go in a list, so that every value has an index
    @Override
    public JsonValue get(int index) {
        List<JsonValue> list = new ArrayList<JsonValue>(super.values());
        return list.get(index);
    }
    
    @Override
    public String toString() {
        String text = "\n \t{";
        List<String> keys = new ArrayList<String>(keySet()); //put all keys in a list
        //for every key, the value will be printed: "key": "value", values first have to be converted to strings
        for(int i = 0; i < keys.size(); i++)
        {
            if(i < keys.size() - 1)
            {
                text += "\n \t" + "\"" + keys.get(i) + "\"" + ": " + get(keys.get(i)).toString() + ","; // \t = tab, \n = new line, "\"" = "
            }
            else
            {
                text += "\n \t" + "\"" + keys.get(i) + "\"" + ": " + get(keys.get(i)).toString(); //no comma at the end
            }
        }
        text += "\n \t}";
        return text;
    }
}