/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Lenovo
 */
public class HashTable2 {
    
    public Data2[] hashArray;
    public int size;

    public HashTable2(int size) { 
        this.size = size;
        hashArray = new Data2[size];
    }

    public void displayTable2() { 
        System.out.println("Table: ");
        for (int j = 0; j < 10; j++) {
            if (hashArray[j] != null) { 
                System.out.println(" | "+j+"\t | "+hashArray[j].getAnggota()+" |");
            } else {
                System.out.println(" | "+j+"\t | -- |");
            }
        }
        System.out.println("");
    }
    
    public int hashFunc2(int key) {
        return key % size;
    }

    public void insert2(int ruang, String anggota) { 
        Data2 item= new Data2(ruang,anggota); 
        int key = item.getKey();
        int hashVal = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            ++hashVal; 
            
            hashVal %= size;

        }
        
        hashArray[hashVal] = item;
    }

    public Data2 delete2(int key) { 
        int hashVal = hashFunc2(key);
        while (hashArray[hashVal] != null) { 
            if (hashArray[hashVal].getKey() == key) {
                Data2 temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            ++hashVal; 
            hashVal %= size;
        }
        return null;
    }
    

    public Data2 find2(int key) {
        int hashVal = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey()== key) { 
                return hashArray[hashVal];
            }
            ++hashVal; 
            hashVal %= size;
        }
        
        return null;
    }
}
