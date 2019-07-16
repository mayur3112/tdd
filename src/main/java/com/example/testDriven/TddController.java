package com.example.testDriven;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TddController {

    @Autowired
    TddServiceI tddService;


    @GetMapping("/details")
    public TddModel getDetails()
    {
        return tddService.getDetails();
    }

    @PostMapping("/details")
    public  String addDetail(@RequestBody TddModel tddModel)
    {
        return tddService.addDetails(tddModel);
    }

    @PutMapping("/details/{nameToBeUpdated}")
    public String updateDetails(@RequestBody TddModel tddModel ,@PathVariable("nameToBeUpdated") String nameToBeUpdated) {
        return tddService.updateDetails(tddModel, nameToBeUpdated);
    }
    @DeleteMapping("/details")
    public String updateDetails(@RequestBody TddModel tddModel) {
        return tddService.deleteDetails(tddModel);
    }





}
