package task;

import DB.DBConnection;
import controller.TeaData;
import controller.StdTableController;
import controller.TeaTableController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeaDataTask extends Task<ObservableList<TeaData>> {
    @Override
    protected ObservableList<TeaData> call() throws Exception {
        ObservableList<TeaData> teaData = FXCollections.observableArrayList();
        try {
            Connection connection= DBConnection.getConnection();
                ResultSet resultSet = connection.createStatement().executeQuery("select id,user_name,emailid,staffPost,co_ordinator_year,co_ordinator_sec from enduser");
            resultSet.last();
            int i = resultSet.getRow();
            resultSet.beforeFirst();
            for (int j = 1; j <= i; j++) {
                resultSet.next();
                teaData.add(new TeaData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
                updateProgress(j,i);
                Thread.sleep(10000/i);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        TeaTableController.teaData = teaData;
        return teaData;
    }
}
