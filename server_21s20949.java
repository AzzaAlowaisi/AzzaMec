import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class server_21s20949 implements Runnable 
{
    public void tun() throws SQLException, IOException
    {
        try {
          String URL="jdbc:derby://localhost:1527/Azza21";
          String user;
            user = "AZZA221";
          String password="1234";
          
          Connection tt_21s20949= DriverManager.getConnection(URL,user,password);
          
          ServerSocket server=new ServerSocket(8000);
          System.out.println("Server Running");
          
         while(true){
         Socket Client=server.accept();
         DataInputStream da_21s20949=new DataInputStream(Client.getInputStream());
         int AS_21s20949= da_21s20949.readInt();
         int A_21s20949= da_21s20949.readInt();
         System.out.println("your BeverageCode"+AS_21s20949);
         System.out.println("Cups" +A_21s20949);

         Statement t_21s20949 = tt_21s20949.createStatement();
         String E_21s20949= "SELECT*FROM UNTITLED2 WHERE BAVEREAGECODE="+AS_21s20949;
         ResultSet Q_21s20949= t_21s20949.executeQuery(E_21s20949);
         
        DataOutputStream ea_21s20949 = new DataOutputStream (Client.getOutputStream());
        
         while(Q_21s20949.next()){
             String EW_21s20949= Q_21s20949.getString("BEVERAGENAME");
             double op_21s20949= Q_21s20949.getDouble("PRICE");
             
             double k_21s20949= op_21s20949*A_21s20949;
             
            ea_21s20949.writeUTF(EW_21s20949);
            ea_21s20949.writeDouble(op_21s20949);
            
             System.out.println("send Client");
             
             ea_21s20949.flush();
         }
         
         } 
        } catch (IOException | SQLException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
