package edu.byu.is560r.bsierra1notesapinew.model;

//import lombok.*;
//import lombok.experimental.Accessors;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Accessors
//@RequiredArgsConstructor
//@Entity
//
//
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long userId;
//
//    @NotEmpty(message = "first name is required")
//    @NonNull
//    @Column(length = 50)
//    private String firstName;
//
//    @NotEmpty(message = "last name is required")
//    @NonNull
//    @Column(length = 50)
//    private String lastName;
//
//    @NotEmpty(message = "email is required")
//    @NonNull
//    @Column(unique = true, length = 100)
//    private String email;
//
//    @Column(length = 10)
//    private String phoneNumber;
//
//
//}

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"id", "created_at"})
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name is required")
    @NonNull
    @Column(length = 50)
    private String firstName;

    @NotEmpty(message = "email is required")
    @NonNull
    @Column(unique = true, length = 100)
    private String email;

    @NotEmpty(message = "password_hash is required")
    @NonNull
    @Schema(hidden = true)
    private String passwordHash;

    @Schema(name = "password",
            required = true,
            example = "mypassword",
            accessMode = Schema.AccessMode.WRITE_ONLY)
    private transient String password;

    private Instant createdAt;

}