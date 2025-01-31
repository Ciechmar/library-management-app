package pl.sda.librarymanagementapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "libraryUsers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LibraryUser {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String password;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Book>books;

}
