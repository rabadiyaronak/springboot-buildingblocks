package learn.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import learn.restservices.dtos.UserMsDto;
import learn.restservices.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	// user to userMsDto
	@Mappings({ @Mapping(source = "email", target = "emailAddress"), @Mapping(source = "id", target = "userId") })
	UserMsDto userToUserMsDto(User user);

	// List<User> to List<UserMsDto>
	List<UserMsDto> usersToUserMsDtos(List<User> users);
}
