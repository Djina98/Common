/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Cartman
 */
public class Receiver{
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws Exception{
        try{
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error receiving object!\n" + e.getMessage());
        }
    }
}
