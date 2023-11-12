package br.com.brendosp.fisiocare.modules.user.entities;

import br.com.brendosp.fisiocare.modules.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

  @Column(length = 100, nullable = false)
  private String name;

  @Column(length = 45, nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;
}
