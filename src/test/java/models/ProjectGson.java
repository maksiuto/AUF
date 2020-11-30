package models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class ProjectGson {
    int id;
    String name;
    String announcement;
    String job;
    boolean show_announcement;
    boolean is_completed;
    String completed_on;
    int suite_mode;
    @ToString.Exclude
    String url;
}
