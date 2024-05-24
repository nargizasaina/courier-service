package com.example.courier.services.impl;

import com.example.courier.models.Parcel;
import com.example.courier.repos.ParcelRepo;
import com.example.courier.services.ParcelService;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {
    private final ParcelRepo parcelRepo;

    public ParcelServiceImpl(ParcelRepo parcelRepo) {
        this.parcelRepo = parcelRepo;
    }

    @Override
    public Parcel createParcel(Parcel parcel) {
        Parcel newParcel = new Parcel();
        newParcel.setWidth(parcel.getWidth());
        newParcel.setHeight(parcel.getHeight());
        newParcel.setLength(parcel.getLength());
        newParcel.setWeight(parcel.getWeight());
        parcelRepo.save(newParcel);
        return newParcel;
    }

    @Override
    public double calculateDeliveryCost(Parcel parcel) {
        double volume = (parcel.getHeight() / 100.0) * (parcel.getLength() / 100.0) * (parcel.getWidth() / 100.0);
        double costByVolume = volume * 1000;

        double costByWeight = parcel.getWeight() * 100;

        return Math.max(costByVolume, costByWeight);
    }
}
