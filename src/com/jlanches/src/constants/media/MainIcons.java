/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.constants.media;

import com.jlanches.src.constants.MediaExtensions;
import com.jlanches.src.constants.Paths;

/**
 *
 * @author arthur
 */
public enum MainIcons {
    LANCHEIRA_PRINCIPAL("lunch-bag-coin", MediaExtensions.PNG),
    LANCHEIRA_PADLOCK("lunch-bag-lock", MediaExtensions.PNG),
    LANCHERIA_SEARCH("lunch-bag-search", MediaExtensions.PNG),
    CHOCOLATE("chocolate", MediaExtensions.PNG),
    HAMBURGER_CALENDAR("hamburger-calendar", MediaExtensions.PNG),
    HAMBURGER_CONFIGURE("hamburger-configure", MediaExtensions.PNG),
    HAMBURGER_LIKE("hamburger-like", MediaExtensions.PNG),
    HAMBURGER_SEARCH("hamburger-search", MediaExtensions.PNG),
    HAMBURGER_SHOW("hamburger-show", MediaExtensions.PNG),
    HAMBURGER_STAR("hamburger-star", MediaExtensions.PNG),
    HAMBURGER("hamburger", MediaExtensions.PNG),
    CROISSANT("croissant", MediaExtensions.PNG),
    SALADA("salad", MediaExtensions.PNG),
    ESPETINHO("skewer", MediaExtensions.PNG);

    private String path;
    private MediaExtensions extension;

    private MainIcons(String path, MediaExtensions extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return this.path;
    }

    public String getPath() {
        return this.path;
    }

    public String getFullPath() {
        return Paths.MAIN_ICONS + this.path + this.extension;
    }
}
