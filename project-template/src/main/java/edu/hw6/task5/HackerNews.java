package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {

    private static final String TOP_STORIES_ENDPOINT = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String ITEM_ENDPOINT_TEMPLATE = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private static final Pattern NEWS_TITLE_PATTERN = Pattern.compile("\"title\"\\s*:\\s*\"([^\"]+)\"");

    public static long[] hackerNewsTopStories() {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(TOP_STORIES_ENDPOINT);
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            String[] ids = body.replaceAll("[\\[\\]\\s]", "").split(",");
            long[] result = new long[ids.length];
            for (int i = 0; i < ids.length; i++) {
                result[i] = Long.parseLong(ids[i]);
            }
            return result;
        } catch (IOException | InterruptedException ex) {
            return new long[0];
        }
    }

    public static String news(long id) {
        String endpoint = String.format(ITEM_ENDPOINT_TEMPLATE, id);
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(endpoint);
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            Matcher matcher = NEWS_TITLE_PATTERN.matcher(body);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return "";
            }
        } catch (IOException | InterruptedException ex) {
            return "";
        }
    }
}
