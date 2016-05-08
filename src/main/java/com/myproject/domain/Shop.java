package com.myproject.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
/**
 * Created by nishina on 2016/05/07.
 */
@Data
@AllArgsConstructor
public class Shop {
    private Integer id;
    private String name;
    private String note;
}
