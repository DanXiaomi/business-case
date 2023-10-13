package com.business.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    TELEFONIA("TELEFONIA", "Telefonía"),
    LINEA_BLANCA("LINEA_BLANCA", "Línea blanca"),
    HERRAMIENTAS("HERRAMIENTAS", "Herramientas");

    private final String code;
    private final String name;
}
