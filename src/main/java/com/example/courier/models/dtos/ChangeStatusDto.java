package com.example.courier.models.dtos;

import com.example.courier.models.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangeStatusDto {
    @Enumerated(value = EnumType.STRING)
    OrderStatus status;
    int orderNum;
}
