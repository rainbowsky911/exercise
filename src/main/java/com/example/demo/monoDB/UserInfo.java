package com.example.demo.monoDB;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class UserInfo {


    @Id
    private Long id;

    private String username;

    private String password;
}
