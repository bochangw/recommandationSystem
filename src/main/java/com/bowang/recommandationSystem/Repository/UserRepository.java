package com.bowang.recommandationSystem.Repository;

import com.bowang.recommandationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
