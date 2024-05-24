package com.example.courier.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "Last name is mandatory")
    String lastName;
    @NotBlank(message = "First name is mandatory")
    String firstName;
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Phone number is invalid")
    String phone;
}
