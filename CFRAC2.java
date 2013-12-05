import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;

class Main{
    
    Pattern entero = Pattern.compile("\\.*(\\d+)\\.\\+\\.(\\-)+");
    Matcher matcher = null;

    public static void main(String []args) throws IOException{
        new Main().run();
    }

    void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int m,n;
        //long num,den,tmp;
        BigInteger num,den,tmp;
        String linea;
        while(true){
            linea=br.readLine().trim();
            String[] pedazos=linea.split(" ");
            m=Integer.parseInt(pedazos[0]);
            n=Integer.parseInt(pedazos[1]);
            if(m==0 && n==0){break;}
            BigInteger []enteros=new BigInteger[m/2];
            for(int i=0;i<m;i++){
                linea=br.readLine().trim();
                if(i%2!=0){
                    matcher=entero.matcher(linea);
                    matcher.matches();
                    enteros[(i-1)/2]=new BigInteger(matcher.group(1));
                }
            }

            den=enteros[m/2-1].add(BigInteger.ONE);
            num=BigInteger.ONE;
            //den=enteros[m/2-1]+1;
            //num=1;
            for(int i=m/2-2;i>=0;i--){
                tmp=den.multiply(enteros[i]).add(num);
                //tmp=den*enteros[i]+num;
                num=den;
                den=tmp;
            }
            //Lo imprimo al reves por la ultima inversion que se hizo
            //en el ciclo que no es necesaria;
            System.out.println(den+" "+num);
        }
    }
}