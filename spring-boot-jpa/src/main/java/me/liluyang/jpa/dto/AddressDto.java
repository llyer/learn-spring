package me.liluyang.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {

    private String id;

    private String location;

    private String remark;
}
