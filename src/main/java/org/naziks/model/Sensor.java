package org.naziks.model;

public abstract class Sensor {
    private String type;

    protected Sensor(String type) {
        this.type = type;
    }

    public abstract void trigger();

    public String getType() {
        return type;
    }
}
