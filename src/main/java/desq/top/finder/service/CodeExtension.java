package desq.top.finder.service;

import java.util.Arrays;

public enum CodeExtension {

    TIF("tif"),
    AVI("avi"),
    MOV("mov");

    private String title;

    CodeExtension(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static boolean has(String needle) {
        return Arrays.stream(CodeExtension.values())
                .anyMatch(el -> el.getTitle().equals(needle));
    }
}
