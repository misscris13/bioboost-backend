package com.cdtm.bioboost.user;

import com.cdtm.bioboost.user.model.User;
import com.cdtm.bioboost.user.model.UserDto;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIT {

    public static final String LOCALHOST = "http://localhost:";
    public static final String SERVICE_PATH = "/user";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    ParameterizedTypeReference<List<UserDto>> responseType = new ParameterizedTypeReference<List<UserDto>>(){};

    @Test
    public void findAllShouldReturnAllUsers() {

        ResponseEntity<List<UserDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);

        assertNotNull(response);
        assertEquals(2, response.getBody().size());
    }

    public static final Long NEW_USER_ID = 12L;
    public static final String NEW_USER_NAME = "u3";
    public static final String NEW_USER_PASS = "p3";

    @Test
    public void saveWithoutIdShouldCreateNewUser() {

        UserDto dto = new UserDto();
        dto.setUser(NEW_USER_NAME);
        dto.setPassword(NEW_USER_PASS);

        restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.PUT, new HttpEntity<>(dto), Void.class);

        ResponseEntity<List<UserDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);
        assertNotNull(response);
        assertEquals(3, response.getBody().size());

        UserDto userSearch = response.getBody().stream().filter(item -> item.getId().equals(NEW_USER_ID)).findFirst().orElse(null);
        assertNotNull(userSearch);
        assertEquals(NEW_USER_NAME, userSearch.getUser());
    }

    public static final Long MODIFY_USER_ID = 2L;

    @Test
    public void modifyWithExistsIdShouldModifyUser() {

        UserDto dto = new UserDto();
        dto.setUser(NEW_USER_NAME);
        dto.setPassword(NEW_USER_PASS);

        restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + "/" + MODIFY_USER_ID, HttpMethod.PUT, new HttpEntity<>(dto), Void.class);

        ResponseEntity<List<UserDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);
        assertNotNull(response);
        assertEquals(2, response.getBody().size());

        UserDto userSearch = response.getBody().stream().filter(item -> item.getId().equals(MODIFY_USER_ID)).findFirst().orElse(null);
        assertNotNull(userSearch);
        assertEquals(NEW_USER_NAME, userSearch.getUser());
    }

    public static final Long NOT_EXISTS_ID = 3L;

    @Test
    public void modifyWithNotExistIdShouldInternalError() {

        UserDto dto = new UserDto();
        dto.setUser(NEW_USER_NAME);
        dto.setPassword(NEW_USER_PASS);

        ResponseEntity<?> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + "/" + NOT_EXISTS_ID, HttpMethod.PUT, new HttpEntity<>(dto), Void.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    public static final Long DELETE_USER_ID = 12L;

    @Test
    public void deleteWithExistsIdShouldDeleteUser() {

        restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + "/" + DELETE_USER_ID, HttpMethod.DELETE, null, Void.class);

        ResponseEntity<List<UserDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);
        assertNotNull(response);
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void deleteWithNotExistsIdShouldInternalError() {

        ResponseEntity<?> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + "/" + NEW_USER_ID, HttpMethod.DELETE, null, Void.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
