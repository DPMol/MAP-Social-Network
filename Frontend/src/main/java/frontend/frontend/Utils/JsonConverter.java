package frontend.frontend.Utils;

import com.google.gson.Gson;

public class JsonConverter {
    private static JsonConverter INSTANCE;

    public static String ToJson(Object obj){
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static <T> T FromJson(String json, Class<T> classOfT){
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }
}
