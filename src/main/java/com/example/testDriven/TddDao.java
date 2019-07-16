package com.example.testDriven;

public interface TddDao {

    TddModel getDetails();
    String addDetails(TddModel tddModel);

    String updateDetails(TddModel tddModel, String nameToBeUpdated);

    String deleteDetails(TddModel tddModel);
}
