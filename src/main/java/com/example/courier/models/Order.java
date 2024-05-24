package com.example.courier.models;

import com.example.courier.models.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    Long id;
    Date deliveryTime;
    @Enumerated(value = EnumType.STRING)
    OrderStatus status;
    Double price;
    @Column(unique = true)
    int orderNum;
    @PrePersist
    public void generateOrderNum() {
        this.orderNum = generateUniqueOrderNum();
    }

    private int generateUniqueOrderNum() {
        return (int) (System.currentTimeMillis() & 0xfffffff);
    }

    @ManyToOne
    @JoinColumn(name = "parcel_id")
    Parcel parcel;
    @ManyToOne
    @JoinColumn(name = "pick_up_address_id")
    Address pickUpAddress;
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    Address deliveryAddress;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    Client sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    Client recipient;
}
