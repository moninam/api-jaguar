package com.uady.apijaguar.collection;

import com.uady.apijaguar.model.Museo;

public class MuseoUbicacion implements Comparable<MuseoUbicacion> {
    private Double distance;
    private Museo museo;

    public Double getDistance(){
        return this.distance;
    }

    public Museo getMuseo(){
        return this.museo;
    }

    public void setDistance(Double distance){
        this.distance = distance;
    }
    
    public void setMuseo(Museo museo){
        this.museo = museo;
    }

    @Override
    public String toString(){
        return "Lista: [Distancia= " + getDistance() + ", Museo= " + getMuseo().getNombre() + "]";
    }
    @Override
    public int compareTo(MuseoUbicacion o){
        return this.getDistance().compareTo(o.getDistance());
    }
}
