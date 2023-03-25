package kg.ulan.SpringSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name="person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "The username should not be empty")
    @Size(min = 3, max = 100, message = "The username should be between 3 and 100")
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Min(value = 1900, message = "The year of birth should be higher than 1900")
    @Column(name = "year_of_birth")
    private int birthYear;
    @Column(name = "role")
    private String role;

}
