package com.intkgc.curve.config;

import com.badlogic.gdx.files.FileHandle;
import org.json.JSONObject;

import java.lang.reflect.Field;

/**
 * {@code Settings} - Class for fast settings for the game
 * <p>
 * Support types : int, String, boolean, JSONObject
 *
 * @author Kirbo
 * @version 1.0
 */
public class Settings {
    /**
     * Saves all fields that have the {@linkplain Parameter @Parameter} annotation
     *
     * @param file          settings file
     * @param settingsClass class with parameters
     */
    public static void save(FileHandle file, Class<?> settingsClass) {
        JSONObject settings = new JSONObject();
        for (Field field : settingsClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Parameter.class)) {
                try {
                    settings.put(field.getAnnotation(Parameter.class).jsonKey(), field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        file.writeString(settings.toString(), false);
    }

    /**
     * Loads settings from file and sets field values
     *
     * @param file          settings file
     * @param settingsClass class with parameters
     */
    public static void load(FileHandle file, Class<?> settingsClass) {
        String result = file.readString();
        JSONObject settings = new JSONObject(result);
        for (Field field : settingsClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Parameter.class)) {
                try {
                    String jsonKey = field.getAnnotation(Parameter.class).jsonKey();
                    if (settings.has(jsonKey))
                        field.set(null, settings.get(jsonKey));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
