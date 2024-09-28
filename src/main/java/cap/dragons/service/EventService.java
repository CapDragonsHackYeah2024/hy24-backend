package cap.dragons.service;

import cap.dragons.domain.EventDTO;
import cap.dragons.domain.EventType;
import cap.dragons.domain.mapper.EventMapper;
import cap.dragons.entity.Event;
import cap.dragons.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toDTO(savedEvent);
    }

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDTOList(events);
    }

    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found"));
        return eventMapper.toDTO(event);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found"));

        // Update the existing event fields with the data from DTO
        existingEvent.setCoordinates(eventDTO.getCoordinates());
        existingEvent.setEventType(EventType.valueOf(eventDTO.getEventType()));
        existingEvent.setEventDate(eventDTO.getEventDate());
        existingEvent.setDescription(eventDTO.getDescription());

        Event updatedEvent = eventRepository.save(existingEvent);
        return eventMapper.toDTO(updatedEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}