package com.bowang.recommandationSystem.service;

import com.bowang.recommandationSystem.Repository.ItemRepository;
import com.bowang.recommandationSystem.Repository.KeyWordPairRepository;
import com.bowang.recommandationSystem.entity.*;
import com.bowang.recommandationSystem.external.MonkeyLearnAPI;
import com.google.gson.Gson;
import com.monkeylearn.MonkeyLearnException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.util.*;

@Component
public class JobService {

    @Value("${jobInfoUrl}")
    String jobInfoUrl;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    KeyWordPairRepository keyWordPairRepository;

    @Autowired
    DetailService detailService;

    public void initialize() {
        loadJobData();
        loadKeyWordData();
    }

    public Item getAJob() {
        List<Item> items = itemRepository.findAll();
        int index = (int)Math.round(Math.random() * items.size());
        return items.get(index);
    }

    public List<String> getKeyWordsByJobId(List<String> id) {
        Set<String> uniqueIDs = new HashSet<>(id);
        Set<String> keyWords = new HashSet<>();
        List<KeyWordPair> keyWordPairs = keyWordPairRepository.findAll();
        for(KeyWordPair keyWordPair: keyWordPairs) {
            if(uniqueIDs.contains(keyWordPair.getItemID())) {
                keyWords.add(keyWordPair.getKeyword());
            }
        }
        return new ArrayList<>(keyWords);
    }

    public List<Item> getJobsById(List<String> ids) {
        return itemRepository.findAllById(ids);
    }

    List<Item> loadJobData() {
        try {
            itemRepository.deleteAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        Job[] jobs = getJobsWithKeyWords();
        for(Job job: jobs) {
            itemRepository.save(new Item(job));
        }
        return itemRepository.findAll();
    }

    List<KeyWordPair> loadKeyWordData() {
        keyWordPairRepository.deleteAll();
        Job[] jobs = getJobsWithKeyWords();
        for(Job job: jobs) {
            for(KeyWord keyWord: job.getKeyWords()) {
                keyWordPairRepository.save(new KeyWordPair(job.getJobID(), keyWord.getKeyword()));
            }
        }
        return keyWordPairRepository.findAll();
    }

    Job[] getAllJobs() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(jobInfoUrl, String.class);
        Gson gson = new Gson();
        Job[] jobs = gson.fromJson(result, Job[].class);
        return jobs;
    }

    List<String> getAllDescription(Job[] jobs) {
        List<String> descriptions = new ArrayList<>();
        for(Job job: jobs) {
            descriptions.add(job.getDescription());
        }
        return descriptions;
    }

    JSONArray getKeyWords(List<String> descriptions) {
//        MonkeyLearnAPI monkeyLearnAPI = new MonkeyLearnAPI();
//        try {
//            return monkeyLearnAPI.extract(descriptions);
//        } catch (MonkeyLearnException e) {
//            e.printStackTrace();
//        }
//        return null;
        try {
            FileReader reader = new FileReader("./keywords.json");
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    Job[] getJobsWithKeyWords() {
        Job[] jobs = getAllJobs();
        JSONArray keyWordsArray = getKeyWords(getAllDescription(jobs));
        Gson gson = new Gson();
        for(int i = 0;i < keyWordsArray.size();i ++) {
            KeyWord[] keyWords = gson.fromJson(keyWordsArray.get(i).toString(), KeyWord[].class);
            jobs[i].setKeyWords(keyWords);
        }
        return jobs;
    }

    public List<JobCard> rankSimilarity(Long userID) {
        List<KeyWordPair> keyWordPairs = keyWordPairRepository.findAll();
        List<JobCard> jobCards = new ArrayList<>();
        Map<String, List<String>> descriptionMap = new HashMap<>();
        for(KeyWordPair keyWordPair: keyWordPairs) {
            if(!descriptionMap.containsKey(keyWordPair.getItemID())) {
                descriptionMap.put(keyWordPair.getItemID(), new ArrayList<>());
            }
            List<String> l = descriptionMap.get(keyWordPair.getItemID());
            l.add(keyWordPair.getKeyword());
            descriptionMap.put(keyWordPair.getItemID(), l);
        }
        for(String key: descriptionMap.keySet()) {
            jobCards.add(new JobCard(key,
                    getSimilarity(detailService.getDetail(userID).getKeyWords(),
                            descriptionMap.get(key))));
        }
        Collections.sort(jobCards);
        return jobCards;
    }

    double getSimilarity(List<String> a, List<String> b) {
        if(a.size() == 0 || b.size() == 0) return 0.0;
        double same = 0.0;
        Set<String> s = new HashSet<>();
        for(String word: a) {
            s.add(word);
        }
        for(String word: b) {
            if(s.contains(word)) {
                same++;
            }
        }
        return same / Math.sqrt(a.size() * b.size());
    }
}
