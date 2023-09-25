package com.JEE_Projet.projet.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.json.simple.JSONObject;

public class JsonResponse {
    private String message;
    private Object data;

    public JsonResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public JsonResponse() {
        this.message = "";
        this.data = null;
    }

    @ResponseStatus(code= HttpStatus.OK, reason = "Success")
    public static String success(Object data) {
        JsonResponse response = new JsonResponse("Success", data);

        JSONObject obj = new JSONObject();
        obj.put("message", response.message);
        obj.put("data", response.data);
        return obj.toJSONString();
    }

    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error")
    public static String error(Object data) {
        JsonResponse response = new JsonResponse("Error", data);

        JSONObject obj = new JSONObject();
        obj.put("message", response.message);
        obj.put("data", response.data);
        return obj.toJSONString();
    }

    @ResponseStatus(code= HttpStatus.CREATED, reason = "Create")
    public static String created(Object data) {
        JsonResponse response = new JsonResponse("Create", data);

        JSONObject obj = new JSONObject();
        obj.put("message", response.message);
        obj.put("data", response.data);
        return obj.toJSONString();
    }

    @ResponseStatus(code= HttpStatus.NO_CONTENT, reason = "Delete")
    public static String deleted() {
        JsonResponse response = new JsonResponse("Delete", null);

        JSONObject obj = new JSONObject();
        obj.put("message", response.message);
        obj.put("data", response.data);
        return obj.toJSONString();
    }

    @ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Not found")
    public String notFound(Object data) {
        JsonResponse response = new JsonResponse("Not found", data);

        JSONObject obj = new JSONObject();
        obj.put("message", response.message);
        obj.put("data", response.data);
        return obj.toJSONString();
    }
}
