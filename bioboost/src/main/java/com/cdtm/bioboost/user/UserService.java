package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import com.cdtm.bioboost.user.model.UserDto;

import java.util.List;

public interface UserService {

    /**
     * Method that returns all users
     *
     * @return {@link List} of {@link User}
     */
    List<User> findAll();

    /**
     * Method that returns all users
     *
     * @return {@link User} of {@link User}
     */
    User findByEmailAndPassword(String email, String password);

    /**
     * Method that creates or edits a {@link User}
     *
     * @param id    PK of user
     * @param dto   User data
     */
    void save (Long id, UserDto dto);

    /**
     * Method that deletes a {@link User}
     *
     * @param id    PK of user
     */
    void delete (Long id) throws Exception;
}
