package cap.dragons.repository;

import cap.dragons.entity.EventUser;
import cap.dragons.entity.EventUserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, EventUserKey> {
}

