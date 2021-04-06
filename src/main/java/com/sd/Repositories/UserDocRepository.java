package com.sd.Repositories;

import com.sd.Models.UserDoc;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*@EnableJpaRepositories
class Config {}*/


public interface UserDocRepository extends CrudRepository<UserDoc, Long> {

    List<UserDoc> findByUsernameAndPassword(String username, String password);
}