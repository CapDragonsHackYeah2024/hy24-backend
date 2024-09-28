package cap.dragons.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_users")
public class EventUser {

    @EmbeddedId
    private EventUserKey id = new EventUserKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;

    private boolean isCreator;

    // Getters and Setters
}
