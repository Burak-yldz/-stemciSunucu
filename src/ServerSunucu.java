import java.io.*;
import java.net.*;
import java.sql.SQLOutput;

public class ServerSunucu {
    public static final int PORT = 3000;

    public static String karsiliginiBul(int sayi){
        String ifade = null ;
        switch (sayi){
            case 0 : ifade = "Sifir"; break ;
            case 1 : ifade = "Bir"; break ;
            case 2 : ifade = "İki"; break ;
            case 3 : ifade = "Üç"; break ;
            case 4 : ifade = "Dört"; break ;
            case 5 : ifade = "Beş"; break ;
            case 6 : ifade = "Altı"; break ;
            case 7 : ifade = "Yedi"; break ;
            case 8 : ifade = "Sekiz"; break ;
            case 9 : ifade = "Dokuz"; break ;
            default : ifade = "Bilinmeyen deger"; break;
        }
        return ifade;
    }
    public static void main (String[]args) throws IOException {
        ServerSocket sunucuSoketi = new ServerSocket(PORT);
        System.out.println("Basladi :" + sunucuSoketi);
        try{
            Socket kullaniciSoketi = sunucuSoketi.accept();
            try {
                System.out.println("baglanti kabul edildi:" + kullaniciSoketi );
                BufferedReader in = new BufferedReader(new InputStreamReader(kullaniciSoketi.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(kullaniciSoketi.getOutputStream())),true);

                String str = in.readLine();
                while(str != null){
                    System.out.println(str);
                    Integer i = new Integer (str);
                    int sayi = i.intValue();
                    String ifade = karsiliginiBul(sayi);
                    out.println(ifade);
                    str = in .readLine();
                }


            } finally {
                System.out.println("baglanti kapatiliyor ...");
                kullaniciSoketi.close();
            }
        }finally {
            sunucuSoketi.close();
        }
    }
}

