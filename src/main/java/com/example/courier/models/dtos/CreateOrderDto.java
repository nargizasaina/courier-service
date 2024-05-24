package com.example.courier.models.dtos;

import com.example.courier.models.Address;
import com.example.courier.models.Client;
import com.example.courier.models.Parcel;
import com.example.courier.models.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderDto {
    Date deliveryTime;
    Address pickUpAddress;
    Address deliveryAddress;
    Client sender;
    Client recipient;
    Parcel parcel;
}
