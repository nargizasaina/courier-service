package com.example.courier.services;

import com.example.courier.models.Parcel;
import com.example.courier.models.dtos.CreateOrderDto;

public interface ParcelService {
    Parcel createParcel(Parcel parcel);

    double calculateDeliveryCost(Parcel parcel);
}
