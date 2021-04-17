package service;

import controller.StdData;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import task.StdDataTask;

public class StdDataService extends Service<ObservableList<StdData>> {
    @Override
    protected Task createTask() {
        return new StdDataTask();
    }
}
