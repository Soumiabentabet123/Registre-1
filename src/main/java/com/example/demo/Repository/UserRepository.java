package com.example.demo.Repository;
import com.example.demo.Entity.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls,Integer>{

}
