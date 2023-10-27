package marin.dulja.quotesdashboard.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Quote {
    String _id;
    String content;
    String author;
    String authorSlug;
    int length;
    String dateAdded;
    String dateModified;
}
