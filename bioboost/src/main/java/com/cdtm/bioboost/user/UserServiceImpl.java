package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import com.cdtm.bioboost.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
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
