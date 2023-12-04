package br.com.brendosp.fisiocare.modules.user.services.impl;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import br.com.brendosp.fisiocare.common.exceptions.UserException;
import br.com.brendosp.fisiocare.common.mappers.IUserMapper;
import br.com.brendosp.fisiocare.infra.http.dtos.request.CreateUserRequestDto;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import br.com.brendosp.fisiocare.modules.user.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @InjectMocks
  private UserServiceImpl sut;
  @Mock
  private IUserRepository userRepository;
  @Mock
  private IUserMapper userMapper;
  @Mock
  private PasswordEncoder passwordEncoder;
  private CreateUserRequestDto createUserDto;
  private User user;

  @BeforeEach
  void setUp() {
    createUserDto = new CreateUserRequestDto(
      "Brendo",
      "brendosp",
      "brendo@mail.com",
      "12345"
    );
    user = new User(
      createUserDto.name(),
      createUserDto.username(),
      createUserDto.email(),
      createUserDto.password()
    );
  }

  @Test
  @DisplayName("Should create user with valid data and return created user")
  void shouldCreateUserWithValidDataAndReturnCreatedUser() {
    when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
    when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
    when(userMapper.toEntity(createUserDto)).thenReturn(user);
    when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
    when(userRepository.save(user)).thenReturn(user);

    User createdUser = sut.create(createUserDto);

    verify(userRepository).findByUsername(createUserDto.username());
    verify(userRepository).findByEmail(createUserDto.email());
    verify(userMapper).toEntity(createUserDto);
    verify(passwordEncoder).encode(createUserDto.password());
    verify(userRepository).save(user);

    assertThat(createdUser.getName()).isEqualTo(createUserDto.name());
    assertThat(createdUser.getUsername()).isEqualTo(createUserDto.username());
    assertThat(createdUser.getEmail()).isEqualTo(createUserDto.email());
    assertThat(createdUser.getPassword()).isEqualTo("encodedPassword");
  }

  @Test
  @DisplayName("Should throw user exception when username already in use")
  void shouldThrowUserExceptionWhenUsernameAlreadyInUse() {
    when(userRepository.findByUsername(anyString()))
      .thenReturn(Optional.of(user));

    assertThatThrownBy(() -> sut.create(createUserDto))
      .isExactlyInstanceOf(UserException.class)
      .hasMessage("The username provided is already in use", user.getUsername());

    verify(userRepository).findByUsername(createUserDto.username());
    verify(userRepository, times(0)).findByEmail(anyString());
    verify(userMapper, times(0)).toEntity(any());
    verify(passwordEncoder, times(0)).encode(anyString());
    verify(userRepository, times(0)).save(any());
  }

  @Test
  @DisplayName("Should throw user exception when email already in use")
  void shouldThrowUserExceptionWhenEmailAlreadyInUse() {
    when(userRepository.findByUsername(anyString()))
      .thenReturn(Optional.empty());
    when(userRepository.findByEmail(anyString()))
      .thenReturn(Optional.of(user));

    assertThatThrownBy(() -> sut.create(createUserDto))
      .isExactlyInstanceOf(UserException.class)
      .hasMessage("The email provided is already in use");

    verify(userRepository).findByUsername(createUserDto.username());
    verify(userRepository).findByEmail(createUserDto.email());
    verify(userMapper, times(0)).toEntity(any());
    verify(passwordEncoder, times(0)).encode(anyString());
    verify(userRepository, times(0)).save(any());
  }
}