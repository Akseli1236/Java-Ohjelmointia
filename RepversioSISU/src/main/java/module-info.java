module fi.tuni.prog3.sisu {
    requires javafx.controls;
    exports fi.tuni.prog3.sisu;
    requires com.google.gson;
    requires json.simple;
    opens fi.tuni.prog3.sisu.course to com.google.gson;
    opens fi.tuni.prog3.sisu.course.fields to com.google.gson;
    opens fi.tuni.prog3.sisu.module to com.google.gson;
    opens fi.tuni.prog3.sisu.module.fields to com.google.gson;
}
