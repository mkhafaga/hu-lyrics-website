/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class HeaderController {
    private String q ;
    private ArrayList<String> alphabet;
    private void init(){
        alphabet = new ArrayList<String>();
          for(int i=97;i<123;i++){
        alphabet.add(((char)i+"").toUpperCase());
        }
    
    }

    public HeaderController() {
        init();
    }
    
    

    /**
     * @return the alphabet
     */
    public ArrayList<String> getAlphabet() {
        return alphabet;
    }

    /**
     * @param alphabet the alphabet to set
     */
    public void setAlphabet(ArrayList<String> alphabet) {
        this.alphabet = alphabet;
    }
    
    
    public String search(){
//        System.out.println("does it really come here?!");
    return "search?faces-redirect=true&amp;q="+q;
    }

    /**
     * @return the q
     */
    public String getQ() {
        return q;
    }

    /**
     * @param q the q to set
     */
    public void setQ(String q) {
        this.q = q;
    }
}
