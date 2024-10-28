# SOLID Принципы
Принципы SOLID — это пять основных концепций объектно-ориентированного программирования, которые помогают создавать устойчивую и масштабируемую архитектуру программного обеспечения. Эти принципы были разработаны Робертом Мартином (Robert C. Martin) для создания гибкой, поддерживаемой и тестируемой системы.

Каждое слово в SOLID расшифровывается как начальная буква одного из принципов:

1. Single Responsibility Principle (Принцип единственной ответственности)
2. Open/Closed Principle (Принцип открытости/закрытости)
3. Liskov Substitution Principle (Принцип подстановки Барбары Лисков)
4. Interface Segregation Principle (Принцип разделения интерфейса)
5. Dependency Inversion Principle (Принцип инверсии зависимостей)

## Single Responsibility Principle (SRP) — Принцип единственной ответственности

##### **Официальное описание:**
У класса должна быть только одна причина для изменения. Это значит, что он выполняет только одну задачу и отвечает за одну часть функциональности системы.

##### **Простое объяснение:** 

Один класс = одна обязанность. Например, класс, который управляет пользователями, не должен содержать логику, отвечающую за генерацию отчетов.

##### Пример:
``` java
// Плохой пример — класс выполняет несколько обязанностей
class UserManager {
public void addUser(User user) {
// добавление пользователя
}
public void printUserReport(User user) {
// вывод отчета пользователя
}
}

// Хороший пример — отделяем отчет в отдельный класс
class UserManager {
public void addUser(User user) {
// добавление пользователя
}
}

class UserReport {
public void printUserReport(User user) {
// вывод отчета пользователя
}
}
```

## Open/Closed Principle (OCP) — Принцип открытости/закрытости

##### **Официальное описание:**

Классы должны быть открыты для расширения, но закрыты для модификации. Это значит, что для добавления нового поведения мы не изменяем существующий код, а расширяем его.

##### **Простое объяснение:** 
Можно добавлять новый функционал без изменения существующего кода. Например, можно добавить новые виды фигур, не меняя основной класс расчета площади.

##### Пример:
``` java
// Плохой пример — метод изменяется каждый раз при добавлении новой фигуры
class AreaCalculator {
    public double calculate(Object shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.length * rectangle.width;
        }
        return 0;
    }
}

// Хороший пример — добавляем интерфейс для каждого типа фигуры
interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double length, width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double calculateArea() {
        return length * width;
    }
}

class AreaCalculator {
    public double calculate(Shape shape) {
        return shape.calculateArea();
    }
}
```

## Liskov Substitution Principle (LSP) — Принцип подстановки Барбары Лисков

##### Официальное описание: 
Объекты подклассов должны заменять объекты базовых классов, не нарушая их функциональность. Это значит, что подклассы могут использоваться вместо базовых классов без изменений в поведении программы.

##### Простое объяснение: 
Подкласс должен полностью соответствовать интерфейсу или поведению суперкласса. Если функция ожидает прямоугольник, она не должна ломаться, если передать ей квадрат.

##### Пример:
``` java
// Плохой пример — Квадрат нарушает контракт суперкласса
class Rectangle {
    protected int width, height;
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }
    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}

// Хороший пример — не наследуем квадрат от прямоугольника, а реализуем отдельно
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width, height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;
    public Square(int side) {
        this.side = side;
    }
    public int getArea() {
        return side * side;
    }
}

```

## Interface Segregation Principle (ISP) — Принцип разделения интерфейса
##### Официальное описание: 
Клиенты не должны зависеть от интерфейсов, которые они не используют. Другими словами, лучше создавать несколько узкоспециализированных интерфейсов, чем один универсальный.

##### Простое объяснение: 
Интерфейсы должны быть "узкими" и выполнять только то, что действительно необходимо. Это позволяет не перегружать классы ненужными методами.

##### Пример:
``` java
// Плохой пример — "жирный" интерфейс
interface Worker {
    void work();
    void eat();
}

// Хороший пример — узкие интерфейсы для конкретных обязанностей
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Employee implements Workable, Eatable {
    public void work() {
        // работа
    }
    public void eat() {
        // обед
    }
}

class Robot implements Workable {
    public void work() {
        // работа
    }
}

```

## Dependency Inversion Principle (DIP) — Принцип инверсии зависимостей
##### Официальное описание: 
Высокоуровневые модули не должны зависеть от низкоуровневых. Оба должны зависеть от абстракций. Это способствует созданию более гибкой архитектуры.

##### Простое объяснение: 
Программу легче изменить и протестировать, если она зависит не от конкретных классов, а от абстракций или интерфейсов.

##### Пример:
``` java
// Плохой пример — высокоуровневый класс зависит от низкоуровневого
class LightBulb {
    public void turnOn() {
        System.out.println("Лампочка включена");
    }
    public void turnOff() {
        System.out.println("Лампочка выключена");
    }
}

class Switch {
    private LightBulb bulb;
    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }
    public void operate(String command) {
        if ("ON".equals(command)) {
            bulb.turnOn();
        } else if ("OFF".equals(command)) {
            bulb.turnOff();
        }
    }
}

// Хороший пример — добавляем интерфейс и используем инверсию зависимости
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("Лампочка включена");
    }
    public void turnOff() {
        System.out.println("Лампочка выключена");
    }
}

class Switch {
    private Switchable device;
    public Switch(Switchable device) {
        this.device = device;
    }
    public void operate(String command) {
        if ("ON".equals(command)) {
            device.turnOn();
        } else if ("OFF".equals(command)) {
            device.turnOff();
        }
    }
}

```

## Итог: 
Применение **SOLID** принципов помогает писать более структурированный, поддерживаемый и расширяемый код.
Эти принципы направлены на уменьшение зависимости и повышение гибкости программного кода.