package com.example.bank.Contoller;

import com.example.bank.ApiResponse.ApiResponse;
import com.example.bank.Model.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class ControllerBank {
ArrayList<Bank>custmors=new ArrayList<>();

@GetMapping("/get")
    public ArrayList<Bank>GetCustomers(){

    return custmors;
    }

    @PostMapping("/add")

    public ApiResponse add(@RequestBody Bank costumers){

    custmors.add(costumers);
    return new ApiResponse("added");
    }
@PutMapping("update/{index}")
    public ApiResponse update(@PathVariable int index , @RequestBody Bank coustmer){

    custmors.set(index,coustmer);
    return new ApiResponse("Updated");
}
@DeleteMapping("/delete/{index}")
public ApiResponse delete(@PathVariable int index){
    custmors.remove(index);
    return new ApiResponse("deleted");
}


@PutMapping("/diposit/{index}/{amount}")
public ApiResponse diposit(@PathVariable int index ,@PathVariable Double amount){
    double dipost = custmors.get(index).getBalance() + amount;
    custmors.get(index).setBalance(dipost);
    return new ApiResponse("Succassfuly Diposy");
}

@PutMapping("/withdraw/{index}/{amount}")

public ApiResponse withdraw(@PathVariable int index, @PathVariable Double amount){
    if(custmors.get(index).getBalance()<amount){
        return new ApiResponse("balance not enough");
    }

    double withdraw = custmors.get(index).getBalance()-amount;
    custmors.get(index).setBalance(withdraw);

    return new ApiResponse("Succassfuly withdraw");
}


}
