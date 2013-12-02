import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

class Main{

    final static BigInteger dos=new BigInteger("2");

    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BigInteger total,x,n,natalia,klaudia;
        for(int i=0;i<10;i++){
            total=new BigInteger(br.readLine().trim());
            x=new BigInteger(br.readLine().trim());

            natalia=total.subtract(x).divide(dos);
            klaudia=natalia.add(x);
            System.out.println(klaudia+"\n"+natalia);
        }
    }
}