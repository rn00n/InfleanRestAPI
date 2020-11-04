package me.rn00n.demoinfleanrestapi.index;

import me.rn00n.demoinfleanrestapi.events.Event;
import me.rn00n.demoinfleanrestapi.events.EventController;
import me.rn00n.demoinfleanrestapi.events.EventResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class IndexController {

    @GetMapping("/api")
    public EntityModel index() {

        Link link = linkTo(EventController.class).withRel("events");
        var index = new EntityModel(new Link("/"));
        index.add(link);
        return index;
    }
}
