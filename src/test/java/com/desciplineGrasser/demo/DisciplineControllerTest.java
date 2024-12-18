package com.desciplineGrasser.demo;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DisciplineController.class)
class disciplineControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DisciplineService disciplineService;

    @Test
    void testCreatediscipline() throws Exception {
        Discipline discipline = new discipline("John Doe", "john.doe@example.com", 30);

        when(disciplineService.saveDiscipline(Mockito.any(Discipline.class))).thenReturn(discipline);

        mockMvc.perform(post("/api/disciplines")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"age\": 30}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"))
                .andExpect(jsonPath("$.age").value(30));
    }

    @Test
    void testGetAlldisciplines() throws Exception {
        Discipline discipline1 = new discipline("John Doe", "john.doe@example.com", 30);
        Discipline discipline2 = new discipline("Jane Smith", "jane.smith@example.com", 25);

        when(disciplineService.getAllDisciplines()).thenReturn(Arrays.asList(discipline1, discipline2));

        mockMvc.perform(get("/api/disciplines"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"));
    }

    @Test
    void testGetdisciplineById() throws Exception {
        Discipline discipline = new discipline("John Doe", "john.doe@example.com", 30);
        when(disciplineService.getDisciplineById("1")).thenReturn(Optional.of(discipline));

        mockMvc.perform(get("/api/disciplines/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    void testDeletediscipline() throws Exception {
        doNothing().when(disciplineService).deletediscipline("1");

        mockMvc.perform(delete("/api/disciplines/1"))
                .andExpect(status().isNoContent());
    }
}