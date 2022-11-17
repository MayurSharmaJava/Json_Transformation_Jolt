package com.mayur.joltdemo.util;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayur.joltdemo.entity.Customer;

import java.util.List;

public class JoltUtil {
    public static <T> T getEntity(String spec, Class<T> clazz, String inputJson) {
        List chainSpecJSON = JsonUtils.jsonToList(spec);
        Chainr chainr = Chainr.fromSpec(chainSpecJSON);
        //Str transformedOutput = chainr.transform(inputJson);
        return (T) new Customer();
    }
}
