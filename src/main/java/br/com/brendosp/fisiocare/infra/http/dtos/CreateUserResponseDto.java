package br.com.brendosp.fisiocare.infra.http.dtos;

public record CreateUserResponseDto(
  Long id,
  String name,
  String username,
  String email
) {}
