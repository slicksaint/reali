package com.reali.services;

import com.reali.entities.House;
import com.reali.repositories.HouseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class ListingService {
    private Logger logger = LoggerFactory.getLogger(ListingService.class);

    final String defaultFilepath = "listing-details.csv";

    @Autowired
    private HouseRepository houseRepository;

    @PostConstruct
    public void postConstructInit(){
        ArrayList<House> listings = parseListingData(defaultFilepath);
        storeListings(listings);
    }

    private ArrayList<House>  parseListingData(String filepath) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filepath);
        } catch (FileNotFoundException e) {
            logger.error("File not found: "+filepath);

        }

        BufferedReader csvReader = new BufferedReader(fileReader);
        String row;
        ArrayList<House> listings = new ArrayList();

        try {
            csvReader.readLine(); // ignore header (first line)

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                House house = convertRawDataToHouse(data);
                listings.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return listings;

    }

    private void storeListings(ArrayList<House> listings) {
        houseRepository.saveAll(listings);
    }

    private House convertRawDataToHouse(String[] data) {
        long id = Long.parseLong(data[0]);
        String street = data[1];
        String status = data[2];
        int price = Integer.parseInt(data[3]);
        int bedrooms = Integer.parseInt(data[4]);
        int bathrooms = Integer.parseInt(data[5]);
        int sq_ft = Integer.parseInt(data[6]);
        double lat = Double.parseDouble(data[7]);
        double lan = Double.parseDouble(data[8]);

        return new House(id, street, status, price, bedrooms, bathrooms, sq_ft, lat, lan);
    }
}
