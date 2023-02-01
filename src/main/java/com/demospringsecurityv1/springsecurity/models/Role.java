package com.demospringsecurityv1.springsecurity.models;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "test_spring_security_v1", name = "role")
public class Role {
    @Id
    private Integer id;

    @Column(name = "role_name")
    private String roleName;
}
