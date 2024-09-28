package cap.dragons.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDTO {
    private Long id;
    private String coordinates;
    private String eventType;
    private LocalDateTime eventDate;
    private String description;
    private String name;
}
