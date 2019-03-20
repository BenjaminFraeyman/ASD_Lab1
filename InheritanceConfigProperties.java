/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo1;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 *
 * @author Benjamin
 */
public class InheritanceConfigProperties extends JsonObject implements ConfigProperties {
    //first put every key from JsonObject in a list, then iterate
    @Override
    public Iterator<String> propertyNames() {
        List<String> props = new ArrayList<String>(super.keySet());
        Iterator names = props.iterator();
        return names;
    }
    
    @Override
    public String getProperty(String name) {
        JsonValue prop = super.get(name);
        return prop.asString();
    }
    
    @Override
    public String getProperty(String name, String defaultValue) {
        JsonValue prop = super.get(name);
        if(prop != null) {
            return prop.asString();
        }
        else
        {
            return defaultValue; //requested element = empty
        }
    }
    
    @Override
    public void setProperty(String name, String value) {
        super.put(name, value);
    }
    
    
    @Override
    public void load(InputStream input) {  } //load
    
    @Override
    public void store(OutputStream output) {  } //store
}
