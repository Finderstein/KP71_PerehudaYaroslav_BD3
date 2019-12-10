package com.lab3;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model , view);
        model.make_connection();
        controller.mainMenu();
    }
}
