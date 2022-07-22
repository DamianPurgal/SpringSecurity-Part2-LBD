package lbd.fissst.springsecurity2lbd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getMultiplier() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/number"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.valueOne").isNumber())
                .andExpect(jsonPath("$.valueTwo").isNumber());
    }
    
}
