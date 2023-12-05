package org.naziks.simulation;

import org.naziks.config.SystemConfigurator;
import org.naziks.model.Building;

public class Simulator {
    private SystemConfigurator config;

    public Simulator() {
        config = SystemConfigurator.getInstance();
    }

    public void simulateEvent() {
        // Логіка симуляції порушень
    }
}
