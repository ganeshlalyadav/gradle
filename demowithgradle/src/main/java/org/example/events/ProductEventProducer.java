package org.example.events;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.example.events.ProductEvent;

@RequestScoped
@Path("/events")
public class ProductEventProducer {

    @Inject
    private Event<ProductEvent> productEvent;

    @POST
    public Response triggerEvent() {
        // Create a ProductEvent and fire it
        ProductEvent event = new ProductEvent("A new product event has been fired!");
        productEvent.fire(event);

        return Response.ok("Event fired successfully").build();
    }
}
