package com.demospringsecurityv1.springsecurity.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @JsonProperty("username")
    private String username;

    @JsonIgnore
    private String password;

    @JsonProperty("roles")
    private List<RoleInfo> roleInfos;
}
