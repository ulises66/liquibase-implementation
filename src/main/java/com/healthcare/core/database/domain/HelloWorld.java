package com.healthcare.core.database.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wichon on 2/15/17.
 */
public class HelloWorld {

    @Getter @Setter private String hello;
    @Getter @Setter private String world;

    public HelloWorld(String hello, String world) {
        this.hello = hello;
        this.world = world;
    }
}
