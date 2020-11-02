package me.rn00n.demoinfleanrestapi.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Inflean String REST API")
                .description("REST API development with Spring")
                .build();
        assertNotNull(event);
    }
    @Test
    public void javaBean() {
        String name = "Event";
        String description = "Spring";

        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        assertEquals(event.getName(), name);
        assertEquals(event.getDescription(), description);
    }
}