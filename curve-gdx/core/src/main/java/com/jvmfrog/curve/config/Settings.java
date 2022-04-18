package com.jvmfrog.curve.config;

import com.badlogic.gdx.files.FileHandle;
import com.jvmfrog.curve.config.backends.Backends;

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
     * Used backend. Default JSON Backend
     */
    private static SaveBackend backend = Backends.JSON_BACKEND;

    /**
     * Changes backend
     */
    public static void useBackend(SaveBackend backend) {
        Settings.backend = backend;
    }

    /**
     * Saves all fields that have the {@linkplain Parameter @Parameter} annotation
     *
     * @param file          settings file
     * @param settingsClass class with parameters
     */

    public static void save(FileHandle file, Class<?> settingsClass) {
        for (Field field : settingsClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Parameter.class)) {
                try {
                    Parameter parameter = field.getAnnotation(Parameter.class);
                    backend.put(getKey(parameter, field), field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        backend.save(file);
    }

    /**
     * Loads settings from file and sets field values
     *
     * @param file          settings file
     * @param settingsClass class with parameters
     */
    public static void load(FileHandle file, Class<?> settingsClass) {
        backend.load(file);
        for (Field field : settingsClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Parameter.class)) {
                try {
                    Parameter parameter = field.getAnnotation(Parameter.class);
                    String key = getKey(parameter, field);
                    if (backend.has(key))
                        field.set(null, backend.get(key));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @return field key
     */
    private static String getKey(Parameter parameter, Field field) {
        return (parameter.value().isEmpty()) ? field.getName() : parameter.value();
    }
}
