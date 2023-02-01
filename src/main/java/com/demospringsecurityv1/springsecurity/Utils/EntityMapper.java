package com.demospringsecurityv1.springsecurity.Utils;

import com.demospringsecurityv1.springsecurity.models.Role;
import com.demospringsecurityv1.springsecurity.models.User;
import com.demospringsecurityv1.springsecurity.requests.RoleInfo;
import com.demospringsecurityv1.springsecurity.requests.UserInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
public class EntityMapper {

    public List<UserInfo> toUserInfos(List<User> users) {
        if (users == null || users.isEmpty()) {
            return Collections.emptyList();
        }
        List<UserInfo> userInfos = new ArrayList<>();
        for (User user : users) {
            UserInfo userInfo = UserInfo.builder().build();
            BeanUtils.copyProperties(user, userInfo);
            userInfo.setRoleInfos(toRoleInfos(user.getRoles()));
            //log.info("user --> "+userInfo.getPassword());
            userInfos.add(userInfo);
        }
        return userInfos;
    }

    private List<RoleInfo> toRoleInfos(Set<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return Collections.emptyList();
        }
        List<RoleInfo> roleInfos = new ArrayList<>();
        for (Role role : roles) {
            RoleInfo roleInfo = RoleInfo.builder().build();
            BeanUtils.copyProperties(role, roleInfo);
            roleInfos.add(roleInfo);
        }
        return roleInfos;
    }
}
