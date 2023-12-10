package com.example.api.persistence;

import com.example.api.domain.entities.TypeDocument;
import com.example.api.domain.gateways.TypeDocumentGateway;
import com.example.api.persistence.crud.TypeDocumentCrudRepository;
import com.example.api.persistence.mappers.TypeDocumentMapper;
import com.example.api.persistence.models.TypeDocumentDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeDocumentRepository implements TypeDocumentGateway {

    private TypeDocumentCrudRepository crudRepository;

    private TypeDocumentMapper mapper ;

    public TypeDocumentRepository(TypeDocumentCrudRepository crudRepository, TypeDocumentMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    @Override
    public List<TypeDocument> getAll() {
       List<TypeDocumentDAO> daos = (List<TypeDocumentDAO>) crudRepository.findAll();
       List<TypeDocument> documentList = mapper.toTypeDocuments(daos);
       return documentList;
    }

    @Override
    public Optional<TypeDocument> getTypeDocumentById(int id) {
        return crudRepository.findById(id).map(td -> mapper.toTypeDocument(td));
    }

    @Override
    public TypeDocument saveDocumentType(TypeDocument typeDocument) {
        TypeDocumentDAO dao = mapper.toTypeDocumentDAO(typeDocument);
        return mapper.toTypeDocument(crudRepository.save(dao));
    }

    @Override
    public void deleteDocumentType(int id) {
        crudRepository.deleteById(id);
    }

    /*
        patrón de diseño: suministrar las dependencias
        a una clase en vez de que esa misma clase
        tenga que encargarse de crearlas

        1. Por constructor( porque es la más óptima)
        2. @Autowired
        3. método set
     */




}
