/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "img_preference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImgPreference.findAll", query = "SELECT i FROM ImgPreference i")
    , @NamedQuery(name = "ImgPreference.findByIdPreference", query = "SELECT i FROM ImgPreference i WHERE i.idPreference = :idPreference")
    , @NamedQuery(name = "ImgPreference.findByImgFilename", query = "SELECT i FROM ImgPreference i WHERE i.imgFilename = :imgFilename")
    , @NamedQuery(name = "ImgPreference.findByImgUrl", query = "SELECT i FROM ImgPreference i WHERE i.imgUrl = :imgUrl")})
public class ImgPreference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_preference")
    private Integer idPreference;
    @Size(max = 45)
    @Column(name = "img_filename")
    private String imgFilename;
    @Size(max = 300)
    @Column(name = "img_url")
    private String imgUrl;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne
    private User iduser;

    public ImgPreference() {
    }

    public ImgPreference(Integer idPreference) {
        this.idPreference = idPreference;
    }

    public Integer getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(Integer idPreference) {
        this.idPreference = idPreference;
    }

    public String getImgFilename() {
        return imgFilename;
    }

    public void setImgFilename(String imgFilename) {
        this.imgFilename = imgFilename;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreference != null ? idPreference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImgPreference)) {
            return false;
        }
        ImgPreference other = (ImgPreference) object;
        if ((this.idPreference == null && other.idPreference != null) || (this.idPreference != null && !this.idPreference.equals(other.idPreference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alkanza.ImgPreference[ idPreference=" + idPreference + " ]";
    }
    
}
