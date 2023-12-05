package org.naziks.config;

import org.naziks.model.Building;
import org.naziks.model.Floor;
import org.naziks.model.Room;
import org.naziks.model.Sensor;

import java.util.List;

public class SystemConfigurator {
    private static Building building = new Building();
    private static SystemConfigurator instance = new SystemConfigurator();

    private SystemConfigurator() {}

    public static SystemConfigurator getInstance() {
        return instance;
    }

    public void reset() {
        building = new Building();
    }

    public Building getBuilding() {
        return building;
    }

    public void configureBuilding(List<Floor> floors) {
        this.reset();

        for (Floor floor : floors) {
            building.addFloor(floor);
        }
    }

    public Floor configureFloor(int floorNumber, List<Room> rooms) {
        Floor floor = new Floor(floorNumber);
        for (Room room : rooms) {
            floor.addRoom(room);
        }
        return floor;
    }

    public Room configureRoom(int roomNumber, double area, int windows, int doors, List<Sensor> sensors) {
        Room room = new Room(area, windows, doors, roomNumber);
        for (Sensor sensor : sensors) {
            room.addSensor(sensor);
        }
        return room;
    }

    // Можливі інші методи для конфігурації датчиків, системи реагування тощо.
}
