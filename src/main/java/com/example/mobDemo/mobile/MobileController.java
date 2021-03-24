package com.example.mobDemo.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mobile")
public class MobileController {

    private final MobileService mobileService;

    @Autowired
    public MobileController(MobileService mobileService){
        this.mobileService = mobileService;
    }

    @GetMapping
    public List<Mobile> getAllMobiles(){
        return mobileService.getAllMobiles();
    }

    @PostMapping
    public ResponseEntity<Mobile> enterNewMob(@RequestBody Mobile mobile){
       // return mobileService.addNewMobile(mobile);
        return mobileService.addNewMobile(mobile);
    }

    @DeleteMapping(path = "{mobileId}")
    public void deleteMobile(@PathVariable("mobileId") Long id){
        mobileService.deleteMobileEntry(id);
    }

    @PutMapping(path = "{mobileId}")
    public void updateMobileDetails(
            @PathVariable("mobileId") Long id,
            @RequestParam(required = false) String sellerName,
            @RequestParam(required = false) int price) {
         mobileService.updateMobileDetails(id,sellerName,price);
    }

    @GetMapping(path = "/findByBrandName/{BrandName}")
    public List<Mobile> findMobileByBrandName(@PathVariable("BrandName") String brandName){
        return mobileService.findMobileByBrandName(brandName);
    }

    @GetMapping(path = "/findByModelName/{ModelName}")
    public Mobile findMobileByModelName(@PathVariable("ModelName") String modelName){
        return mobileService.findMobileByModelName(modelName);
    }

    @GetMapping(path = "/findBySellerName/{SellerName}")
    public List<Mobile> findMobileBySellerName(@PathVariable("SellerName") String sellerName){
        return mobileService.findMobileBySellerName(sellerName);
    }
}
