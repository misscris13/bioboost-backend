package com.cdtm.bioboost.login;

import com.cdtm.bioboost.user.UserService;
import com.cdtm.bioboost.user.model.User;
import com.cdtm.bioboost.user.model.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "User", description = "API of Login")
@RequestMapping(value = "/login")
@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    ModelMapper mapper;

    @Operation(summary = "Login", description = "Method that returns the list of users")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public UserDto login(@RequestBody UserDto dto) {
        User user = this.userService.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        return  mapper.map(user == null ? new UserDto() : user, UserDto.class) ;
    }

}
