package org.naziks.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private double area;
    private int windows;
    private int doors;
    private List<Sensor> sensors;
    private int roomNumber; // Унікальний номер приміщення

    public Room(double area, int windows, int doors, int roomNumber) {
        this.area = area;
        this.windows = windows;
        this.doors = doors;
        this.roomNumber = roomNumber;
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public List<Sensor> getSensors() {
        return new ArrayList<>(this.sensors);
    }

    public double getArea() {
        return area;
    }

    public int getNumberOfWindows() {
        return windows;
    }

    public int getNumberOfDoors() {
        return doors;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}


