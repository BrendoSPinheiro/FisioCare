package br.com.brendosp.fisiocare.modules.user.entities;

import br.com.brendosp.fisiocare.modules.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "tb_users")
public class User extends BaseEntity {

  @Column(length = 100, nullable = false)
  private String name;

  @Column(length = 45, nullable = false, unique = true)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  public User() {}

  public User(String name, String username, String email, String password) {
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof User user)) return false;

    return new EqualsBuilder().appendSuper(super.equals(o))
      .append(name, user.name).append(username, user.username)
      .append(email, user.email).append(password, user.password)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .appendSuper(super.hashCode()).append(name)
      .append(username).append(email).append(password)
      .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("name", name)
      .append("username", username)
      .append("email", email)
      .append("password", password)
      .toString();
  }
}
