package com.example.testDriven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(TddService.class)
@AutoConfigureMockMvc
public class TddServiceTest {

    @Mock
    MockMvc mockMvc;

    @Mock
    TddDao tddDaoMock;


    @InjectMocks
     TddService mockTddService;

    @Test
    public  void  getDetailsTest() {


        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");
        Mockito.when(tddDaoMock.getDetails()).thenReturn(tddModel);



        TddModel tddModelFromDao = mockTddService.getDetails();
        Mockito.verify(tddDaoMock).getDetails();
        Assert.assertEquals(tddModelFromDao,tddModel);


    }

    @Test
    public  void addDetailsTest()
    {
        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");

        Mockito.when(tddDaoMock.addDetails(tddModel)).thenReturn("CREATED");
        String valueReturnedFromDao = mockTddService.addDetails(tddModel);
        Mockito.verify(tddDaoMock).addDetails(tddModel);

        Assert.assertEquals(valueReturnedFromDao,"CREATED");



    }

    @Test
    public void updateDetailsTest()
    {
        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");

        Mockito.when(tddDaoMock.updateDetails(tddModel,"Mayur")).thenReturn("UPDATED");
        String valueReturnedFromDao = mockTddService.updateDetails(tddModel,"Mayur");
        Mockito.verify(tddDaoMock).updateDetails(tddModel,"Mayur");
        Assert.assertEquals(valueReturnedFromDao,"UPDATED");



    }

    @Test
    public  void deleteDetailsTest()
    {
        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");
        Mockito.when(tddDaoMock.deleteDetails(tddModel)).thenReturn("DELETED");
        String valueReturnedFromDao = mockTddService.deleteDetails(tddModel);
        Mockito.verify(tddDaoMock).deleteDetails(tddModel);
        Assert.assertEquals(valueReturnedFromDao,"DELETED");

    }










}
