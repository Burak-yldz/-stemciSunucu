import java.io.*;
import java.net.*;

public class Clientİstemci {

    public static void main(String[]args) throws IOException{
        InetAddress adres = InetAddress.getByName(null);
        System.out.println("IP adresi =" + adres);
        Socket soket = new Socket(adres,3000);

        try{
            System.out.println("soket = " + soket);
            BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soket.getOutputStream())),true);

            for(int i = 0; i<10 ;i++){
                try{
                    Thread.sleep(300) ;
                    int sayi = (int) (Math.random()*10);
                    out.println(sayi);
                    String str = in.readLine();
                    System.out.println("-->" + sayi + " = " + str );
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

        }finally {
            System.out.println("bağlanti kapatiliyor ...");
            soket.close();
        }
    }
}
