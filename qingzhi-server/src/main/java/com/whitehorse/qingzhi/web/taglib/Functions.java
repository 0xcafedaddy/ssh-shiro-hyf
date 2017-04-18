package com.whitehorse.qingzhi.web.taglib;

import org.springframework.util.CollectionUtils;

import com.whitehorse.qingzhi.entity.App;
import com.whitehorse.qingzhi.service.AppService;
import com.whitehorse.qingzhi.service.ManagerService;
import com.whitehorse.qingzhi.shiro.spring.SpringUtils;

import java.util.Collection;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
public class Functions {

    public static boolean in(Iterable iterable, Object element) {
        if(iterable == null) {
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(), element);
    }

    /*public static String username(Long userId) {
        User user = getUserService().findOne(userId);
        if(user == null) {
            return "";
        }
        return user.getUsername();
    }*/
    public static String appName(Long appId) {
        App app = getAppService().findOne(appId);
        if(app == null) {
            return "";
        }
        return app.getName();
    }

    /*public static String roleName(Long roleId) {
        Role role = getRoleService().findOne(roleId);
        if(role == null) {
            return "";
        }
        return role.getDescription();
    }*/

    /*public static String roleNames(Collection<Long> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            Role role = getRoleService().findOne(roleId);
            if(role == null) {
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }*/
    /*public static String resourceName(Long resourceId) {
        Resource resource = getResourceService().findOne(resourceId);
        if(resource == null) {
            return "";
        }
        return resource.getName();
    }*/
    /*public static String resourceNames(Collection<Long> resourceIds) {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIds) {
            Resource resource = getResourceService().findOne(resourceId);
            if(resource == null) {
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }*/

    /*private static RoleService roleService;
    private static ResourceService resourceService;*/
    private static ManagerService userService;
    private static AppService appService;

    public static ManagerService getUserService() {
        if(userService == null) {
            userService = SpringUtils.getBean(ManagerService.class);
        }
        return userService;
    }

    public static AppService getAppService() {
        if(appService == null) {
            appService = SpringUtils.getBean(AppService.class);
        }
        return appService;
    }


    /*public static RoleService getRoleService() {
        if(roleService == null) {
            roleService = SpringUtils.getBean(RoleService.class);
        }
        return roleService;
    }*/

    /*public static ResourceService getResourceService() {
        if(resourceService == null) {
            resourceService = SpringUtils.getBean(ResourceService.class);
        }
        return resourceService;
    }*/
}

