package com.sd.Repositories;

import com.sd.Models.Medicine;
import com.sd.Models.Patient;
import com.sd.Models.Profile;
import com.sd.Models.UserDoc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    List<Profile> findById(long id);
//
    @Modifying
    @Transactional
    @Query("delete from Profile profile where profile.id=?1")
    void deleteOld(long id);
}