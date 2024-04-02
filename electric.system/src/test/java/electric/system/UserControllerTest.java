package electric.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import electric.system.controller.UserController;
import electric.system.model.User;
import electric.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAllUsers() throws Exception {
        // Mocking userService.getAllUsers() to return a list of users
        User user1 = new User("Doe", "John", "john.doe@example.com", "password123");
        User user2 = new User("Smith", "Jane", "jane.smith@example.com", "password456");
        List<User> userList = Arrays.asList(user1, user2);
        when(userService.getAllUsers()).thenReturn(userList);

        // Perform GET request to retrieve all users
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].surName").value("Doe"))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[1].surName").value("Smith"))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].email").value("jane.smith@example.com"));
    }

    @Test
    public void testGetUserById() throws Exception {
        // Mocking userService.getUserById() to return a user
        User user = new User("Doe", "John", "john.doe@example.com", "password123");
        when(userService.getUserById(1L)).thenReturn(user);

        // Perform GET request to retrieve a user by ID
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.surName").value("Doe"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    public void testCreateUser() throws Exception {
        // Create a new user
        User user = new User("Doe", "John", "john.doe@example.com", "password123");
        String userJson = new ObjectMapper().writeValueAsString(user);

        // Mocking userService.createUser() to return the created user
        when(userService.createUser(any(User.class))).thenReturn(user);

        // Perform POST request to create a user
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.surName").value("Doe"))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        // Perform DELETE request to delete a user by ID
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isAccepted())
                .andExpect(content().string("User deleted successfully"));
    }
}
