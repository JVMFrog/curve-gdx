package com.intkgc.curvelibexample;

import com.intkgc.curve.config.Parameter;
import org.json.JSONObject;

public class SettingsExample {
    @Parameter(jsonKey = "int")
    public static int testInteger = 123;

    @Parameter(jsonKey = "string")
    public static String testString = "some_string";

    @Parameter(jsonKey = "boolean")
    public static boolean testBoolean = false;

    @Parameter(jsonKey = "json")
    public static JSONObject testJSON = new JSONObject();
}
