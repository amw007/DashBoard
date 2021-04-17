package task;

import DB.DBConnection;
import controller.StdData;
import controller.StdTableController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StdDataTask extends Task<ObservableList<StdData>> {
    @Override
    protected ObservableList<StdData> call() throws Exception {
        ObservableList<StdData> stdData = FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from ecedata");
            resultSet.last();
            int i = resultSet.getRow();
            resultSet.beforeFirst();
            for (int j = 1; j <= i; j++) {
                resultSet.next();
                stdData.add(new StdData(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
                updateProgress(j,i);
                Thread.sleep(10000/i);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        StdTableController.stdData = stdData;
        return stdData;
    }
}
