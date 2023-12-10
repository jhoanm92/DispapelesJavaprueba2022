package com.example.api.domain.gateways;

import com.example.api.domain.entities.TypeDocument;

import java.util.List;
import java.util.Optional;

public interface TypeDocumentGateway {

    List<TypeDocument> getAll();
    Optional<TypeDocument> getTypeDocumentById(int id);
    TypeDocument saveDocumentType(TypeDocument typeDocument);
    void deleteDocumentType(int id);

}
