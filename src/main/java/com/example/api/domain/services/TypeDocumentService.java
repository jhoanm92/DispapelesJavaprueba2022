package com.example.api.domain.services;

import com.example.api.domain.entities.TypeDocument;
import com.example.api.domain.gateways.TypeDocumentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDocumentService {

    @Autowired
    private TypeDocumentGateway gateway;

    public List<TypeDocument> getAll(){
        return gateway.getAll();
    }

    public Optional<TypeDocument> getTypeDocumentById(int id ){
        return gateway.getTypeDocumentById(id);
    }

    public TypeDocument saveTypeDocument(TypeDocument document){
        return gateway.saveDocumentType(document);
    }

    public boolean deleteTypeDocumentById(int id){
        return getTypeDocumentById(id).map(td -> {
            gateway.deleteDocumentType(id);
            return true;
        }).orElse(false);
    }
}
