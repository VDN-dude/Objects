//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class FileOperationStorage implements OperationStorage{
//
//    @Override
//    public void save(Operation operation) throws IOException {
//        String result = String.format("%s,%s,%s,%s",operation.getNum1(), operation.getType(), operation.getNum2(), operation.getResult());
//        FileOutputStream fileOutputStream = new FileOutputStream("history.csv", true);
//        fileOutputStream.write(result.getBytes());
//        fileOutputStream.write(10);
//        fileOutputStream.close();
//
//    }
//
//    @Override
//    public Operation[] findAll() {
//
//
//    }
//}
