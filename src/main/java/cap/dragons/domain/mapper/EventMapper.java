package cap.dragons.domain.mapper;

import cap.dragons.domain.EventDTO;
import cap.dragons.entity.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO toDTO(Event event);

    Event toEntity(EventDTO eventDTO);

    List<EventDTO> toDTOList(List<Event> events);
}

