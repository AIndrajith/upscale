package com.devstack.ecom.upscale.API;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public String create(@RequestBody RequestCustomerDto dto){
        customerService.create(dto);
        return "create()";
    }

    @PutMapping()
    public String update(@RequestBody RequestCustomerDto dto){
        return "update()";
    }

    @GetMapping("/list")
    public String findAll(
            @RequestParam String searchText,  // in here we use RequestParam to get more than one value
            @RequestParam int page,
            @RequestParam int size
    ){
        return "findAll()";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id){ // Pathvariables are used to get one value
        return "getById()";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return "delete()";
    }
}

//  http://localhost:8001/api/v1/customers (POST)       (save)
//  http://localhost:8001/api/v1/customers (PUT)        (update)
//  http://localhost:8001/api/v1/customers/list (GET)   (find)
//  http://localhost:8001/api/v1/customers/123{id of customer} (GET)        (find)
//  http://localhost:8001/api/v1/customers (DELETE)     (remove)