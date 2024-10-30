package org.example.events;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ProductEventListener {

    public void onProductEvent(@Observes ProductEvent event) {
        // Handle the event
        System.out.println("Event received: " + event.getMessage());
    }
}
