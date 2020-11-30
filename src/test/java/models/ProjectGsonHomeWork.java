package models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class ProjectGsonHomeWork {
    int id;
    String name;
    String job;
    @ToString.Exclude
    String url;
}
