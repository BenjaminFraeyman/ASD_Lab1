/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo1;

import java.util.Iterator;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author Benjamin
 */
//instead of using some superclass (inheritance), we make use of composition: the object 'Property'
public class CompositionConfigProperties implements ConfigProperties{
    protected JsonObject Jason = new JsonObject();   
    
    @Override
    public Iterator<String> propertyNames() {
        List<String> jasooons = new ArrayList<String>(Jason.keySet());
        Iterator names = jasooons.iterator();
        return names;
    }
    
    @Override
    public String getProperty(String name, String defaultValue) {
        JsonValue jesun = Jason.get(name);
        if(jesun != null)
        {
            return jesun.asString();
        }
        else
        {
            return defaultValue;
        }
    }
    
    @Override
    public String getProperty(String name) {
        JsonValue jason = Jason.get(name);
        return jason.asString();
    }
    
    @Override
    public void setProperty(String name, String value) {
        Jason.put(name, value);
    }
    
    @Override
    public void load(InputStream input) {  } //load
    
    @Override
    public void store(OutputStream output) {  }  //store
}
