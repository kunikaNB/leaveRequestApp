package com.kunika.leaveRequestApp.Repository;

import com.kunika.leaveRequestApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void deleteById(Long id);
}
