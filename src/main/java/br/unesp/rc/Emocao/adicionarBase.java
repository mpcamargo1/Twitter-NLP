/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Emocao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author marco
 */
public class adicionarBase {
    
    public adicionarBase(){
    
    }
    
    public boolean append(String Mensagem) throws IOException{
    
        Writer output;
        output = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/bullying.txt",true));
        output.append("\r\n0       " + Mensagem);
        output.close();
        
        return true;
    }
    
}
