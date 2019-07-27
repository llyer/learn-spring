package me.liluyang.jpa.dto;

import java.util.Set;

public interface UserView2 {

    String getId();

    String getUsername();

    AddressView getAddress();

    Set<RoleView> getRoles();

}
