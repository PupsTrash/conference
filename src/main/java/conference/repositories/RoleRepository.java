package conference.repositories;

import conference.db.RoleEntity;
import conference.db.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
