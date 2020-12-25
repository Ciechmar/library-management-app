package pl.sda.librarymanagementapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.librarymanagementapp.domain.user.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Integer year;
    @NotNull
    private String email; //email jest loginem
    private Long tel;
    @NotNull
    private Role role;


}
