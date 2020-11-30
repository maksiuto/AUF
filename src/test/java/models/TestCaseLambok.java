package models;

import lombok.*;


@Getter
@Setter
public class TestCaseLambok {
    //1. Описание private переменных которые нам будут нужны для этой сущности
    private String title;
    private int estimate;
    private String reference;
}
