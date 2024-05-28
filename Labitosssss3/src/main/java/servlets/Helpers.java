package servlets;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import users.user1;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public static  JsonElement bodyParse(HttpServletRequest request){

        JsonElement jsonElement = null;
        try{
            jsonElement = JsonParser.parseReader(request.getReader());

        } catch (JsonIOException| JsonSyntaxException| IOException e){
            e.printStackTrace();
        }
        return jsonElement;
    }
    public static user1 userParse(HttpServletRequest request){
        user1 user1 = new user1();
        JsonElement jsonElement = bodyParse(request);
        user1.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        user1.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        user1.setAge(jsonElement.getAsJsonObject().get("age").getAsInt());
        return user1;
    }
    public static int getNextId (List<user1> list){
        int maxId=0;
        Iterator<user1> iterator = list.iterator();
        while (iterator.hasNext()){
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId = currentId;
        }
        return maxId+1;
    }
    public static int getIndexByUserId(int id, List<user1> list){
        int listId=id;
        Iterator<user1> iterator = list.iterator();
        while (iterator.hasNext()){
            user1 temp = iterator.next();
            if(temp.getId()==listId){
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}
