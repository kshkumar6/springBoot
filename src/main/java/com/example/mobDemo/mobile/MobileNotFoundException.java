package com.example.mobDemo.mobile;

public class MobileNotFoundException extends RuntimeException{
    MobileNotFoundException(Long id) {
        super("Could not find mobile: "+id);
    }
    MobileNotFoundException(String brandName) {
        super("Could not find mobile: "+brandName);
    }
}
