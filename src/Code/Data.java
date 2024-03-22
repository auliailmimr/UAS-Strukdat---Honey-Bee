/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import Connection.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class Data {
    //OOP
    private int data;
    private String nama_peternakan;
    private String nama_pemilik;
    private String tanggal_setor;
    private String jenis_lebah;
    private String jumlah_madu;
    
    public Data(int data, String nama_peternakan, String nama_pemilik, String tanggal_setor, String jenis_lebah, String jumlah_madu) {
        this.data = data;
        this.nama_peternakan = nama_peternakan;
        this.nama_pemilik = nama_pemilik;
        this.tanggal_setor = tanggal_setor;
        this.jenis_lebah = jenis_lebah;
        this.jumlah_madu = jumlah_madu;
    }
    
    //Method yang akan diwariskan
    public ResultSet PrintData(){
        return MainRs;
    }
    
    public void insert(int a, String b, String c, String d, String e, String f){
        
    }
    
    public void insertDB(int a, String b, String c, String d, String e, String f){
        
    }
    
    public void quickSortId(){
        
    }
    
    public void shellSortNama(){
        
    }
    
    public void displayTable() {
        
    }
    
    public Data delete(int key) {
        return null;
    }
    
    public Data find(int key) {
        return null;
    }
    
    //Enkapsulasi
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
    public String getNama_peternakan() {
        return nama_peternakan;
    }

    public void setNama_peternakan(String nama_peternakan) {
        this.nama_peternakan = nama_peternakan;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    public String getTanggal_setor() {
        return tanggal_setor;
    }

    public void setTanggal_setor(String tanggal_setor) {
        this.tanggal_setor = tanggal_setor;
    }

    public String getJenis_lebah() {
        return jenis_lebah;
    }

    public void setJenis_lebah(String jenis_lebah) {
        this.jenis_lebah = jenis_lebah;
    }

    public String getJumlah_madu() {
        return jumlah_madu;
    }

    public void setJumlah_madu(String jumlah_madu) {
        this.jumlah_madu = jumlah_madu;
    }
    
    //Koneksi
    protected Connection MainKoneksi;
    protected PreparedStatement MainPst;
    protected Statement MainSt;
    protected ResultSet MainRs;
    protected String MainQuery;
    
    protected Data(){
        try{
            koneksi kon = new koneksi();
            MainKoneksi = kon.koneksiDB();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    
    private Connection getMainKoneksi(){
        return MainKoneksi;
    }
    
    private PreparedStatement getMainPst(){
        return MainPst;
    }
    
    private Statement getMainSt(){
        return MainSt;
    }
    
    private ResultSet getMainRs(){
        return MainRs;
    }
    
    private String getMainQuery(){
        return MainQuery;
    }
    
    private void setMainKoneksi(Connection MainKoneksi){
        this.MainKoneksi = MainKoneksi;
    }
    
    private void setMainPst(PreparedStatement MainPst){
        this.MainPst = MainPst;
    }
    
    private void setMainSt(Statement MainSt){
        this.MainSt = MainSt;
    }
    
    private void setMainRs(ResultSet MainRs){
        this.MainRs = MainRs;
    }
    
    private void setMainQuery(String MainQuery){
        this.MainQuery = MainQuery;
    }
}