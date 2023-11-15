package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
