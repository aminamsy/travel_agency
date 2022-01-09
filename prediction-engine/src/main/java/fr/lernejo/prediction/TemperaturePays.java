package fr.lernejo.prediction;

import java.util.ArrayList;

public record TemperaturePays(String country, ArrayList<TemperatureJour> temperatures) {
    public record TemperatureJour(String date, double temperature) {

    }
}
