package conference.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc

public class TestAdministrativeController {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    AdministrativeController controller;

    @Test
    @WithAnonymousUser
    public void testAccess() throws Exception{
        this.mockMvc.perform(post("/api/v1/registration/register").content("{\"username\":\"testcase\"," +
                        "\"password\":\"1\"}").contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "1", roles = {"ADMIN"})
    public void testAdmin() throws Exception{
        this.mockMvc.perform(get("/admin"))
                .andExpect(status().isOk());
    }
}
