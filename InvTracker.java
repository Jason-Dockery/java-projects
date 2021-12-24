package com.alpha;

// Created by: Jason Dockery
// Finished program: 11/10/2019

public class InvTracker {
    private InvItem[] items;
    private int count;

    boolean inStock(long id) {
        for(int count = 0; count < items.length-1; count++){
            if (items[count].id == id) return true;
        }return false;
    }
    int stockAmount(long id) {
        for(int quantity = 0; quantity < items.length-1; quantity++){
            if (items[count].id == id) return quantity;
        } return -1;
    }
    void add( long id,int quantity) {
        for(int count = 0; count < items.length-1; count++){
            if (items[count].id == id) quantity = count + quantity;
            else{
                items[count].id = id;
                items[count].quantity = quantity;
                count++;
            }
        }
    }
    void remove(long id, int count) {
        for(int quantity = 0; count < items.length-1; count++){
            if(items[count].id == id && quantity >= count) quantity = count - quantity;
        }
    }
    void delete(long id) {
        for(int count = 0; count < items.length-1; count++)
            if(items[count].id == id){
                items[count] = null;
                if(count > 0 && count < items.length-1) count--;
            }
    }
    InvItem[] search(String name) {
        for(int count = 0; count < items.length-1; count++){
            if(items[count].name == name);
        }return items; //wrong
    }
    InvTracker() {
        items = new InvItem[1000];
        count = 0;
    }
    public static void main(String[] args) {
        InvTracker it2 = new InvTracker();
    }
}
class InvItem {
    long id;
    String name;
    int quantity;

    long getId(){
        return id;
    }
    void setId(long id){
        this.id = id;
    }
    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    int getQuantity(){
        return quantity;
    }
    void setQuantity(int quantity){
        this.quantity = quantity;
    }
    InvItem(long id){
        InvItem.this.id = id;
        InvItem.this.name ="";
        InvItem.this.quantity = 0;
    }
}