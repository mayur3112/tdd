package com.example.testDriven;

import com.example.testDriven.TddModel;
import org.springframework.stereotype.Service;


public interface TddServiceI {
    public TddModel getDetails();

   public String addDetails(TddModel tddModel);

    String updateDetails(TddModel tddModel, String nameToBeUpdated);

    String deleteDetails(TddModel tddModel);
}
