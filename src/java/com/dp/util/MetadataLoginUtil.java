/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.util;

import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.partner.LoginResult;
import com.sforce.soap.partner.PartnerConnection;
import java.io.FileNotFoundException;

/**
 *
 * @author Siddhrajsinh_Atodari
 */
public class MetadataLoginUtil {

    /**
     * @param args the command line arguments
     */
    public static MetadataConnection loginSource() throws ConnectionException {
        final String USERNAME = "siddhrajsinh_atodari@symantec.com.dev1";
        // This is only a sample. Hard coding passwords in source files is a bad practice.
        final String PASSWORD = "72scjp72";
        final String URL = "https://symantecb2b--dev1.my.salesforce.com/services/Soap/u/43.0";
        final LoginResult loginResult = loginToSalesforce(USERNAME, PASSWORD, URL);
        return createMetadataConnection(loginResult);
    }

    public static MetadataConnection loginDestination() throws ConnectionException {
        final String USERNAME = "siddhrajsinh_atodari@symantec.com.dev2";
        // This is only a sample. Hard coding passwords in source files is a bad practice.
        final String PASSWORD = "Sidd@5678";
        final String URL = "https://symantecb2b--dev2.cs96.my.salesforce.com/services/Soap/u/43.0";
        final LoginResult loginResult = loginToSalesforce(USERNAME, PASSWORD, URL);
        return createMetadataConnection(loginResult);
    }

    public static MetadataConnection Authenticate(String USERNAME, String PASSWORD, String URL) throws ConnectionException {
        // This is only a sample. Hard coding passwords in source files is a bad practice.
        URL += "/services/Soap/u/43.0";
        final LoginResult loginResult = loginToSalesforce(USERNAME, PASSWORD, URL);
        return createMetadataConnection(loginResult);
    }

    public static PartnerConnection sfdcPartnerConncetion() throws FileNotFoundException {
        System.setProperty("salesforce.config.dir", "conf");
        PartnerConnection partnerConnection = null;
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername("siddhrajsinh_atodari@symantec.com.dev1");
        config.setPassword("72scjp72");
        config.setAuthEndpoint("https://symantecb2b--dev1.my.salesforce.com/services/Soap/u/43.0");
        try {
            partnerConnection = new PartnerConnection(config);
        } catch (ConnectionException e1) {
            e1.printStackTrace();
        }
        return partnerConnection;
    }

    private static MetadataConnection createMetadataConnection(
            final LoginResult loginResult) throws ConnectionException {
        final ConnectorConfig config = new ConnectorConfig();
        config.setServiceEndpoint(loginResult.getMetadataServerUrl());
        config.setSessionId(loginResult.getSessionId());
        return new MetadataConnection(config);
    }

    private static LoginResult loginToSalesforce(
            final String username,
            final String password,
            final String loginUrl) throws ConnectionException {
        final ConnectorConfig config = new ConnectorConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setAuthEndpoint(loginUrl);
        //config.setServiceEndpoint(loginUrl);
        //config.setManualLogin(true);
        return (new PartnerConnection(config)).login(username, password);
    }

}
