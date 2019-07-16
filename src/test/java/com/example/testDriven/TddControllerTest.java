package com.example.testDriven;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TddController.class)
@AutoConfigureMockMvc
public class TddControllerTest {

    @InjectMocks
    private TddController tddController;


    @Mock
     MockMvc mockMvc;



    @Mock
    TddServiceI mockTddService;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tddController)
                .build();



    }


    @Test
    public void getDetails() throws Exception {


        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");



        Mockito.when(mockTddService.getDetails()).thenReturn(tddModel);

        mockMvc.perform(get("/details"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Mayur"));


    }


    @Test
    public  void  addDetails() throws Exception {
        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");
        ObjectMapper objectMapper = new ObjectMapper();

        Mockito.when(mockTddService.addDetails(tddModel)).thenReturn("CREATED");
        String json = objectMapper.writeValueAsString(tddModel);
        mockMvc.perform(post("/details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
               // .content(json));

    }

    @Test
    public  void  updateDetailsTest() throws Exception {

        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(tddModel);

        String nameToBeUpdated ="testName";

        Mockito.when(mockTddService.updateDetails(tddModel,nameToBeUpdated)).thenReturn("UPDATED");

        mockMvc.perform(put("/details"+"/"+nameToBeUpdated)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());





    }

    @Test
    public  void deleteDetails() throws Exception {
        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(tddModel);


        Mockito.when(mockTddService.deleteDetails(tddModel)).thenReturn("DELETED");

         mockMvc.perform(delete("/details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());

    }








}
