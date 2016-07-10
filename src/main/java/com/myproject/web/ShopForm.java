package com.myproject.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by nishina on 2016/07/02.
 */
@Data
public class ShopForm {
    @NotNull
    @Size(min = 1, max = 127)
    private String name;
    @Size(min = 1, max = 500)
    private String note;
}
