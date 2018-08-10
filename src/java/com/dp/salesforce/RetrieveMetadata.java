/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.salesforce;

import com.dp.model.ApexBean;
import com.dp.util.MetadataLoginUtil;
import com.google.gson.Gson;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Siddhrajsinh_Atodari
 */
public class RetrieveMetadata {

    public static List<ApexBean> getApexClasses() {
        List<ApexBean> classList = new ArrayList<>();
        ApexBean aobj = new ApexBean();
        try {

            //for (String recid : Ids.split(",")) {
            String query = "SELECT Id,Name,Status FROM ApexClass limit 100";
            QueryResult queryResults = MetadataLoginUtil.sfdcPartnerConncetion().query(query);
            if (queryResults.getSize() > 0) {

                boolean done = false;
                while (!done) {
                    SObject[] records = queryResults.getRecords();
                    for (SObject record : records) {
                        aobj = new ApexBean();
                        aobj.setClassname(record.getField("Name").toString());
                        classList.add(aobj);
                        System.out.println("------>" + record.getField("Name"));
                    }
                    if (queryResults.isDone()) {
                        done = true;
                    } else {
                        queryResults = MetadataLoginUtil.sfdcPartnerConncetion().queryMore(queryResults.getQueryLocator());
                    }
                }

            }

            //   }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("---size--->" + classList.size());
        
        return classList;
    }

}
