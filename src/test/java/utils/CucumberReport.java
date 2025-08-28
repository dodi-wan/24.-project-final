package utils;

import java.util.List;

public class CucumberReport {
    private String name;
    private List<Element> elements;

    // Tambahkan getters dan setters

    public static class Element {
        private String name;
        private List<Step> steps;

        // Tambahkan getters dan setters
    }

    public static class Step {
        private String name;
        private Result result;

        // Tambahkan getters dan setters
    }

    public static class Result {
        private String status;
        private long duration;

        // Tambahkan getters dan setters
    }
}
