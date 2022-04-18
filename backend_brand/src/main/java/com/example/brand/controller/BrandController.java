package com.example.brand.controller;

import com.example.brand.dto.Dates;
import com.example.brand.dto.Post;
import com.example.brand.dto.PostsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BrandController {

    @PostMapping(path = "/posts")
    public List<Post> getPosts(@RequestBody Dates dates) throws IOException, InterruptedException {
        System.out.println(dates.getEndDate());
        System.out.println(dates.getStartDate());
        System.out.println("hello");
        var values = new JSONObject();
        values.put("name", "John Doe");
        values.put("occupation", "gardener");
        values.put("jsonrpc", "2.0");
        values.put("id", 0);
        values.put("method", "socialinsider_api.get_posts");
        JSONObject params = new JSONObject();
        params.put("id", "44596321012");
        params.put("profile_type", "facebook_page");
        JSONObject date = new JSONObject(){{
            put("start", dates.getStartDate());
            put("end", dates.getEndDate());
            put("timezone", "Europe/London");
        }};
        params.put("date", date);
        params.put("from", 0);
        params.put("size", 10);
        values.put("params", params);
        String requestBody = values.toString();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://app.socialinsider.io/api"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer API_KEY_TEST")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        JSONObject responseJSON = new JSONObject(response.body());
        System.out.println(responseJSON.get("resp"));
        PostsResponse posts = new ObjectMapper().readValue(responseJSON.get("resp").toString(), PostsResponse.class);

        System.out.println(posts);

        return posts.getPosts();
    }
}
