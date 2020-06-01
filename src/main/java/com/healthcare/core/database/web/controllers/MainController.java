package com.healthcare.core.database.web.controllers;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.healthcare.lib.tracking.service.IOldTrackingClient;
//import com.healthcare.lib.tracking.service.ITrackingClient;
import com.healthcare.core.database.domain.HelloWorld;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    /*private ITrackingClient trackingClient;
    private IOldTrackingClient oldTrackingClient;

    @Autowired
    public MainController(ITrackingClient trackingClient, IOldTrackingClient oldTrackingClient) {
        this.trackingClient = trackingClient;
        this.oldTrackingClient = oldTrackingClient;
    }*/

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public HelloWorld index() {
        return new HelloWorld("Hola", "mundo") ;
    }

    /*@RequestMapping(path = "/track", method = RequestMethod.GET)
    public HelloWorld track() throws JsonProcessingException {
        HelloWorldEvent helloWorldEvent = new HelloWorldEvent();
        helloWorldEvent.setHello("Mundo");
        trackingClient.send("Demo", helloWorldEvent);
        oldTrackingClient.send(helloWorldEvent);
        return new HelloWorld("Hola", "mundo") ;
    }*/

    @RequestMapping(path = "/exception", method = RequestMethod.GET)
    public String exception() {
        throw new IndexOutOfBoundsException();
    }
}