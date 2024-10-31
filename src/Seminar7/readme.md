# Singleton (Синглтон)

### Описание:
Паттерн Singleton гарантирует, что у класса есть только один экземпляр, 
и предоставляет глобальную точку доступа к этому экземпляру. 
Это полезно в ситуациях, когда нужен единый объект, 
например, для работы с базой данных, логирования, настроек конфигурации и т.д.

### Где используется:
* Логгирование
* Работа с конфигурацией
* Подключение к базе данных

```java
public class Singleton {
    // Единственный экземпляр класса
    private static Singleton instance;

    // Приватный конструктор
    private Singleton() {}

    // Глобальная точка доступа к экземпляру
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton instance is working!");
    }
}

// Использование
public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
```

# Builder (Строитель)

### Описание:
Паттерн Builder используется для создания сложных объектов пошагово. 
В отличие от конструктора с множеством параметров, Builder позволяет задавать параметры постепенно, 
избегая длинных цепочек вызовов.

### Где используется:
* Конфигурирование объектов с большим числом параметров (например, создание объектов с множеством полей)
* Создание объектов с параметрами по умолчанию и обязательными параметрами

```java
public class Car {
    // Параметры автомобиля
    private String make;
    private String model;
    private int year;

    private Car(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
    }

    // Класс Builder
    public static class Builder {
        private String make;
        private String model;
        private int year;

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" + "make='" + make + '\'' + ", model='" + model + '\'' + ", year=" + year + '}';
    }
}

// Использование
public class Main {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .setMake("Toyota")
                .setModel("Camry")
                .setYear(2022)
                .build();
        System.out.println(car);
    }
}
```

# Decorator (Декоратор)

### Описание:

Паттерн Decorator позволяет добавлять новую функциональность объектам динамически. 
Он используется для того, чтобы избежать создания подклассов для добавления функциональности, 
а также предоставляет гибкость в модификации поведения объекта в ходе выполнения.

### Где используется:
* Расширение функциональности классов без создания подклассов
* Когда нужно добавить несколько различных функциональностей к одному и тому же объекту

```java
// Интерфейс компонента
public interface Coffee {
    String getDescription();
    double getCost();
}

// Основной класс, реализующий интерфейс
public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Декоратор базового класса
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

// Конкретные декораторы
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}

// Использование
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());
    }
}
```

# Chain of Responsibility (Цепочка обязанностей)

### Описание:

Цепочка обязанностей позволяет передавать запрос по цепочке обработчиков, 
где каждый обработчик может либо обработать запрос, либо передать его дальше по цепочке. 
Это обеспечивает гибкость в обработке запросов и распределение обязанностей между различными объектами.

### Где используется:
* Логгирование на разных уровнях (инфо, предупреждение, ошибка)
* Обработка запросов разного типа
* Упрощение процесса добавления новых обработчиков

```java
// Интерфейс обработчика
public abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract void handleRequest(String request);
}

// Конкретные обработчики
public class InfoHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("INFO")) {
            System.out.println("InfoHandler: Handling INFO request.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

public class WarningHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("WARNING")) {
            System.out.println("WarningHandler: Handling WARNING request.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

public class ErrorHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("ERROR")) {
            System.out.println("ErrorHandler: Handling ERROR request.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

// Использование
public class Main {
    public static void main(String[] args) {
        Handler infoHandler = new InfoHandler();
        Handler warningHandler = new WarningHandler();
        Handler errorHandler = new ErrorHandler();

        infoHandler.setNext(warningHandler).setNext(errorHandler);

        infoHandler.handleRequest("INFO");
        infoHandler.handleRequest("WARNING");
        infoHandler.handleRequest("ERROR");
        infoHandler.handleRequest("UNKNOWN");
    }
}
```