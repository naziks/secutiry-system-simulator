package org.naziks.model;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors;

    public Building() {
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public Floor getFloor(int floorNumber) {
        return floors.stream().filter(f -> f.getFloorNumber() == floorNumber).findFirst().orElse(null);
    }

    public List<Floor> getAllFloors() {
        return new ArrayList<>(this.floors);
    }

    // Метод для отримання кількості поверхів
    public int getNumberOfFloors() {
        return this.floors.size();
    }
}
