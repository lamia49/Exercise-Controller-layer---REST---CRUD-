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
    public ApiResponse diposit(@PathVariable int id, @PathVariable Double amount) {
        for (Bank c : custmors) {
            if (c.getID() == id) {
                double dipost = c.getBalance() + amount;
                c.setBalance(dipost);
                return new ApiResponse("Diposy");
            }
        }return new ApiResponse("faild");
    }

@PutMapping("/withdraw/{index}/{amount}")

    public ApiResponse withdraw(@PathVariable int id, @PathVariable Double amount) {

        for (Bank custmer : custmors) {
            if (custmer.getID() == id) {
                if (custmer.getBalance() < amount) {
                    return new ApiResponse("balance not enough");}
                else{
                    double withdraw = custmer.getBalance() - amount;
                    custmer.setBalance(withdraw);
                    return new ApiResponse("withdraw");}
            }
        }
        return new ApiResponse("filed");
    }


}
