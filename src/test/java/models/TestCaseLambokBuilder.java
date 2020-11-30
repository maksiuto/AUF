package models;

import lombok.*;

import java.util.List;

@Getter
@Builder
public class TestCaseLambokBuilder {
    @NonNull
    private String title;
    @Builder.Default
    private int estimate = 5;
    @Singular
    private List<String> references;
}
