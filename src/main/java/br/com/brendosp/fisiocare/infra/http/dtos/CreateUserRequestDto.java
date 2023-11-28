package br.com.brendosp.fisiocare.infra.http.dtos;

public record CreateUserRequestDto(
  String name,
  String username,
  String email,
  String password
) {}
