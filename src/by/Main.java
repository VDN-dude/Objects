package by;

import by.tms.http.HttpApplication;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Application app = new HttpApplication();
        try {
            app.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}