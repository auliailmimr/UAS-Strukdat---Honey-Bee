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
public class Data2 {
    public int ruang; 
    public String anggota;

    public Data2(int ruang,String anggota) { 
        this.ruang = ruang;
        this.anggota = anggota;
    }

    public int getKey() { 
        return ruang; 
    }
    
    public String getAnggota(){
        return anggota;
    }
}
