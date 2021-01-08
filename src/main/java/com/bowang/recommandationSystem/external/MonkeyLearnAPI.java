package com.bowang.recommandationSystem.external;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;
import org.json.simple.JSONArray;

import java.util.List;

public class MonkeyLearnAPI {

    public JSONArray extract(List<String> descriptions) throws MonkeyLearnException {
        MonkeyLearn ml = new MonkeyLearn("cecd9b976e564ed485d0b784769b2f5038efe47f");
        String modelId = "ex_YCya9nrn";
        String[] data = new String[descriptions.size()];
        for(int i = 0;i < descriptions.size();i ++) {
            data[i] = descriptions.get(i);
        }
        MonkeyLearnResponse res = ml.extractors.extract(modelId, data);
        return res.arrayResult;
    }
}
