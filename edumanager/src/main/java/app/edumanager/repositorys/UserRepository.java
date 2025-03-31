package app.edumanager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import app.edumanager.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
