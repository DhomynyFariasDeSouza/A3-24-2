package com.a3.api.DTO;

import com.a3.api.Security.rolesName;

public record CreateUserDto (
    String name,
    String email,
    String password,
    rolesName role
) {

}
