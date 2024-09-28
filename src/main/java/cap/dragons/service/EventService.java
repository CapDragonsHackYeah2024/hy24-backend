package cap.dragons.service;

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

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found"));
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Event not found"));
        existingEvent.setCoordinates(updatedEvent.getCoordinates());
        existingEvent.setEventType(updatedEvent.getEventType());
        existingEvent.setEventDate(updatedEvent.getEventDate());
        existingEvent.setDescription(updatedEvent.getDescription());
        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

