package com.CreateAPI.WebApplication.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AuthenticationService {

//    public String extractAuthenticatedUsername(HttpServletRequest request) {
//        String[] credentials = getCredentialsFromRequest(request);
//        if (credentials != null && credentials.length > 0) {
//            return credentials[0]; // Assuming username is the first element in credentials array
//        }
//        return null;
//    }
    public String[] getCredentialsFromRequest(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header!=null && header.startsWith("Basic")){
            try {
                String base64Credentials = header.substring(6);
                byte[] decodedByte = Base64.getDecoder().decode(base64Credentials);
                String decodedString = new String(decodedByte);
                return decodedString.split(":");
            }catch (Exception e){
                System.out.println("Encountered exception: "+e.getMessage());
            }
        }
        return null;
    }
}