package marin.dulja.quotesdashboard.services;

import marin.dulja.quotesdashboard.enums.Order;
import marin.dulja.quotesdashboard.enums.SortBy;
import marin.dulja.quotesdashboard.models.Tag;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Service
public class TagService {

    private final WebClient webClient;

    public TagService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Flux<Tag> listTags(SortBy sortBy, Order sortOrder) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/tags")
                        .queryParamIfPresent("sortBy", Optional.ofNullable(sortBy))
                        .queryParam("sortOrder", Optional.ofNullable(sortOrder))
                        .build())
                .retrieve()
                .bodyToFlux(Tag.class);
    }
}
