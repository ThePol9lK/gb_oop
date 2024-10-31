package Seminar7.chain;

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