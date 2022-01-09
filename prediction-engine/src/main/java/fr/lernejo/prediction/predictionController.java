package fr.lernejo.prediction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class predictionController {
    @GetMapping("api/temperature")
    public Object getTemperature(@RequestParam String country) {
        TemperaturePays temperaturePays = new TemperaturePays(country, new ArrayList<TemperaturePays.TemperatureJour>());
        try {
            temperaturePays.temperatures().add(new TemperaturePays.TemperatureJour(LocalDate.now().minusDays(1).toString(),
                new TemperatureService().getTemperature(country)));
            temperaturePays.temperatures().add(new TemperaturePays.TemperatureJour(LocalDate.now().minusDays(2).toString(),
                new TemperatureService().getTemperature(country)));
        }
        catch (UnknownCountryException unknownCountryException){
            return ResponseEntity.status(417).body("Pays inconnu");
        }
        return temperaturePays;
    }
}

