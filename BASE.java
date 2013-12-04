import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String []args) throws IOException{
        new Main().run();
    }

    void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String linea,pedazos[];
        int b1,b2;
        while(true){
            linea=br.readLine();
            if(linea==null){break;}
            pedazos=linea.trim().split("\\s+");
            b1=Integer.parseInt(pedazos[1]);
            b2=Integer.parseInt(pedazos[2]);
            System.out.println(String.format("%7s",toBase(fromBase(pedazos[0],b1),b2)));
        }
    }

    int fromBase(String numero,int base){
        int res=0;
        int d,n=numero.length();
        for(int i=n-1;i>=0;i--){
            d=numero.charAt(i)-'0';
            if(d>9){
                d-=7;
            }
            res+=d*((int) Math.pow(base,n-1-i));
        }
        return res;
    }

    String toBase(int numero,int base){
        String res="";
        int resto=0;
        while(numero>=base){
            resto=numero%base;
            numero/=base;
            if(base>10 && resto>=10){
                res=((char) (resto+55))+res;
            }else{
                res=resto+res;
            }
        }
        if(base>10 && numero>=10){
            res=((char) (numero+55))+res;
        }else{
            res=numero+res;
        }
        if(res.length()>7){res="ERROR";}
        return res;
    }
}