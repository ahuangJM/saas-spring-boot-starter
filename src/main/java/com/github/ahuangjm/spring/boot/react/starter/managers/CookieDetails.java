package com.github.ahuangjm.spring.boot.react.starter.managers;

public interface CookieDetails {
    String getName();
    default String getComment() {
        return "";
    }
    default String getDomain() {
        return "localhost";
    }
    default int getMaxAge() {
        return 60 * 60 * 24 * 365 * 10;
    }
    default String getPath() {
        return "";
    }
    default boolean getSecure() {
        return true;
    }
    default boolean isHttpOnly() {
        return false;
    }
}
