package com.cdtm.bioboost.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdtm.bioboost.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "User", description = "API of User")
@RequestMapping(value = "/user")
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Method that returns all users
     * Path: /user
     *
     * @return {@link List} of {@link UserDto}
     */
    @Operation(summary = "Find", description = "Method that returns the list of users")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<UserDto> findAll() {

        return this.userService.findAll();
    }

    /**
     * Method that creates or updates a user
     * Path: /user/id
     *
     * @param id    PK of user
     * @param dto   User data
     */
    @Operation(summary = "Save or Update", description = "Method that creates or updates a user")
    @RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody UserDto dto) {

        this.userService.save(id, dto);
    }

    /**
     * Method that deletes a user
     *
     * @param id    PK of user
     */
    @Operation(summary = "Delete", description = "Method that deletes a user")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.userService.delete(id);
    }

}