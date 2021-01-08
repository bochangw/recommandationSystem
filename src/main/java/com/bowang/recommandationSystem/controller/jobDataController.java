package com.bowang.recommandationSystem.controller;


import com.bowang.recommandationSystem.Repository.HistoryRepository;
import com.bowang.recommandationSystem.Repository.UserRepository;
import com.bowang.recommandationSystem.entity.*;
import com.bowang.recommandationSystem.service.DetailService;
import com.bowang.recommandationSystem.service.HistoryService;
import com.bowang.recommandationSystem.service.JobService;
import com.bowang.recommandationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/recommandation")
public class jobDataController {

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    @Autowired
    HistoryService historyService;

    @Autowired
    DetailService detailService;

    @GetMapping("/initialize")
    String initialize() {
        jobService.initialize();
        return "Done";
    }

    @GetMapping("/filter")
    String filter(@RequestParam String input) {
        return input.replaceAll("<[^<>]*>", "");
    }

    @GetMapping("/rankSimilarity")
    List<JobCard> rankSimilarity(@RequestParam Long userID) {
        return jobService.rankSimilarity(userID);
    }

    @GetMapping("/getInfo")
    Info getInfo(@RequestParam Long userID) {
        return detailService.getDetail(userID);
    }

    @GetMapping("/likeAJob")
    List<History> likeAJob() {
        return historyService.likeAJob();
    }

    @GetMapping("/history")
    List<History> getAllHistory() {
        return historyService.getAllHistory();
    }

    @DeleteMapping("/history")
    List<History> deleteAllHistory() {
        return historyService.deleteAllHistory();
    }

    @GetMapping("/user")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public List<User> saveAUser(@RequestParam String firstname, @RequestParam String lastname,
                                @RequestParam String password) {
        return userService.saveAUser(firstname, lastname, password);
    }

    @DeleteMapping("/user")
    public List<User> deleteAllUsers() {
        return userService.deleteAllUsers();
    }
}
