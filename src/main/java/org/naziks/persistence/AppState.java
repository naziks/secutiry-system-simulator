package org.naziks.persistence;
import org.naziks.config.SystemConfigurator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.naziks.model.Building;

import java.io.*;
import java.util.Scanner;

// Assuming 'building' is an instance of the Building class

public class AppState {
    private SystemConfigurator config;
    public AppState() {
        this.config = SystemConfigurator.getInstance();
    }

    private void writeFile(String filename, String content) throws IOException{
        FileWriter myWriter = new FileWriter(filename);
        myWriter.write(content);
        myWriter.close();
    }

    private String readFile(String filename) throws IOException {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        StringBuilder content = new StringBuilder();

        while (myReader.hasNextLine()) {
            content.append(myReader.nextLine());
        }
        myReader.close();

        return content.toString();
    }

    public void loadState(String filename) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = readFile(filename);
            Building building = mapper.readValue(json, Building.class);
            config.configureBuilding(building.getAllFloors());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveState(String filename) throws RuntimeException {
        ObjectMapper mapper = new ObjectMapper();

        try {
            writeFile(filename, mapper.writeValueAsString(config.getBuilding()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
