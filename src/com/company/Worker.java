package com.company;

public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public void start() {
        for (int i = 0; i < 50; i++) {
            if (i == 33) {
                errorCallback.onError("! Error ! Task " + i + " not completed!");
            } else {
                callback.onDone("Task " + i + " is done");
            }

        }
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

}
