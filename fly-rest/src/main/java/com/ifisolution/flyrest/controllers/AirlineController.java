package com.ifisolution.flyrest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifisolution.flyrest.domain.Airline;
import com.ifisolution.flyrest.services.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("airline")
public class AirlineController {
    @Autowired
    private AirlineService airlineService;

    @RequestMapping("/get")
    public List<Airline> findAllAirline() {
        return airlineService.findAllAirline();
    }


    @RequestMapping("/{id}/show")
    public Airline showById(@PathVariable Long id) {
        return airlineService.findAirlineByID(new Long(id));
    }

    @PostMapping("/new")
    public Airline newAirline(@RequestBody String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Airline airline = objectMapper.readValue(json, Airline.class);
        return airlineService.saveAirline(airline);
    }

    @PutMapping("/update")
    public Airline UpdateAirline(@RequestBody Airline airline) {
        Airline airlineTemp = airlineService.findAirlineByID(airline.getId());
        if (airlineTemp != null) {
            airlineService.saveAirline(airline);
            return airline;
        }
        airlineService.saveAirline(airlineTemp);
        return airlineTemp;
    }

    //        @PutMapping("/update")
//        public void UpdateAirline(@RequestBody String json, HttpServletResponse resp) throws IOException {
//            ObjectMapper mapper = new ObjectMapper();
//            Airline cus = mapper.readValue(json, Airline.class);
//            airlineService.save(cus);
//            resp.getWriter().print(cus);
//        }
    //    @PostMapping("/airline")
//    public String saveOrUpdate(@ModelAttribute Airline airline ){
//        Airline savedAirline = airlineService.save(airline);
//        return "redirect:/airline/" + savedAirline.getId() + "/show";
//    }
//
//
    @DeleteMapping("/delete/{id}")
    public void deleteAirlineById(@PathVariable("id") String id, HttpServletResponse res) throws IOException {
//        Airline airlineTemp = airlineService.findAirlineByID(Long.parseLong(id));
        airlineService.deleteAirline(Long.parseLong(id));
        res.getWriter().print(id);

    }
}