package com.example.tasksystem1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class TaskSystem {
    @Getter
    @Setter
    private int ID;
    @Setter
    private String title;
    @Getter
    private String status;

    public String getTitle(TaskSystem title) {
        return this.title;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }
}
