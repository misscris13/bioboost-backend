package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.UserDto;

import java.util.List;

public interface UserService {

    /**
     * Method that returns all users
     *
     * @return {@link List} of {@link UserDto}
     */
    List<UserDto> findAll();

    /**
     * Method that creates or edits a user
     *
     * @param id    PK of user
     * @param dto   User data
     */
    void save (Long id, UserDto dto);

    /**
     * Method that deletes a user
     *
     * @param id    PK of user
     */
    void delete (Long id);
}
