package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import com.cdtm.bioboost.user.model.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static final String USER_NAME = "u1";

    @Test
    public void saveNotExistsUserIdShouldInsert() {

        UserDto userDto = new UserDto();
        userDto.setUser(USER_NAME);

        ArgumentCaptor<User> user = ArgumentCaptor.forClass(User.class);

        userService.save(null, userDto);

        verify(userRepository).save(user.capture());

        assertEquals(USER_NAME, user.getValue().getUser());
    }

    public static final Long EXISTS_USER_ID = 1L;

    @Test
    public void saveExistsUserIdShouldUpdate() {

        UserDto userDto = new UserDto();
        userDto.setUser(USER_NAME);

        User user = mock(User.class);
        when(userRepository.findById(EXISTS_USER_ID)).thenReturn(Optional.of(user));

        userService.save(EXISTS_USER_ID, userDto);

        verify(userRepository).save(user);
    }

    @Test
    public void deleteExistsUserIdShouldDelete() throws Exception {

        User user = mock(User.class);
        when(userRepository.findById(EXISTS_USER_ID)).thenReturn(Optional.of(user));

        userService.delete(EXISTS_USER_ID);

        verify(userRepository).deleteById(EXISTS_USER_ID);
    }
}
