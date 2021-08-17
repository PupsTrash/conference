package conference.db;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ROLE")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_GEN")
    @SequenceGenerator(name = "ROLE_GEN", sequenceName = "role_seq", allocationSize = 1)
    private Long id;


    private String name;
    private String hkey;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
