package by.tms.storage;

import by.tms.entity.Operation;
import by.tms.entity.OperationType;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBCOperationStorage implements OperationStorage {
    private final Connection connection;

    public JDBCOperationStorage() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "0314");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Operation operation){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("insert into operation(num1, type, num2, result, time) values (?, ?, ?, ?, ?)");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setString(2, String.valueOf(operation.getType()));
            preparedStatement.setDouble(3, operation.getNum2());
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(operation.getTime()));
            preparedStatement.execute();
        } catch (SQLException e){
            throw new RuntimeException();
        }

    }

    @Override
    public List<Operation> findAll(){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from operation");
            List<Operation> operationList = new ArrayList<>();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                double num1 = resultSet.getDouble(2);
                String type = resultSet.getString(3);
                double num2 = resultSet.getDouble(4);
                double result = resultSet.getDouble(5);
                LocalDateTime time = resultSet.getTimestamp(6).toLocalDateTime();
                Operation operation = new Operation(id, num1, OperationType.valueOf(type), num2, result, time);
                operationList.add(operation);
            }
            Collections.sort(operationList);
            return operationList;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
