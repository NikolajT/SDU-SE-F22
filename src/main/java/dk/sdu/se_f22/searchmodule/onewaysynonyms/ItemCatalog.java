package dk.sdu.se_f22.searchmodule.onewaysynonyms;

import javax.swing.*;

import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class ItemCatalog{
    //Attributes
    private LinkedList<Item> catalog;

    //Constructor
    public ItemCatalog(Item[] items){
        this.catalog = new LinkedList<>();
        this.catalog.addAll(List.of(items));
        addSubItems();
    }

    //Methods
    public void addITem(Item item){
        catalog.add(item);
    }

    public boolean removeItem(Item item){
        return catalog.remove(item);
    }

    public LinkedList<Item> getCatalog() {
        return catalog;
    }

    private void addSubItems(){
        for(Item item : catalog){
            try{
                item.getSuperItem().AddSubItem(item);
            } catch (NullPointerException ex){
            }
        }
    }

    public LinkedList<Item> oneWaySynonymStrings(String string) throws notFoundException {

        for(Item item : catalog) {
            if(item.getName().equals(string)){
                return item.getSubItems();
            }
        }
        throw new notFoundException("Item not found in database.");
    }

    public Item getRoot(){
        for (Item item:catalog) {
            if (item.getSuperId()==0){
                return item;
            }
        }
        return catalog.get(0);
    }
}