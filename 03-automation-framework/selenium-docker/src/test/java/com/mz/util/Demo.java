package com.mz.util;

import com.mz.tests.vendorportal.model.VendorPortalTestData;

public class Demo {
    public static void main(String[] args) {
        VendorPortalTestData testData = JsonUtil.getTestData("test-data/vendor-portal/john.json");
        System.out.println(testData.monthlyEarning());
    }
}
