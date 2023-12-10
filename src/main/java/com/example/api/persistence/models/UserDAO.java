package com.example.api.persistence.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    private String name;

    private String lastname;

    @Positive
    @Min(0)
    @Max(150)
    private int age;

    private String city;

    @Column(name = "identification_number")
    private String identicationNumber;

    @Column(name = "document_type_id")
    private int documentTypeId;

    @ManyToOne
    @JoinColumn(name = "document_type_id",insertable = false,updatable = false)
    private TypeDocumentDAO documentType;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public TypeDocumentDAO getDocumentType() {
        return documentType;
    }

    public void setDocumentType(TypeDocumentDAO documentType) {
        this.documentType = documentType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdenticationNumber() {
        return identicationNumber;
    }

    public void setIdenticationNumber(String identicationNumber) {
        this.identicationNumber = identicationNumber;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }
}
