import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Main{
    public static void main(String [] args) throws IOException{
        new Main().run();
    }

    void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int ntmp,n,t=Integer.parseInt(br.readLine().trim());
        String linea,pedazos[];
        float grados[],diffs[];
        while(t-->0){
            n=Integer.parseInt(br.readLine().trim());
            ntmp=n;
            grados=new float[n+1];
            grados[n]=361;
            while(n-->0){
                pedazos=br.readLine().trim().split(" ");
                grados[n]=Float.parseFloat(pedazos[1]);
            }
            Arrays.sort(grados);
            grados[ntmp]=grados[0];

            diffs=new float[ntmp];
            for(int i=ntmp-1;i>=0;i--){
                diffs[i]=(grados[i+1]-grados[i]);
                if(diffs[i]<0){
                    diffs[i]+=360;
                }
            }

            float max=-1;
            int index=0;
            for(int i=0;i<ntmp;i++){
                if(diffs[i]>=max){
                    max=diffs[i];
                    index=i;
                }
            }

            float suma=0;
            for(int i=0;i<ntmp-1;i++){
                suma+=diffs[(index+1+i)%ntmp];
            }
            System.out.println(new Double(Math.ceil(suma*12)).intValue());
        }
    }
}