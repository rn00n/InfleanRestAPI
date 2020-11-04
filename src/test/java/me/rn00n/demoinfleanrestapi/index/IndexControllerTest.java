package me.rn00n.demoinfleanrestapi.index;

import me.rn00n.demoinfleanrestapi.common.BaseControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IndexControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("인덱스 화면")
    public void index() throws Exception {
        mockMvc.perform(get("/api"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("_links.events").exists())
        ;
    }

}
