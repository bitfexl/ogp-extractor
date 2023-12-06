package com.github.bitfexl;

import com.github.bitfexl.ogpextractor.OGPExtractor;
import com.github.bitfexl.ogpextractor.OGPResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final OGPExtractor extractor = new OGPExtractor();

        final OGPResult result = extractor.extract("https://www.youtube.com/watch?v=5BZLz21ZS_Y");

        System.out.println(gson.toJson(result));
    }
}