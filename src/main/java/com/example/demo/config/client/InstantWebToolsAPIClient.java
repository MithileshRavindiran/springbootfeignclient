package com.example.demo.config.client;


import com.example.demo.config.CustomFeignClientConfiguration;
import com.example.demo.rest.request.AirlineCreateRequest;
import com.example.demo.rest.request.PassengerUpdateRequest;
import com.example.demo.rest.response.AirlineResponse;
import com.example.demo.rest.response.PaginatedPassengerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${app.feign.config.name}", url = "${app.feign.config.url}", configuration = CustomFeignClientConfiguration.class)
public interface InstantWebToolsAPIClient {

    @RequestMapping(method = RequestMethod.GET, value = "/airlines")
    List<AirlineResponse> readAirLines();

    @RequestMapping(method = RequestMethod.GET, value = "/airlines/{airlineId}")
    AirlineResponse readAirLineById(@PathVariable String airlineId);

    @RequestMapping(method = RequestMethod.GET, value = "/passenger")
    PaginatedPassengerResponse readPassengers(@RequestParam("size") Long size, @RequestParam("page") Long page);

    @RequestMapping(method = RequestMethod.POST, value = "/airlines")
    AirlineResponse createAirline(@RequestBody AirlineCreateRequest airlineCreateRequest);

    @RequestMapping(method = RequestMethod.DELETE, value = "/passenger/{passengerId}")
    String deletePassenger(@PathVariable String passengerId);

    @RequestMapping(method = RequestMethod.PATCH, value = "/passenger/{passengerId}")
    String updatePassenger(@PathVariable String passengerId, @RequestBody PassengerUpdateRequest request);

}
