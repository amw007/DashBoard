package service;

import controller.StdData;
import controller.TeaData;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import task.StdDataTask;
import task.TeaDataTask;

public class TeaDataService extends Service<ObservableList<TeaData>> {
    @Override
    protected Task createTask() {
        return new TeaDataTask();
    }
}
