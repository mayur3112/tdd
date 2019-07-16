package com.example.testDriven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TddService implements TddServiceI {

    @Autowired
    TddDao tddDao;
    @Override
    public TddModel getDetails() {
        return  tddDao.getDetails();
    }
    @Override
    public String addDetails(TddModel tddModel) {
        return tddDao.addDetails(tddModel);
    }

    @Override
    public String updateDetails(TddModel tddModel, String nameToBeUpdated) {
        return tddDao.updateDetails(tddModel,nameToBeUpdated);
    }

    @Override
    public String deleteDetails(TddModel tddModel) {
       return tddDao.deleteDetails(tddModel);
    }
}
