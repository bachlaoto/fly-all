package com.ifisolution.flyrest.controllers;

import com.ifisolution.flyrest.domain.FlightSchedule;
import com.ifisolution.flyrest.services.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("flightSchedule")
public class FlightScheduleController {
    @Autowired
    private FlightScheduleService flightScheduleService;

    @RequestMapping("/get")
    public List<FlightSchedule> findAllFlightSchedule() {
        return flightScheduleService.getFlightSchedule();
    }


    @RequestMapping("/{id}/show")
    public FlightSchedule showById(@PathVariable Long id) {
        return flightScheduleService.findFlightScheduleById(new Long(id));
    }

    @PostMapping("/new")
    public FlightSchedule newFlightSchedule(@RequestBody FlightSchedule flightSchedule) throws IOException {
        return flightScheduleService.saveFlightSchedule(flightSchedule);
//        ObjectMapper objectMapper = new ObjectMapper();
//        FlightSchedule flightSchedule = objectMapper.readValue(json, FlightSchedule.class);
//        return flightScheduleService.saveFlightSchedule(flightSchedule);
    }

    @PutMapping("/update")
    public FlightSchedule UpdateFlightSchedule(@RequestBody FlightSchedule flightSchedule) {
        FlightSchedule flightScheduleTemp = flightScheduleService.findFlightScheduleById(flightSchedule.getId());
//        if (flightScheduleTemp != null) {
//            flightScheduleService.saveFlightSchedule(flightSchedule);
//            return flightSchedule;
//        }
        flightScheduleService.saveFlightSchedule(flightScheduleTemp);
        return flightScheduleTemp;
    }

    //        @PutMapping("/update")
//        public void UpdateFlightSchedule(@RequestBody String json, HttpServletResponse resp) throws IOException {
//            ObjectMapper mapper = new ObjectMapper();
//            FlightSchedule cus = mapper.readValue(json, FlightSchedule.class);
//            flightScheduleService.save(cus);
//            resp.getWriter().print(cus);
//        }
    //    @PostMapping("/flightSchedule")
//    public String saveOrUpdate(@ModelAttribute FlightSchedule flightSchedule ){
//        FlightSchedule savedFlightSchedule = flightScheduleService.save(flightSchedule);
//        return "redirect:/flightSchedule/" + savedFlightSchedule.getId() + "/show";
//    }
//
//
    @DeleteMapping("/delete/{id}")
    public void deleteFlightScheduleById(@PathVariable("id") String id, HttpServletResponse res) throws IOException {
//        FlightSchedule flightScheduleTemp = flightScheduleService.findFlightScheduleById(Long.parseLong(id));
//        flightScheduleService.deleteFlightScheduleById(Long.parseLong(id));
        res.getWriter().print(id);
        flightScheduleService.deleteFlightScheduleById(Long.valueOf(id));
    }
}