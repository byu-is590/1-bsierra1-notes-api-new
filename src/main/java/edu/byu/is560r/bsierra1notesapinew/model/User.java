package edu.byu.is560r.bsierra1notesapinew.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
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

    @NotEmpty(message = "First Name is required")
    @NonNull
    @Column(length = 100)
    private String firstName;

    @NotEmpty(message = "Last Name is required")
    @NonNull
    @Column(length = 100)
    private String lastName;

    @NotEmpty(message = "Email is required")
    @NonNull
    @Column(length = 100)
    private String email;

    @NotEmpty(message = "password_hash is required")
    @NonNull
    @Schema(hidden = true)
    private String passwordHash;

    @Schema(name = "password",
            required = true,
            example = "mypassword",
            accessMode = Schema.AccessMode.WRITE_ONLY)
    @Transient
    private String password;

    @Schema(name = "already_exists",
            example = "false",
            accessMode = Schema.AccessMode.WRITE_ONLY)
    private transient Boolean alreadyExists;

    private Instant createdAt;
}