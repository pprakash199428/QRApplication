package com.spicejet.controller;

import com.spicejet.dto.PlaceVerification;
import com.spicejet.dto.PlaceVerificationResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CheckInController {

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    PlaceVerificationResponse latLongVerify(@RequestBody PlaceVerification placeVerification) {
        PlaceVerificationResponse placeVerificationResponse = new PlaceVerificationResponse();
//        String latSpiceJet = "28.499904";
//        String longSpiceJet = "77.081778";
        String latXebia = "28.459949";
        String longXebia = "77.051589";

        String lat = placeVerification.getLatitude();
        String longi = placeVerification.getLongitude();


        double R = 6378.137;
        double dLat = Double.parseDouble(lat) * Math.PI / 180 - Double.parseDouble(latXebia) * Math.PI / 180;
        double dLon = Double.parseDouble(longi) * Math.PI / 180 - Double.parseDouble(longXebia) * Math.PI / 180;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(Double.parseDouble(latXebia) * Math.PI / 180) * Math.cos(Double.parseDouble(lat) * Math.PI / 180) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;

        System.out.println("saaaaaaaaaaaa"+d*1000);
        if (d*1000 <= 50) {
            placeVerificationResponse.setStatus("CONFIRMED");
            placeVerificationResponse.setHotelName("SPICEJET");
            return placeVerificationResponse;
        } else {
            placeVerificationResponse.setStatus("COORDINATES DID NOT MATCH");
            placeVerificationResponse.setHotelName("");
            return placeVerificationResponse;
        }


    }
}
