package ru.cft.shift.repetito.params;

import java.util.List;

public class UserParamsRequest {
    private String faculty;
    private String course = null;
    private List<String> subject = null;
    private String degree = null;
    private boolean isTeacher = false;
    private int limit = 10;
    private int offset = 0;
}
