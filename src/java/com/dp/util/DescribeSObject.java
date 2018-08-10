/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

import com.sforce.soap.metadata.PicklistEntry;
import com.sforce.soap.partner.DescribeSObjectResult;
import com.sforce.soap.partner.Field;
import com.sforce.soap.partner.FieldType;
import com.sforce.ws.ConnectionException;
import java.io.FileNotFoundException;

/**
 *
 * @author Siddhrajsinh_Atodari
 */
public class DescribeSObject {

    public static void main(String[] args) throws FileNotFoundException {
        describeSObjectSample();
    }
    public static void describeSObjectSample() throws FileNotFoundException {
        try {
            // Make the describe call
            DescribeSObjectResult describeSObjectResult = MetadataLoginUtil.sfdcPartnerConncetion().describeSObject("Account");

            // Get sObject metadata 
            if (describeSObjectResult != null) {
                System.out.println("sObject name: "
                        + describeSObjectResult.getName());
                if (describeSObjectResult.isCreateable()) {
                    System.out.println("Createable");
                }

                // Get the fields
                Field[] fields = describeSObjectResult.getFields();
                System.out.println("Has " + fields.length + " fields");

                // Iterate through each field and gets its properties 
                for (int i = 0; i < fields.length; i++) {
                    Field field = fields[i];
                    System.out.println("Field name: " + field.getName());
                    System.out.println("Field label: " + field.getLabel());

                    // If this is a picklist field, show the picklist values
                    if (field.getType().equals(FieldType.picklist)) {
                        com.sforce.soap.partner.PicklistEntry[] picklistValues
                                = field.getPicklistValues();
                        if (picklistValues != null) {
                            System.out.println("Picklist values: ");
                            for (int j = 0; j < picklistValues.length; j++) {
                                if (picklistValues[j].getLabel() != null) {
                                    System.out.println("\tItem: "
                                            + picklistValues[j].getLabel()
                                    );
                                }
                            }
                        }
                    }

                    // If a reference field, show what it references
                    if (field.getType().equals(FieldType.reference)) {
                        System.out.println("Field references the "
                                + "following objects:");
                        String[] referenceTos = field.getReferenceTo();
                        for (int j = 0; j < referenceTos.length; j++) {
                            System.out.println("\t" + referenceTos[j]);
                        }
                    }
                }
            }
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }
    }
}
