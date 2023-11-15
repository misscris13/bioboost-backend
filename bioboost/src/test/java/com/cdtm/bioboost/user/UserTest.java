package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void findAllShouldReturnAllUsers() {

        List<User> list = new ArrayList<>();
        list.add(mock(User.class));

        when(userRepository.findAll()).thenReturn(list);

        List<User> users = userService.findAll();

        assertNotNull(users);
        assertEquals(1, users.size());
    }
}
