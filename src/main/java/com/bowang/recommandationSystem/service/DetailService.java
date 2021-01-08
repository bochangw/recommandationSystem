package com.bowang.recommandationSystem.service;

import com.bowang.recommandationSystem.entity.History;
import com.bowang.recommandationSystem.entity.Info;
import com.bowang.recommandationSystem.entity.Item;
import com.bowang.recommandationSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DetailService {

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    @Autowired
    HistoryService historyService;

    public Info getDetail(Long userID) {
        List<History> histories = historyService.getAllHistoryByUserID(userID);
        User user = userService.findByID(userID);
        List<String> jobIds = new ArrayList<>();
        for(History history: histories) {
            jobIds.add(history.getItemID());
        }
        List<Item> jobs = jobService.getJobsById(jobIds);
        List<String> keyWords = jobService.getKeyWordsByJobId(jobIds);
        return new Info(user, keyWords, jobs);
    }
}
