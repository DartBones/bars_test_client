package com.dartbony.bars_test_client;

import com.google.gson.*;

import java.time.LocalDateTime;
import java.util.Optional;

public abstract class GsonUtils {
    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    private GsonUtils() {}

    public static <E> Optional<E> fromJson(String json, Class<E> jsonClass) {
        Optional<E> result;
        try {
            return Optional.ofNullable(GSON.fromJson(json, jsonClass));
        } catch(Exception e) {
            result = Optional.empty();
        }
        return result;
    }

    public static <E> Optional<String> toJson(E object) {
        Optional<String> result;
        try {
            result = Optional.ofNullable(GSON.toJson(object));
        } catch(Exception e) {
            result = Optional.empty();
        }
        return result;
    }
}