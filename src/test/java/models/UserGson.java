package models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class UserGson {
    String name;
    int id;
    String email;
    boolean is_active;
    int role_id;
    String role;
}
