package br.com.brendosp.fisiocare.infra.http.controllers;

import br.com.brendosp.fisiocare.common.mappers.IUserMapper;
import br.com.brendosp.fisiocare.infra.http.dtos.CreateUserRequestDto;
import br.com.brendosp.fisiocare.infra.http.dtos.CreateUserResponseDto;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import br.com.brendosp.fisiocare.modules.user.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final IUserService userService;
  private final IUserMapper userMapper;

  public UserController(IUserService userService, IUserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @PostMapping
  public ResponseEntity<CreateUserResponseDto> register(@RequestBody CreateUserRequestDto createUserRequestDto) {
    User createdUser = userService.create(createUserRequestDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(createdUser));
  }
}
