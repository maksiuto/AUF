package models;

import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectLambokBuilder {
    @NotNull
    private String name;
    private String announcement;
    private boolean isshowAnnouncement;
    private int typeOfProject;
    private boolean isCompleted;
}
