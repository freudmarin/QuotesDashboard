package marin.dulja.quotesdashboard.models;

import lombok.Getter;

import java.util.List;

@Getter
public class SearchAuthorsResponse extends SearchResponse {
    private List<Author> results;
}
