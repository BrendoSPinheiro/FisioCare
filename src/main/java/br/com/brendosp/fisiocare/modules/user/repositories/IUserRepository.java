package br.com.brendosp.fisiocare.modules.user.repositories;

import br.com.brendosp.fisiocare.modules.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String email);
}
