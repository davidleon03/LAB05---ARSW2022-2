package edu.eci.arsw.blueprints.controller;

import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/v1/blueprint")
public class BlueprintAPIController {


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> blueprintsServices() {
        try {
            BlueprintsPersistence bpp;
            BlueprintsServices blueprintsServices = new BlueprintsServices(bpp);
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(blueprintsServices, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
        }
    }
}