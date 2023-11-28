package br.com.brendosp.fisiocare.common.mappers;

import br.com.brendosp.fisiocare.infra.http.dtos.CreateUserRequestDto;
import br.com.brendosp.fisiocare.infra.http.dtos.CreateUserResponseDto;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUserMapper {
  User toEntity(CreateUserRequestDto createUserDto);

  CreateUserResponseDto toDto(User user);
}
