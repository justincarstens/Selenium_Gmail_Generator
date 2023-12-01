import java.time.Year;
import java.util.Random;

public class PersonalInfo {

    private int day;
    private String month;
    private int year;
    private String gender;

    public PersonalInfo() {
        generateRandomMonth();
        generateRandomDay();
        generateRandomYear();
        generateRandomGender();
    }

    private void generateRandomMonth() {
        Random random = new Random();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.month = months[random.nextInt(0, months.length)];
    }

    private void generateRandomDay() {
        Random random = new Random();
        switch (this.month) {
            case "February" -> this.day = random.nextInt(0, 28) + 1;
            case "January", "March", "May", "July", "August", "October", "December" -> this.day = random.nextInt(0, 31) + 1;
            case "April", "June", "September", "November" -> this.day = random.nextInt(0, 30) + 1;
            default -> this.day = 1;
        }
    }

    private void generateRandomYear() {
        Random random = new Random();
        Year currentYear = Year.now();
        int sysYear = currentYear.getValue();
        this.year = random.nextInt(1950, sysYear - 18);
    }

    private void generateRandomGender() {
        Random random = new Random();
        int randomGenderGenerator = random.nextInt(0,2);
        switch (randomGenderGenerator) {
            case 0 -> this.gender = "Male";
            case 1 -> this.gender = "Female";
            default -> this.gender = "Prefer not to say";
        }
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }
}
