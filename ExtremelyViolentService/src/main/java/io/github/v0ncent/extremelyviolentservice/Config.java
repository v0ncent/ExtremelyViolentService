package io.github.v0ncent.extremelyviolentservice;

import io.github.cdimascio.dotenv.Dotenv;

public final class Config {
    private static final Dotenv dotenv = Dotenv.load(); //dotenv loads our config

    public static String get(String key){
        return dotenv.get(key);
    }
}
