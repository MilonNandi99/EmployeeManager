package com.employeeManagemnet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@NotNull(message="Contact Details is mandatory")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(
        columnNames = {
                "phone_number",
                "email_id"
        }
))
@Getter @Setter
public class ContactDetails
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cid;
    @NotNull(message="Phone Number is mandatory.")
    @Digits(integer=10,fraction=0)
    private long phoneNumber;
    @NotBlank(message="Email ID is mandatory.")
    private String emailId;

}
