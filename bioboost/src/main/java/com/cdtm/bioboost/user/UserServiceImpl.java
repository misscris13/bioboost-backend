package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import com.cdtm.bioboost.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    public List<User> findAll() {

        return (List<User>) this.userRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    public void save(Long id, UserDto dto) {

        User user;

        if (id == null) {
            user = new User();
        } else {
            user = this.userRepository.findById(id).orElse(null);
        }

        user.setUser(dto.getUser());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        this.userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    public void delete(Long id) throws Exception {

        if (this.userRepository.findById(id).orElse(null) == null) {
            throw new Exception("Not exists");
        }

        this.userRepository.deleteById(id);
    }
}
