package model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserData {
    private String firstName;
    private String email;
    private String password;
}
