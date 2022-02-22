package it.rscaramozza.tools.loccounter.filetypes;

public enum FileType {
    JAVA("java"),
    XML("xml");

    private final String description;

    FileType(String description) {
        this.description = description;
    }


}
