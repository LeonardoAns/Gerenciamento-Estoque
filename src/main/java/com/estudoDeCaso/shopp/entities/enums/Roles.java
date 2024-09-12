package com.estudoDeCaso.shopp.entities.enums;

import lombok.Getter;

@Getter
public enum Roles {
    MANAGEMENT(1L),
    SALES(2L),
    STOCK(3L);

    private final Long id;

    Roles(Long id) {
        this.id = id;
    }

}
