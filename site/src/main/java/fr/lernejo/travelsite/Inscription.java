package fr.lernejo.travelsite;

public record Inscription(String userEmail, String userName, String userCountry, WeatherExpectation weatherExpectation)
{
    public enum WeatherExpectation{COLDER,WARMER};
}
