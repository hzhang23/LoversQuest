package com.loversQuest.excelReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;

public class JsonGetter {

    private static final String kanyeAPI = "https://api.kanye.rest/";
    private static final String taylorAPI = "https://api.taylor.rest/";
    private static final String randomFact = "https://uselessfacts.jsph.pl/random.json?language=en";
    private static final String chuckNorrisAPI = "https://api.chucknorris.io/jokes/random";
    private static final String shayShayAPI = "http://burli.pythonanywhere.com/shayshay/random";
    private static final String starWarAPI = "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
    private static final String catFact = "https://cat-fact.herokuapp.com/facts";

    public static String kanyeQuotes() {
        String result = null;
        JsonObject json = readJsonFromUrl(kanyeAPI);
        result = json.get("quote").getAsString();
        return result;
    }

    public static String taylorQuotes() {
        String result = null;
        JsonObject json = readJsonFromUrl(taylorAPI);
        result = json.get("quote").getAsString();
        return result;
    }

    public static String getRandomFact() {
        String result = null;
        JsonObject kanyeJson = readJsonFromUrl(randomFact);
        result = kanyeJson.get("text").getAsString();
        return result;
    }

    public static String chuckNorrisFact() {
        String result = null;
        JsonObject json = readJsonFromUrl(chuckNorrisAPI);
        result = json.get("value").getAsString();
        return result;
    }

    public static String getShayshay() {
        String result = null;
        JsonObject json = readJsonFromUrl(shayShayAPI);
        result = json.get("quote").getAsString();
        return result;
    }

    public static String getStarWarAPI() {
        String result = null;
        JsonObject json = readJsonFromUrl(starWarAPI);
        result = json.get("starWarsQuote").getAsString();
        return result;
    }

    public static String getCatFact() {
        String result = null;
        JsonObject json = readJsonFromUrl(catFact);
        Random rand = new Random();
        int i = rand.nextInt(251);
        JsonArray resultArr = json.get("all").getAsJsonArray();
        result = resultArr.get(i).getAsJsonObject().get("text").getAsString();

        return result;
    }

    public static JsonObject readJsonFromUrl(String url) {
        JsonObject jsonFile = null;

        try {
            InputStream inputAPI = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputAPI, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp = 0;
            while ((cp = reader.read()) > 0) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            jsonFile = new Gson().fromJson(jsonText, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonFile;
    }
}
