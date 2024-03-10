package com.example.tasksystem1.Controller;

import com.example.tasksystem1.ApiResponse.ApiResponse;
import com.example.tasksystem1.Model.TaskSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    List<TaskSystem> taskSystem = new ArrayList<>();

    @PostMapping("/creat")
    public ApiResponse task(@RequestBody TaskSystem taske) {
        taskSystem.add(taske);
        return new ApiResponse("add Sucssefuly");
    }

    @GetMapping("/display")
    public List<TaskSystem> getTask() {
        return taskSystem;
    }

    @PutMapping("/update/{index}")

    public ApiResponse update(@PathVariable int index, @RequestBody TaskSystem taske) {
        taskSystem.set(index, taske);
        return new ApiResponse("Updated Sucsseufly");
    }

    @PutMapping("/status/{index}")
    public String changStatus(@PathVariable int index) {
         if(taskSystem.get(index).getStatus().equalsIgnoreCase("done"))
             return taskSystem.get(index).setStatus("not done");
         else

            return taskSystem.get(index).setStatus("done");
    }

    @GetMapping ("/search/{title}")
    public String serch(@PathVariable String title) {

        for(TaskSystem t:taskSystem) {
           if(t.getTitle().equals(title))
        return t.toString() ;
        }
        return "Not Found";
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index) {

        taskSystem.remove(index);
        return new ApiResponse("deleted");
    }

}



