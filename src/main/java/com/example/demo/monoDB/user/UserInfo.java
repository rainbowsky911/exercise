package com.example.demo.monoDB.user;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Document(collection = "user_collection")
@Accessors(chain = true)
public class UserInfo {

    @Id
    private Long id;

    private String username;

    private String password;
}
