package homeworks.lesson_2.task_car;

public class Car {
    String model;
    CarType type;

    public Car(String model, CarType type) {
        this.model = model;
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public CarType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type=" + type.getTypeName() +
                '}';
    }
}
