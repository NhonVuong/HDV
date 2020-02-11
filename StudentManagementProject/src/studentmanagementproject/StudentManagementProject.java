/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementproject;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Unmatched TaiNguyen
 */
public class StudentManagementProject {

    public StudentManagementProject() {
        json = new Gson();
    }
    
    private Gson json;

    public Gson getJson() {
        return json;
    }

    public void setJson(Gson json) {
        this.json = json;
    }
    /**
     * @param args the command line arguments
     */
    public static void main1(String[] args) {
        // TODO code application logic here
         try {
             StudentManagementProject tool = new StudentManagementProject();
             String url = "http://192.168.0.117/api/StudentManagement/GetListStudent";
            String urldd = "http://192.168.0.117/api/StudentManagement/AddStudent";
            
//            String result = tool.ResquestGet(url);
//             System.out.println(result);
//             Gson g = new Gson();
//             Student[] lst = g.fromJson(result,Student[].class);
//             for(Student i : lst){
//                 System.out.println(i.getFirstName());
//             }
        Student s = new Student(0, "Nguyen", "tai", true, "Quan 9",100, "");
             System.out.println(tool.ResquestPost(urldd, s));
            //call_me();
        } catch (Exception e) {
            e.printStackTrace();
       }
    }
    public String ResquestGet(String url){
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
          //  con.setReadTimeout(5000);
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            if(responseCode!=200) return "-1";
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                
                StringBuilder response = new StringBuilder();
                String inputLine = in.readLine();
                while (inputLine != null) {
                    response.append(inputLine);
                    inputLine = in.readLine();
                }
                return response.toString();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudentManagementProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentManagementProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public <T> String ResquestPost(String url,T t){
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("POST");
            OutputStream wr = con.getOutputStream();
            String data = json.toJson(t);
            System.out.println(data);
            wr.write(data.getBytes());
            wr.close();
            int responseCode = con.getResponseCode();
            System.out.println(responseCode);
            if(responseCode!=200) return "-1";
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                
                StringBuilder response = new StringBuilder();
                String inputLine = in.readLine();
                while (inputLine != null) {
                    response.append(inputLine);
                    inputLine = in.readLine();
                }
                return response.toString();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudentManagementProject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentManagementProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void call_me() throws Exception {
     String url = "http://192.168.1.73/api/StudentManagement/GetListStudent";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("POST");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
   
     int responseCode = con.getResponseCode();
     //if(responseCode!=200) return "-1";
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     //Read JSON response and print
    // Gson myResponse = new Gson(response.toString());
   //  System.out.println(response.toString());
   }
}
