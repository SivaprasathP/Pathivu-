package com.pathivu.jsonparsingsample;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pathivu.dto.Bus;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class sample1 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<Bus> busList = new ArrayList<>();

        try (FileReader reader = new FileReader("/home/zs-gsch30/IdeaProjects/Pathivu/Pathivu/src/com/pathivu/jsonFiles/Buses.json")) {
            // Parse the entire JSON as a JsonArray since it's a list of buses
            JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);

            // Date formatters
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy, hh:mm:ss a");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Loop through each bus in the array
            for (JsonElement element : jsonArray) {
                // Convert each element to a Bus object
                Bus bus = gson.fromJson(element, Bus.class);

                // Parse and reformat the date
                try {
                    Date date = inputFormat.parse(bus.getDate());  // Assuming Bus class has getDate() method
                    String formattedDate = outputFormat.format(date);
                    bus.setDate(formattedDate);  // Assuming Bus class has setDate() method
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // Add bus to the list
                busList.add(bus);
            }

            // Write the updated list of buses back to a new JSON file
            try (FileWriter writer = new FileWriter("/home/zs-gsch30/IdeaProjects/Pathivu/Pathivu/src/com/pathivu/jsonFiles/BusesUpdated.json")) {
                gson.toJson(busList, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

