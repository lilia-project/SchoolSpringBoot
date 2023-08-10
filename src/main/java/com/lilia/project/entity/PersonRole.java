package com.lilia.project.entity;

public enum PersonRole {
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private final String field;

    PersonRole(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
