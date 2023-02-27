package by.tms.storage;

import by.tms.entity.Operation;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GsonStorage implements OperationStorage{
    private final Gson gson = new Gson();
    public void save(Operation operation) throws IOException {
        String s = gson.toJson(operation);
        FileWriter fileWriter = new FileWriter("history.json");
        fileWriter.write(s);
        fileWriter.close();
    }

    public List findAll() throws IOException {
        FileReader fileReader = new FileReader("history.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String gsonString = bufferedReader.readLine();
        String out;
        while ((out = bufferedReader.readLine()) != null){
            gsonString = gsonString.concat(out);
        }
        return gson.fromJson(gsonString, List.class);
    }
}
