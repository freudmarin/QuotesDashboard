package marin.dulja.quotesdashboard.models;

import lombok.Getter;

@Getter
public class Tag {
    String _id;
    String name;
    String slug;
    int quoteCount;
    String dateAdded;
    String dateModified;
}
