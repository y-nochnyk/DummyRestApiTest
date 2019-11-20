import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

class ID {

    static long the_id;

    static long get_id(String response){
        JsonElement element = new JsonParser().parse(response);
        JsonObject object = element.getAsJsonObject();
        JsonPrimitive primitive = object.getAsJsonPrimitive("id");
        return primitive.getAsLong();
    }
}
