/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulasi_pipaair;

import java.io.*;
//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.*;

/**
 *
 * @author lenovo
 */
public class Picture_List {

    private String code_pic;

    public Picture_List(String code) {
        this.code_pic = code;
    }

    public String getTitle() {
        return code_pic;
    }

    @Override
    public String toString() {
        String a = this.getTitle();
        return a;
    }
    

}
