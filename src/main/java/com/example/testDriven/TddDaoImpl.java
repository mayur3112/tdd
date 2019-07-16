package com.example.testDriven;

import org.springframework.stereotype.Repository;

@Repository
public class TddDaoImpl  implements  TddDao{
    @Override
    public TddModel getDetails() {
        TddModel tddModel = new TddModel();
        tddModel.setName("Mayur");
        return tddModel;
    }

    @Override
    public String addDetails(TddModel tddModel) {
        return "CREATED";
    }

    @Override
    public String updateDetails(TddModel tddModel, String nameToBeUpdated) {
        return "UPDATED";
    }

    @Override
    public String deleteDetails(TddModel tddModel) {
        return "DELETED";
    }
}
