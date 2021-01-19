package com.example.democassandra.repositories;

import com.example.democassandra.datatypes.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
//    @Query("SELECT * FROM user where userId=?0")
//    public User fetchByUserId(int userId);
}
