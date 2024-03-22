/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

//import GUI.Penyetoran;

import java.sql.ResultSet;

//import java.sql.ResultSet;
//import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class HashTable extends Data{

    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
        for(int i=0; i<size; i++){
            
        }
    }
    
    public Data[] getHashArray(int size){
        return hashArray;
    }
    
    public void setHashArray(Data[] hashArray){
        this.hashArray = hashArray;
    }
    
    @Override
    public ResultSet PrintData(){
        MainQuery = "SELECT * FROM penyetoran";
        try{
            MainSt = MainKoneksi.createStatement();
            MainRs = MainSt.executeQuery(MainQuery);
        } catch (Exception e){
            
        }
        return MainRs;
    }
    
    public int hashFunc(int key) {
        return key % size;
    }
 
    @Override
    public void insert(int data, String nama_peternakan, String nama_pemilik, String tanggal_setor, String jenis_lebah, String jumlah_madu) {
        Data item = new Data(data, nama_peternakan, nama_pemilik, tanggal_setor, jenis_lebah, jumlah_madu);
        int key = item.getData();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            ++hashVal;
            hashVal %= size;
        }
        hashArray[hashVal] = item;
    }
    
    @Override
    public void insertDB(int data, String nama_peternakan, String nama_pemilik, String tanggal_setor, String jenis_lebah, String jumlah_madu){
        MainQuery = "INSERT INTO penyetoran VALUES (?,?,?,?,?,?)";
        try {
            MainPst = MainKoneksi.prepareStatement(MainQuery);
            MainPst.setInt(1, data);
            MainPst.setString(2, nama_peternakan);
            MainPst.setString(3, nama_pemilik);
            MainPst.setString(4, tanggal_setor);
            MainPst.setString(5, jenis_lebah);
            MainPst.setString(6, jumlah_madu);
            
            MainPst.executeUpdate();
            MainPst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @Override
    public Data delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() 
                    == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }

    @Override
    public Data find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData()
                    == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }
    
    @Override
    public void displayTable(){
//        PrintData();
        System.out.println("");
        System.out.println("=========== Bukti Penyetoran Madu ===========");
        System.out.println("");
        System.out.println("+---------------+---------------+---------------+"
                + "---------------+---------------+---------------+");
        System.out.println("|No. ID \t|Nama Peternakan|Nama Pemilik"
                + "\t|Tanggal Setor \t|Jenis Lebah \t|Jumlah Madu \t|");
        System.out.println("+---------------+---------------+---------------+"
                + "---------------+---------------+---------------+");
        
        for (int j = 0; j < size; j++){
            if (hashArray[j] != null) {
                System.out.println("|" + hashArray[j].getData() + " \t\t|"
                        + hashArray[j].getNama_peternakan() + " \t|"
                                + hashArray[j].getNama_pemilik() + " \t|"
                                        + hashArray[j].getTanggal_setor() + "\t|"
                                                + hashArray[j].getJenis_lebah() + "\t|"
                                                        + hashArray[j].getJumlah_madu() + "\t\t|");
            }
                System.out.println("+---------------+---------------+---------------+"
                + "---------------+---------------+---------------+");
        }
    }
}
