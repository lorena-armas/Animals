package org.example.router;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AnimalRouterTCP extends Thread {

    private final AnimalHandler animalHandler;
    private final Socket socket;

    public AnimalRouterTCP(Socket socket) {
        this.animalHandler = new AnimalHandler();
        this.socket = socket;
    }

    public void run() {
        try(
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String operation = inputReader.readLine();

            if(operation.matches("^animals/[A-Za-z]\\d{3}$")) {
                String animalCode = operation.split("/")[1].trim();
                animalHandler.findByCode(animalCode, outputWriter);
            }

            if(operation.equals("/animals")) {
                animalHandler.findAll(outputWriter);
            }

        } catch (Exception exception) {
            throw new IllegalArgumentException("message: " + exception.getMessage());

        } finally {
            try {
                if (socket != null) socket.close();
            } catch (Exception exception) {
                throw new RuntimeException("Error closing TCP connection: " + exception.getMessage());
            }
        }
    }

}
