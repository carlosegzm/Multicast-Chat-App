package util;

import com.google.gson.Gson;
import model.Message;

public class JSONUtil {

    private static final Gson gson = new Gson();

    public static String toJSON(Message msg) {
        return gson.toJson(msg);
    }

    public static Message fromJSON(String json) {
        return gson.fromJson(json, Message.class);
    }
}
