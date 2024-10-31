package Seminar7.chain;

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
