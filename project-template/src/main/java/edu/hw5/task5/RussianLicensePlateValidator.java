package edu.hw5.task5;

public class RussianLicensePlateValidator {
    public boolean isValidRussianLicensePlate(String input) {
        String regex = "^([АВЕКМНОРСТУХ])(\\d{3})([АВЕКМНОРСТУХ]{2})(\\d{2,3})$";
        return input.matches(regex);
    }
}
