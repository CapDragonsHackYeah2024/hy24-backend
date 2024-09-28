package cap.dragons.entity;

import cap.dragons.domain.EventType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coordinates;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDateTime eventDate;

    private String description;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventUser> eventUsers;

}
