/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projectserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author server
 */
public class ProjectServer {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Server port is 5678");
        
        String msg;
        ServerSocket ss = new ServerSocket(5678);
        
        while(true)
        {
            Socket s = ss.accept();
            
            DataInputStream dis = new DataInputStream(s.getInputStream());
            msg = dis.readUTF();
            
            
            dis.close();
            s.close();
            System.out.println("Recieved data: " + msg);
                 
            
        }
        
        
        
    }
    
}
