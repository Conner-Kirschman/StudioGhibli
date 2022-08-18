package com.ghibliemovies.controller;

import com.ghibliemovies.bean.GhibliMovie;
import com.ghibliemovies.bean.MovieCollection;
import com.ghibliemovies.bean.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {

    @RequestMapping("/index")
    public ModelAndView viewMovies(){

        ModelAndView mav = new ModelAndView("index");

        try {
            URL url = new URL("https://ghibliapi.herokuapp.com/films");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            JSONParser parser = new JSONParser();
            Object object = parser.parse(response.toString());
            JSONArray list = (JSONArray) object;
            List<GhibliMovie> collection = new ArrayList<>();
            MovieCollection movieCollection = new MovieCollection();

            for (Object movie:list
            ) {

                JSONObject jsonObject = (JSONObject) movie;
                GhibliMovie javaObject = new GhibliMovie();

                javaObject.setId((String) jsonObject.get("id"));
                javaObject.setTitle((String) jsonObject.get("title"));
                javaObject.setOriginal_title((String) jsonObject.get("original_title"));
                javaObject.setDescription((String) jsonObject.get("description"));

                collection.add(javaObject);
            }

            movieCollection.setCollection(collection);
            mav.addObject("movies", movieCollection.getCollection());

            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in MovieController: " + e);
        }

        return mav;
    }

    @RequestMapping("/details/{id}")
    public ModelAndView viewMovieDetails(@PathVariable(name = "id") String id){

        ModelAndView mav = new ModelAndView("details");

        try {
            URL url = new URL("https://ghibliapi.herokuapp.com/films/"+id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            JSONParser parser = new JSONParser();
            Object object = parser.parse(response.toString());
            JSONObject jsonObject = (JSONObject) object;
            GhibliMovie javaObject = new GhibliMovie();

            List<Person> people = new ArrayList<>();
            List<String> species = new ArrayList<>();
            List<String> locations = new ArrayList<>();
            List<String> vehicles = new ArrayList<>();

            JSONArray peopleList = (JSONArray) jsonObject.get("people");
            JSONArray speciesList = (JSONArray) jsonObject.get("species");
            JSONArray locationsList = (JSONArray) jsonObject.get("locations");
            JSONArray vehiclesList = (JSONArray) jsonObject.get("vehicles");

            for (Object person:peopleList
            ) {
                try {
                    URL peopleUrl = new URL((String) person);
                    HttpURLConnection peopleConn = (HttpURLConnection) peopleUrl.openConnection();
                    peopleConn.setRequestMethod("GET");
                    peopleConn.setRequestProperty("Accept", "application/json");
                    if (peopleConn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP Error code : "
                                + peopleConn.getResponseCode());
                    }
                    InputStreamReader peopleIn = new InputStreamReader(peopleConn.getInputStream());
                    BufferedReader peopleBr = new BufferedReader(peopleIn);
                    String peopleOutput;
                    StringBuilder peopleResponse = new StringBuilder();
                    while ((peopleOutput = peopleBr.readLine()) != null) {
                        peopleResponse.append(peopleOutput);
                    }
                    JSONParser peopleParser = new JSONParser();
                    Object peopleObject = peopleParser.parse(peopleResponse.toString());
                    JSONObject peopleJsonObject = (JSONObject) peopleObject;
                    Person tempPerson = new Person();

                    List<String> films = new ArrayList<>();
                    JSONArray jsonFilms = (JSONArray) peopleJsonObject.get("films");

                    for (Object film : jsonFilms
                    ) {
                        films.add(film.toString());
                    }

                    tempPerson.setId((String) peopleJsonObject.get("id"));
                    tempPerson.setName((String) peopleJsonObject.get("name"));
                    tempPerson.setGender((String) peopleJsonObject.get("gender"));
                    tempPerson.setAge((String) peopleJsonObject.get("age"));
                    tempPerson.setEyeColor((String) peopleJsonObject.get("eye_color"));
                    tempPerson.setHairColor((String) peopleJsonObject.get("hair_color"));
                    tempPerson.setFilms(films);
                    tempPerson.setSpecies(getSpecies(peopleJsonObject.get("species").toString()));
                    tempPerson.setUrl((String) peopleJsonObject.get("url"));

                    people.add(tempPerson);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            for (Object specie:speciesList
            ) {
                species.add(specie.toString());
            }
            for (Object location:locationsList
            ) {
                locations.add(location.toString());
            }
            for (Object vehicle:vehiclesList
            ) {
                vehicles.add(vehicle.toString());
            }

            javaObject.setId((String) jsonObject.get("id"));
            javaObject.setTitle((String) jsonObject.get("title"));
            javaObject.setOriginal_title((String) jsonObject.get("original_title"));
            javaObject.setOriginal_title_romanised((String) jsonObject.get("original_title_romanised"));
            javaObject.setDescription((String) jsonObject.get("description"));
            javaObject.setDirector((String) jsonObject.get("director"));
            javaObject.setProducer((String) jsonObject.get("producer"));
            javaObject.setRelease_date((String) jsonObject.get("release_date"));
            javaObject.setRunning_time((String) jsonObject.get("running_time"));
            javaObject.setRt_score((String) jsonObject.get("rt_score"));
            javaObject.setPeople(people);
            javaObject.setSpecies(species);
            javaObject.setLocations(locations);
            javaObject.setVehicles(vehicles);
            javaObject.setUrl((String) jsonObject.get("url"));

            mav.addObject("movie", javaObject);

            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in MovieController: " + e);
        }        return mav;
    }

    public String getSpecies(String speciesUrl){
        try {
            URL url = new URL(speciesUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            JSONParser parser = new JSONParser();
            Object object = parser.parse(response.toString());
            JSONObject jsonObject = (JSONObject) object;

            return jsonObject.get("name").toString();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
