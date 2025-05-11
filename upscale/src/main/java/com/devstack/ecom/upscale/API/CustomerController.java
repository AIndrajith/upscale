package com.devstack.ecom.upscale.API;

import com.devstack.ecom.upscale.dto.request.RequestCustomerDto;
import com.devstack.ecom.upscale.service.CustomerService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto){
        customerService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){ // Pathvariables are used to get one value
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer data!",customerService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(
            @PathVariable String id,
            @RequestBody RequestCustomerDto dto){
        customerService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer was updated!",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> findAll(
            @RequestParam String searchText,  // in here we use RequestParam to get more than one value
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(201,"Customer List!",
                customerService.findAll(searchText, page, size)),
                HttpStatus.CREATED
        );
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