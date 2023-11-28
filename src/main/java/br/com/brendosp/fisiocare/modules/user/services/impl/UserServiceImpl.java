package br.com.brendosp.fisiocare.modules.user.services.impl;

import br.com.brendosp.fisiocare.common.exceptions.UserException;
import br.com.brendosp.fisiocare.common.mappers.IUserMapper;
import br.com.brendosp.fisiocare.infra.http.dtos.CreateUserRequestDto;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import br.com.brendosp.fisiocare.modules.user.repositories.IUserRepository;
import br.com.brendosp.fisiocare.modules.user.services.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final IUserRepository userRepository;
  private final IUserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(IUserRepository userRepository, IUserMapper userMapper, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User create(CreateUserRequestDto createUserDto) {
    if (userRepository.findByUsername(createUserDto.username()).isPresent()) {
      throw UserException.usernameAlreadyInUse();
    }

    if (userRepository.findByEmail(createUserDto.email()).isPresent()) {
      throw UserException.emailAlreadyInUse();
    }

    User user = userMapper.toEntity(createUserDto);

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.save(user);
  }
}
