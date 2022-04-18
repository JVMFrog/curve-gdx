package com.jvmfrog.curvelibexample;

import com.jvmfrog.curve.config.Parameter;
import org.json.JSONObject;

public class SettingsExample {
    @Parameter("int")
    public static int testInteger = 123;

    @Parameter("string")
    public static String testString = "some_string";

    @Parameter("boolean")
    public static boolean testBoolean = false;

    @Parameter("json")
    public static JSONObject testJSON = new JSONObject();

    @Parameter
    public static int withoutKey = 754339;
}
