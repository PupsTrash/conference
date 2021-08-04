package conference.db;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Talk {
    @Id
    private Long id;

    private String title;
    private String description;
    private Date start_at;
    private Date finish_at;

}
