package com.company.week10;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashSet;
import java.util.Set;

class Entry<K extends Comparable<K>, V extends Comparable<V>>{
    int hash;
    K key;
    V value;
    int length = 0;
    Entry<K, V> next;

    Entry(K key, V value){
        hash = key.hashCode();
        next = null;
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
public class HashMap<K extends Comparable<K>, V extends Comparable<V>> {
    double loadFactor;
    int capacity = 16;
    int size;
    Entry<K, V>[] map = new Entry[capacity];

    HashMap(){
        size = 0;
    }

    public void clear(){

    }

    public void put(K key, V value){
        Entry<K,V>  obj = new Entry<K, V>(key, value);
        Entry<K,V> temp = map[getIndex(obj.hash)];
        put(obj, temp,getIndex(obj.hash), 0);
    }

    private void put(Entry<K,V> obj, Entry<K,V> temp, int hash, int n){

        if(temp != null) {

            while (temp.next != null) {
                if(temp.key.hashCode() == obj.key.hashCode()){
                    temp.value = obj.value;
                    return;
                }
                temp = temp.next;
            }

            if(map[getIndex(obj.hash)].length < 4) {
                temp.next = obj;
                map[getIndex(obj.hash)].length += 1;
            }

            else put(obj, map[getIndex2(hash, n)], getIndex2(hash, n), ++n);
        }
        else map[getIndex(obj.hash)] = obj;

        size++;
        size();


    }


    public V get(K key){
        Entry<K, V> obj = map[getIndex(key.hashCode())];
        if(obj != null) {

            while (obj.key.hashCode() != key.hashCode()) {
                obj = obj.next;
            }
        }
        return obj.value;
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<>();

        for(int i = 0; i < capacity; i++){
            if(map[i] == null)
                continue;

            Entry<K, V> temp = map[i];
            set.add(temp.key);

            while(temp.next != null){
                set.add(temp.next.key);
                temp = temp.next;
            }

        }
        return set;
    }

    public Set<V> values(){
        Set<V> set = new HashSet<>();

        for(int i = 0; i < capacity; i++){
            if(map[i] == null)
                continue;

            Entry<K, V> temp = map[i];
            set.add(temp.value);

            while(temp.next != null){
                set.add(temp.next.value);
                temp = temp.next;
            }

        }

        return set;
    }

    public boolean isEmpty(){
        int i = 0;

        while(i < capacity){

            if(map != null)
                return false;
            i++;

        }

        return true ;
    }

    public void remove(K key){
        Entry<K, V> obj = map[getIndex(key.hashCode())];
        Entry<K, V> temp = obj;

        remove(temp, obj, getIndex(key.hashCode()), 0);

    }

    private void remove(Entry<K, V> temp, Entry<K,V> obj, int hash, int n){
        if(obj != null) {

            while (temp.key.hashCode() != obj.key.hashCode()) {
                if(temp.next == null) break;
                temp = temp.next;

            }

            if(temp.key.hashCode() == obj.key.hashCode()) {
                temp = temp.next;
            }
            else remove(map[getIndex2(hash, n)], obj,  getIndex2(hash, n), ++n);
        }
        else System.out.println("no element");;

        size--;
        size();
    }

    private void size(){
        loadFactor = size / (double)capacity;
        if(loadFactor > 0.5)
            rehash();
    }

    public void rehash(){
        capacity *= 2;
        Entry<K, V>[] newmap = new Entry[capacity];

        for(int i = 0; i < capacity; i++){
            newmap[getIndex2(getIndex(map[i].key.hashCode()), 0)] = map[i];
        }

        map = newmap;
    }

    public void print(){
        int i =0;

        while(i < capacity){
            if(map[i] != null) {
                Entry<K, V> temp = map[i];

                while(temp != null) {
                    System.out.println(temp.key + ": " + temp.value  + "  hash: " + getIndex(temp.hash));
                    temp = temp.next;
                }

            }
            i++;
        }
    }

    private int getIndex2(int hash, int n){
        if ((capacity + n)-hash  > 16){
            return ((capacity + n)-hash) % 16;
        }
        return capacity-hash;
    }

    private int getIndex(int hash){
////        int index = 11;
//        String str = Integer.toString(hash);
//        hash = 0;
//        for(int i = 0; i < str.length(); i++) {
//            if(Character.getNumericValue(str.charAt(i)) > 4){
//                hash += 10 - Character.getNumericValue(str.charAt(i));
//            }
//            else hash += Character.getNumericValue(str.charAt(i));
//        }
////        System.out.println("hash: " + hash);
        while(hash > 10)
            hash = hash / 10;

        return hash;
    }
}
