package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.UserDto;
import org.springframework.stereotype.Service;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<Long, UserDto> users = new HashMap<Long, UserDto>();

    /**
     * {@inheritDoc}
     */
    public List<UserDto> findAll() {

        return new ArrayList<UserDto>(this.users.values());
    }

    /**
     * {@inheritDoc}
     */
    public void save(Long id, UserDto dto) {

        UserDto user;

        if (id == null) {
            user = new UserDto();
            this.users.put(user.getId(), user);
        } else {
            System.out.println(id);
            user = this.users.get(id);
        }

        user.setUser(dto.getUser());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
    }

    /**
     * {@inheritDoc}
     */
    public void delete(Long id) {

        this.users.remove(id);
    }
}
