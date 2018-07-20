package com.fandeng.swagger.controller;

import com.fandeng.swagger.entity.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dengfan on 2018/6/26.
 */
@RestController
@RequestMapping("/fandeng")
@Api(value="fandeng_ui", description="this is my first swagger ui ")
public class GreetingController {

    private static final String template = "Hello.%s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json")
    public Greeting greeting(@RequestParam(value="name",defaultValue ="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
