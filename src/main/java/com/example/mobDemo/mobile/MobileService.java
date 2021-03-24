package com.example.mobDemo.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MobileService {

    private final MobileRepository mobileRepository;

    @Autowired
    public MobileService(MobileRepository mobileRepository){
        this.mobileRepository = mobileRepository;
    }

    public List<Mobile> getAllMobiles(){
        return mobileRepository.findAll();
    }

    public List<Mobile> findMobileByBrandName(String BrandName){
        return mobileRepository.findAllByBrandName(BrandName);
    }
    public Mobile findMobileByModelName(String ModelName){
        return mobileRepository.findMobileByModelName(ModelName).orElseThrow(()-> new MobileNotFoundException(ModelName));
    }

    public ResponseEntity<Mobile> addNewMobile(Mobile mobile) {
       /* Optional<Mobile> mobileByModelName = mobileRepository
                .findMobileByModelName(mobile.getModelName());
        Optional<Mobile> mobileBySellerName = mobileRepository
                .findMobileBySellerName(mobile.getSellerName());


         */
        List<Mobile> mobileByModelName2 = mobileRepository.findAllByModelName(mobile.getModelName());
       List<Mobile> mobileBySellerName2 = mobileRepository.findAllBySellerName(mobile.getSellerName());
        if(mobileByModelName2.contains(mobile.getSellerName())){
            throw new IllegalStateException("Mobile already present in DB");
        }
        return ResponseEntity.status(HttpStatus.OK).body(mobileRepository.save(mobile));
    }

    public void deleteMobileEntry(Long id) {
        boolean exists = mobileRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Mobile with id"+id+" does not exist");
        }
        mobileRepository.deleteById(id);
    }
@Transactional
    public void updateMobileDetails(Long id, String sellerName, int price) {
        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Mobile with id "+id+" does not exist"));

        if(sellerName!=null &&
                sellerName.length()>0 &&
                !Objects.equals(mobile.getSellerName(),sellerName)
        ){
          mobile.setSellerName(sellerName);
        }
    if(price>0 &&
            !Objects.equals(mobile.getPrice(),price)
    ){
        mobile.setPrice(price);
    }
    }

    public List<Mobile> findMobileBySellerName(String sellerName) {
        return mobileRepository.findAllBySellerName(sellerName);
    }
}
