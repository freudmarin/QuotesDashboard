package marin.dulja.quotesdashboard.controllers;

import marin.dulja.quotesdashboard.enums.Order;
import marin.dulja.quotesdashboard.enums.SortBy;
import marin.dulja.quotesdashboard.models.Tag;
import marin.dulja.quotesdashboard.services.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("api/tags")
public class TagsController {

    private final TagService tagsService;

    public TagsController(TagService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping
    public Flux<Tag> listTags(
            @RequestParam(name = "sortBy", required = false, defaultValue = "name") SortBy sortBy,
            @RequestParam(name = "sortOrder", required = false, defaultValue = "asc") Order sortOrder
    ) {
        return tagsService.listTags(sortBy, sortOrder);
    }
}
