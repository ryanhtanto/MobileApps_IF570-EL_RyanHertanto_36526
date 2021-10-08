package umn.ac.id.ryanhertanto_00000036526_if570_el_uts;

import java.io.Serializable;

public class SumberAudio implements Serializable {
    private String judul;
    private String keterangan;
    private String audioURI;
    public SumberAudio(String judul, String keterangan, String audioURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.audioURI = audioURI;
    }
    public String getJudul() {
        return this.judul;
    }
    public String getKeterangan() {
        return this.keterangan;
    }
    public String getAudioURI() {
        return this.audioURI;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    public void setAudioURI(String audioURI) {
        this.audioURI = audioURI;
    }
    public String toString() {
        return this.getJudul() + " => " + this.getKeterangan();
    }
}
