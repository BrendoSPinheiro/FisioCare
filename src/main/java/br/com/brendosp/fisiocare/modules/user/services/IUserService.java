package br.com.brendosp.fisiocare.modules.user.services;

import br.com.brendosp.fisiocare.infra.http.dtos.request.CreateUserRequestDto;
import br.com.brendosp.fisiocare.modules.user.entities.User;

public interface IUserService {
  User create(CreateUserRequestDto createUserDto);
}
