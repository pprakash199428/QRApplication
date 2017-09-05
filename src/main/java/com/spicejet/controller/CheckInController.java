package com.spicejet.controller;

import com.spicejet.dto.PlaceVerification;
import com.spicejet.dto.PlaceVerificationResponse;
import org.springframework.web.bind.annotation.*;

import com.spicejet.dto.User;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CheckInController {

	@RequestMapping(value= "/checkin", method = RequestMethod.POST)
    PlaceVerificationResponse latLongVerify(@RequestBody PlaceVerification placeVerification){
        PlaceVerificationResponse placeVerificationResponse=new PlaceVerificationResponse();
        String latSpiceJet = "28.499904";
        String longSpiceJet = "77.081778";
        String latXebia = "28.459949";
        String longXebia = "77.051589";

        String lat = placeVerification.getLatitude();
        String longi = placeVerification.getLongitude();
        if(lat.equalsIgnoreCase(latSpiceJet) && longi.equalsIgnoreCase(longSpiceJet) ){
            placeVerificationResponse.setStatus("CONFIRMED");
            placeVerificationResponse.setHotelName("SPICEJET");
            return placeVerificationResponse;
        }
        else if(lat.equalsIgnoreCase(latXebia) && longi.equalsIgnoreCase(longXebia) ) {
            placeVerificationResponse.setStatus("CONFIRMED");
            placeVerificationResponse.setHotelName("XEBIA");
            return placeVerificationResponse;
        }
        else {
            placeVerificationResponse.setStatus("COORDINATES DID NOT MATCH");
            placeVerificationResponse.setHotelName("");
            return placeVerificationResponse;
        }
    }
}
