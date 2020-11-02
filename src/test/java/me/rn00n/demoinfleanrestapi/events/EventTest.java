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

    @Test
    public void testFree() {
        Event event = null;
        // Given
        event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();
        // When
        event.update();
        // Then
        assertTrue(event.isFree());

        // Given
        event = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();
        // When
        event.update();
        // Then
        assertFalse(event.isFree());

        // Given
        event = Event.builder()
                .basePrice(0)
                .maxPrice(100)
                .build();
        // When
        event.update();
        // Then
        assertFalse(event.isFree());
    }

    @Test
    public void testOffline() {
        Event event = null;
        // Given
        event = Event.builder()
                .location("강남역 네이버 D2 스타텁 팩토리")
                .build();
        // When
        event.update();
        // Then
        assertTrue(event.isOffline());

        // Given
        event = Event.builder()
                .build();
        // When
        event.update();
        // Then
        assertFalse(event.isOffline());
    }
}