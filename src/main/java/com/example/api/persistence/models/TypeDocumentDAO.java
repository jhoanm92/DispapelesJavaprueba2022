package com.example.api.persistence.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "document_type")
public class TypeDocumentDAO {

    @Id // LLave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Incremento lo hace desde la bd
    @Column(name = "document_type_id")
    private Integer idTypeDocument;

    private String name;

    @OneToMany(mappedBy = "documentType")
    private List<UserDAO> users;

    public Integer getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(Integer idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDAO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDAO> users) {
        this.users = users;
    }
}
