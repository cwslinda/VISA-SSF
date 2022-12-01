package vttp2022.ssf.ssfworkshop14b.model;

import java.io.Serializable;
import java.util.Random;

public class Contact implements Serializable {
    private String name;
    private String email;
    private int telephone;
    private String id;


    public Contact(){
        this.id = this.generateId(8);
    }

    public Contact(String name, String email, int telephone){
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.id = this.generateId(8);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    private synchronized String generateId(int numChars){
        // to randomise the numbers
        Random r = new Random();
        // to link or form the required string id 
        StringBuilder sb = new StringBuilder();
        // when sb.length is less than the numChar given
        while(sb.length() < numChars){
            // converting integer to hex while randomising the int 
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numChars);
    }

}
