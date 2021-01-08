package com.bowang.recommandationSystem.service;

import com.bowang.recommandationSystem.Repository.HistoryRepository;
import com.bowang.recommandationSystem.entity.History;
import com.bowang.recommandationSystem.entity.Item;
import com.bowang.recommandationSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    JobService jobService;

    @Autowired
    UserService userService;

    public List<History> getAllHistoryByUserID(Long userID) {
        List<History> histories = historyRepository.findAll();
        List<History> res = new ArrayList<>();
        for(History history: histories) {
            if(history.getUserID().equals(String.valueOf(userID))) {
                res.add(history);
            }
        }
        return res;
    }

    public List<History> likeAJob() {
        User user = userService.getAUser();
        Item job = jobService.getAJob();
        historyRepository.save(new History(String.valueOf(user.getId()), job.getId()));
        return historyRepository.findAll();
    }

    public List<History> getAllHistory() {
        return historyRepository.findAll();
    }

    public List<History> deleteAllHistory() {
        historyRepository.deleteAll();
        return historyRepository.findAll();
    }
}
