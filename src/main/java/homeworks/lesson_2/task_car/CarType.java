package homeworks.lesson_2.task_car;

public enum CarType {
    SEDAN("Седан"),
    HATCHBACK("Хэтчбек"),
    CROSSOVER("Кроссовер");

    final String typeName;

    public String getTypeName() {
        return typeName;
    }

    CarType(String typeName) {
        this.typeName = typeName;
    }
}
