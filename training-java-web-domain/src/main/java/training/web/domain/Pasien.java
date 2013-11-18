/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training.web.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "a_rm_pasien")
public class Pasien {

    @Column(name = "norm", length = 6)
    @Id
    private String norm;

    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "alamat_ktp", length = 150)
    private String alamat_ktp;

    @Column(name = "telp", length = 30)
    private String telp;

    @Column(name = "sex", length = 1)
    private String sex;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir", nullable = false)
    private Date tgl_lahir;

    public String getNorm() {
        return norm;
    }

    public void setNorm(String norm) {
        this.norm = norm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat_ktp() {
        return alamat_ktp;
    }

    public void setAlamat_ktp(String alamat_ktp) {
        this.alamat_ktp = alamat_ktp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    @Override
    public String toString() {
        return "Pasien{"
                + "norm=" + norm
                + ", nama=" + nama
                + ", alamat_ktp=" + alamat_ktp
                + ", sex=" + sex
                + ", tgl_lahir=" + tgl_lahir
                + '}';
    }

}
