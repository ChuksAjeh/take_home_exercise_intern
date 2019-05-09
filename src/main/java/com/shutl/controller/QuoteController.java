package com.shutl.controller;

import com.shutl.model.Greeting;
import com.shutl.model.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

//@RestController
@Controller
public class QuoteController {

    /*Display the initial form submission page and create a model object to pass the values through to.*/
    @GetMapping("/quote")
    public String greetingForm(Model model){
        model.addAttribute("quote", new Quote());
        return "quote";
    }


    /*Values passed from the above method are sent here and a new model object takes the mapped
    * for displaying.*/
    @PostMapping("/quote")
    public String quote(@ModelAttribute("quote") Quote quote, Model model) {
        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);

        /*Simple if-else if-else statement block that will apply the markup accordingly*/
        if(quote.getVehicle().equals("bicycle")){
            price = (long) Math.round(price * 1.10);
        }else if(quote.getVehicle().equals("motorbike")){
            price = (long) Math.round(price * 1.15);
        }else if(quote.getVehicle().equals("parcel_car")){
            price = (long) Math.round(price * 1.2);
        }else if(quote.getVehicle().equals("small_van")){
            price = (long) Math.round(price * 1.30);
        }else{
            price = (long) Math.round(price * 1.40);
        }
        model.addAttribute("pickupPostcode", quote.getPickupPostcode());
        model.addAttribute("deliveryPostcode", quote.getDeliveryPostcode());
        model.addAttribute("vehicle", quote.getVehicle());
        model.addAttribute("price", price);

        /*values that have been added to the model parameter
        are then sent to the result html page for displayin*/
        return "result";
    }

    /*for part 1 if and only if using applications such as postman to send an initial json request [not via the webpage]
    * code above fulfills part 1 and 2.*/
    /*
    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);
        if(quote.getVehicle().equals("bicycle")){
            price = (long) Math.round(price * 1.10);
        }else if(quote.getVehicle().equals("motorbike")){
            price = (long) Math.round(price * 1.15);
        }else if(quote.getVehicle().equals("parcel_car")){
            price = (long) Math.round(price * 1.2);
        }else if(quote.getVehicle().equals("small_van")){
            price = (long) Math.round(price * 1.30);
        }else{
            price = (long) Math.round(price * 1.40);
        }
        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(),quote.getVehicle(), price);
    }
    */

}
