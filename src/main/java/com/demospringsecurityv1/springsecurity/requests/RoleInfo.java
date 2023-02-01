package com.demospringsecurityv1.springsecurity.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfo {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String roleName;
}
