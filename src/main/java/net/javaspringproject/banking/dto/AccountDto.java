package net.javaspringproject.banking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String accHolderName;
    private double balance;


}
