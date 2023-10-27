package marin.dulja.quotesdashboard.models;

import lombok.Getter;

import java.util.List;

@Getter
public class SearchQuotesResponse extends SearchResponse {
    private List<Quote> results;
}
