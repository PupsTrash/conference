package conference.service.admin;

import conference.controller.api.AdminDto;
import conference.db.RoleEntity;
import conference.db.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AdminControllerServiceMapper {

    public abstract List<AdminDto> toResponse(List<UserEntity> userEntity);

    @Mapping(target = "role", source = "roles", qualifiedByName = "userRoleEntityToSet")
    public abstract AdminDto toResponse(UserEntity userEntity);

@Named("userRoleEntityToSet")
    public Set<String> userRoleEntityToSet(Set<RoleEntity> roleEntity){
        return roleEntity.stream().map(p -> p.getHkey()).collect(Collectors.toSet());
    }

}
