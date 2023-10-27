package marin.dulja.quotesdashboard.controllers;

import marin.dulja.quotesdashboard.enums.Order;
import marin.dulja.quotesdashboard.enums.SortBy;
import marin.dulja.quotesdashboard.models.Author;
import marin.dulja.quotesdashboard.models.AuthorPage;
import marin.dulja.quotesdashboard.models.SearchAuthorsResponse;
import marin.dulja.quotesdashboard.services.AuthorService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/authors")
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Mono<AuthorPage> listAuthors(
            @RequestParam(name = "sortBy", required = false, defaultValue = "name") SortBy sortBy,
            @RequestParam(name = "slug", required = false) String slug,
            @RequestParam(name = "order", required = false, defaultValue = "asc") Order order,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "limit", required = false, defaultValue = "20") int limit
    ) {
        return authorService.listAuthors(page, limit, order, sortBy, slug);
    }

    @GetMapping("/search")
    public Mono<SearchAuthorsResponse> searchAuthors(
            @RequestParam String query,
            @RequestParam(required = false, defaultValue = "true") boolean autocomplete,
            @RequestParam(required = false, defaultValue = "2") int matchThreshold,
            @RequestParam(required = false, defaultValue = "20") int limit,
            @RequestParam(required = false, defaultValue = "1") int page) {

        return authorService.searchAuthors(query, autocomplete, matchThreshold, limit, page);
    }

    @GetMapping("/{id}")
    public Mono<Author> getAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/slug/{slug}")
    public Mono<Author> getAuthorBySlug(@PathVariable String slug) {
        return authorService.getAuthorBySlug(slug);
    }
}
