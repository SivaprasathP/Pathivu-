package com.pathivu.jsonparsingsample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pathivu.dto.Bus;
import com.pathivu.dto.BusDriver;
import com.pathivu.dto.BusType;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class sample {
    public static void main(String[] args){
        Gson gson = new Gson();
        List<Bus> busList=null;

        try (FileReader reader = new FileReader("/home/zs-gsch30/IdeaProjects/Pathivu/Pathivu/src/com/pathivu/jsonFiles/Buses.json")) {
            // Define the type for List<User>

            StringBuilder sb = new StringBuilder();
            int c = reader.read();
            while (reader.ready()) {
                sb.append((char) c);
                c = reader.read();
            }
            sb.append((char) c);
            System.out.println(sb);
            /*Type mapType = new TypeToken<Map<String, List<Bus>>>() {}.getType();

            // Deserialize JSON into a Map
            Map<String, List<Bus>> busesMap = gson.fromJson(reader, mapType);

            // Extract the list of buses from the map
            buses = busesMap.get("buses");*/

            // Define the type for List<User>

            // Deserialize JSON directly into a list of users
//            busList = new ArrayList<>();
            //JsonArray ja = gson.fromJson(sb.toString(), JsonArray.class);
//            JsonArray ja = jo.getAsJsonArray("buses");/*
//
            /*JsonObject jo=gson.fromJson(sb.toString(),JsonArray.class);
           JsonArray ja=jo.getAsJsonArray("buses")
            for (int i = 0; i < ja.size(); i++) {
                busList.add(gson.fromJson(ja.get(i), Bus.class));
            }
            System.out.println(busList);*/

            busList = new ArrayList<>();
            JsonObject jo = gson.fromJson(sb.toString(), JsonObject.class);
            JsonArray ja = jo.getAsJsonArray("buses");
            for (int i = 0; i < ja.size(); i++) {
                busList.add(gson.fromJson(ja.get(i), Bus.class));
            }
            System.out.println(busList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Bus b=new Bus("B9","Badri", BusType.SLEEPER,new BusDriver("Karikada Bhai","D7",30),"13:00","22:00","Chennai","Coimbatore",10,"20-03-2024");
        busList.add(b);
        try(FileWriter fw=new FileWriter("/home/zs-gsch30/IdeaProjects/Pathivu/Pathivu/src/com/pathivu/jsonFiles/Buses.json")){
            BufferedWriter bw=new BufferedWriter(fw);
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gsons = gb.create();
            /*Map<Object, Object> map = new HashMap<>();
            String jsonString= gsons.toJson(busList);
            map.put("buses", jsonString);


            fw.write(gson.toJson(map));*/

            String jsonString = gsons.toJson(busList);
            bw.write(jsonString);
            System.out.println("file written");
            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print users

    }
}
