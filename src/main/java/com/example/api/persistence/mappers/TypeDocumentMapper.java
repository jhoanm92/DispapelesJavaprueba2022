package com.example.api.persistence.mappers;

import com.example.api.domain.entities.TypeDocument;
import com.example.api.persistence.TypeDocumentRepository;
import com.example.api.persistence.models.TypeDocumentDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;


import java.util.List;


@Mapper(componentModel = "spring")
public interface TypeDocumentMapper {

    @Mappings({
            @Mapping(source = "idTypeDocument",target = "idTypeDocument"),
            @Mapping(source = "name",target = "name")
    })
    TypeDocument toTypeDocument(TypeDocumentDAO dao);

    List<TypeDocument> toTypeDocuments(List<TypeDocumentDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "users",ignore = true )
    TypeDocumentDAO toTypeDocumentDAO(TypeDocument document);
}
