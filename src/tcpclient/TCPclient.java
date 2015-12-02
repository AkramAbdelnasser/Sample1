/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;
import java.io.*; 
import java.net.*; 
import java.util.Random;

/**
 *
 * @author Akram
 */
public class TCPclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
                String sentence; 
		String modifiedsentence; 
		BufferedReader inFromuser = new BufferedReader (new InputStreamReader(System.in)); 
		Socket ClientSocket = new Socket ("LocalHost",6789); 
		DataOutputStream OutToServer = new DataOutputStream (ClientSocket.getOutputStream());
		System.out.println("connected"); 
		BufferedReader inFromServer = new BufferedReader (new InputStreamReader(ClientSocket.getInputStream())); 
//		sentence = inFromuser.readLine(); 
                Random x = new Random(); 
                int RandomNumber1 = x.nextInt();
                int RandomNumber2= x.nextInt();
                sentence= Integer.toString(RandomNumber1) + " " + Integer.toString(RandomNumber2);
                System.out.println(RandomNumber1 +" " + RandomNumber2);
		OutToServer.writeBytes(sentence+ '\n'); 
		modifiedsentence=inFromServer.readLine();
		System.out.println("from server :  " + modifiedsentence); 
		ClientSocket.close();    
                System.out.println("");
    
    
    
    }
    
}
