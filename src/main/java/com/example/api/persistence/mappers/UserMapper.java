package com.example.api.persistence.mappers;

import com.example.api.domain.entities.User;
import com.example.api.persistence.models.UserDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TypeDocumentMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUser",target = "userId"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "lastname",target = "lastname"),
            @Mapping(source = "age",target = "age"),
            @Mapping(source = "city",target = "city"),
            @Mapping(source = "identicationNumber",target = "identicationNumber"),
            @Mapping(source = "documentTypeId",target = "documentTypeId"),
            @Mapping(source = "documentType",target = "typeDocument")
    })
    User toUser(UserDAO dao);

    List<User> toUsers(List<UserDAO> daos);

    @InheritInverseConfiguration
    UserDAO toUserDAO(User user);


}
