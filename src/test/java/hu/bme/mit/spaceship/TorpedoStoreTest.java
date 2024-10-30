package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {
    TorpedoStore store;
    @BeforeEach
    void create_TorpedoStore() {
        store = new TorpedoStore(1);
    }

    @Test
    void torpedo_Count() {
        assertEquals(1,store.getTorpedoCount());
    }

    @Test
    void fire_Success() {
        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void correct_Torpedo_Count_After_Firing() {
        store.fire(1);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void fire_Fail_Firing_Nothing() {
        assertThrows(IllegalArgumentException.class,() -> store.fire(0));
    }

    @Test
    void fire_Fail_Firing_Not_Enough_Torpedos() {
        assertThrows(IllegalArgumentException.class,() -> store.fire(2));
    }
}
