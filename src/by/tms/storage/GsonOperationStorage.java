//package by.tms.storage;
//
//import by.tms.entity.Operation;
//import com.google.gson.Gson;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//public class GsonOperationStorage implements OperationStorage{
//    private final Gson gson = new Gson();
//    public void save(Operation operation) throws IOException {
//        System.out.println(operation);
//        String result = gson.toJson(operation);
//        System.out.println(operation);
//        FileWriter fileWriter = new FileWriter("history.json");
//        fileWriter.write(result);
//        fileWriter.close();
//    }
//
//    public List<Operation> findAll() throws IOException {
//        FileReader fileReader = new FileReader("history.json");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String gsonString = bufferedReader.readLine();
//        String out;
//        while ((out = bufferedReader.readLine()) != null){
//            gsonString = gsonString.concat(out);
//        }
//        System.out.println(gsonString);
//        List list = gson.fromJson(gsonString, List.class);
//        System.out.println(list);
//        return list;
//    }
//}
