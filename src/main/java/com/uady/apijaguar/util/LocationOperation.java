package com.uady.apijaguar.util;

public class LocationOperation {
    
    private static LocationOperation instance;

    private LocationOperation(){}

    public static LocationOperation getInstance(){
        if(instance == null){
            instance = new LocationOperation();
        } 
        return instance;
    }
    /*
    public double distance(double lat1, double lon1, double lat2, double lon2) {
        // haversine great circle distance approximation, returns meters
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60; // 60 nautical miles per degree of seperation
        dist = dist * 1852; // 1852 meters per nautical mile
        return (dist);
    }*/

    public double distance(double lat1, double lng1, double lat2, double lng2) {

        double earthRadius = 6371; //3958.75; // in miles, change to 6371 for kilometer output
    
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
    
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
    
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
    
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    
        double dist = earthRadius * c;
    
        return dist; // output distance, in MILES
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
