import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client_21s20949 implements Runnable
{
    
    public void run()
    {
           try
        {
          Socket st_21s20949=new Socket ("localhost",8000);
          Scanner sc_21s20949=new Scanner (System.in);
          System.out.println("Enter BeverageCode");
          int AS_21s20949=sc_21s20949.nextInt();
          System.out.println("Enter number of cups");
          int A_21s20949=sc_21s20949.nextInt();
         
          
          DataOutputStream ds_21s20949=new DataOutputStream (st_21s20949.getOutputStream());
          ds_21s20949.writeInt(AS_21s20949);
          ds_21s20949.writeInt(A_21s20949);
          ds_21s20949.flush();
          
          
          DataInputStream is_21s20949=new DataInputStream (st_21s20949.getInputStream());
          String EW_21s20949 =is_21s20949.readUTF();
          Double k_21s20949 =is_21s20949.readDouble();
          
          System.out.println("The BeverageName"+EW_21s20949);
          System.out.println("The price"+k_21s20949);
          
       

               
           } catch (IOException ex) {
            Logger.getLogger(Client_21s20949.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}

