package me.wonwoo.user.repository;

import me.wonwoo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 5. 4..
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
