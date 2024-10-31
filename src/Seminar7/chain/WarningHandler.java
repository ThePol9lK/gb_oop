package Seminar7.chain;

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