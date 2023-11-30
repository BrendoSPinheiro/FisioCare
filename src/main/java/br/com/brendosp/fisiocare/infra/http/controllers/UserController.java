package br.com.brendosp.fisiocare.infra.http.controllers;

import br.com.brendosp.fisiocare.common.mappers.IUserMapper;
import br.com.brendosp.fisiocare.infra.http.dtos.request.CreateUserRequestDto;
import br.com.brendosp.fisiocare.infra.http.dtos.response.CreateUserResponseDto;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import br.com.brendosp.fisiocare.modules.user.services.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private static final Logger logger = LogManager.getLogger(UserController.class);
  private final IUserService userService;
  private final IUserMapper userMapper;

  public UserController(IUserService userService, IUserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @PostMapping
  public ResponseEntity<CreateUserResponseDto> register(@RequestBody CreateUserRequestDto createUserRequestDto) {
    logger.info("Received request to register a new user");
    User createdUser = userService.create(createUserRequestDto);
    logger.info("Finished process to register a new user");

    return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.toDto(createdUser));
  }
}
