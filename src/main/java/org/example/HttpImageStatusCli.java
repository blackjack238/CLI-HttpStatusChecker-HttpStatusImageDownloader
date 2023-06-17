package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {

    public void askStatus() {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter HTTP status code: ");
            String input = reader.readLine();
            int code;
            try {
                code = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                return;
            }

            try {
                downloader.downloadStatusImage(code);
                System.out.println("Image downloaded successfully.");
            } catch (IOException e) {
                System.out.println("There is no image for HTTP status " + code);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}