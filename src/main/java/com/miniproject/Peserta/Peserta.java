package com.miniproject.Peserta;

import java.io.Serializable;
import java.sql.Date;

import com.miniproject.User.User;

import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "peserta")
public class Peserta implements Serializable {

    @Id
    @Column(name = "uniquecode", nullable = false, unique = true)
    private String uniquecode;
    private Date tanggaldaftar;
    private String email;
    private String nama;
    private String nowa;
    private String jeniskelamin;
    private String usia;
    private String paroki;
    private String buktibayar;
    private String namakomunitas;
    private Boolean masuk;
    private Date waktumasuk;

    @ManyToOne
    @JoinColumn(name = "scanby")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUniquecode() {
        return uniquecode;
    }

    public void setUniquecode(String uniquecode) {
        this.uniquecode = uniquecode;
    }

    public Date getTanggaldaftar() {
        return tanggaldaftar;
    }

    public void setTanggaldaftar(Date tanggaldaftar) {
        this.tanggaldaftar = tanggaldaftar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNowa() {
        return nowa;
    }

    public void setNowa(String nowa) {
        this.nowa = nowa;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getParoki() {
        return paroki;
    }

    public void setParoki(String paroki) {
        this.paroki = paroki;
    }

    public String getBuktibayar() {
        return buktibayar;
    }

    public void setBuktibayar(String buktibayar) {
        this.buktibayar = buktibayar;
    }

    public String getNamakomunitas() {
        return namakomunitas;
    }

    public void setNamakomunitas(String namakomunitas) {
        this.namakomunitas = namakomunitas;
    }

    public Date getWaktumasuk() {
        return waktumasuk;
    }

    public void setWaktumasuk(Date waktumasuk) {
        this.waktumasuk = waktumasuk;
    }

    public Boolean getMasuk() {
        return masuk;
    }

    public void setMasuk(Boolean masuk) {
        this.masuk = masuk;
    }
}
