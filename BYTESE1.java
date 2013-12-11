import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class Nodo{
    public int x,y;
    public Nodo(int i,int j){
        x=i;y=j;
    }
}

class Main{

    public static void main(String []args) throws Exception{
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine().trim());
        int m,n,xf,yf,t;
        String linea,pedazos[];
        int arr[][];
        while(k-->0){
            pedazos=br.readLine().trim().split(" ");
            m=Integer.parseInt(pedazos[0]);
            n=Integer.parseInt(pedazos[1]);

            arr=new int[m][n];
            boolean [][]visitados=new boolean[m][n];
            int [][]dist=new int[m][n];
            ArrayList<Nodo> cola=new ArrayList<Nodo>();
            
            for(int i=0;i<m;i++){
                pedazos=br.readLine().trim().split(" ");
                for(int j=0;j<n;j++){
                    arr[i][j]=Integer.parseInt(pedazos[j]);
                    dist[i][j]=9*m*n;
                }
            }
            pedazos=br.readLine().trim().split(" ");
            xf=Integer.parseInt(pedazos[0]);
            yf=Integer.parseInt(pedazos[1]);
            t =Integer.parseInt(pedazos[2]);

            visitados[0][0]=true;
            dist[0][0]=arr[0][0];

            cola.add(new Nodo(0,0));

            while(!cola.isEmpty()){
                int alt=-1;
                int index=0;
                int min=6250;
                //Buscamos u;
                for(int i=0;i<cola.size();i++){
                    Nodo tt=cola.get(i);
                    if(dist[tt.x][tt.y] < min){
                        min=dist[tt.x][tt.y];
                        index=i;
                    }
                }
                Nodo u=cola.remove(index);

                visitados[u.x][u.y]=true;

                if(u.x==xf && u.y==yf){break;}

                if(u.x-1>=0){
                    alt=dist[u.x][u.y] + arr[u.x-1][u.y];
                    if(alt < dist[u.x-1][u.y] && !visitados[u.x-1][u.y]){
                        dist[u.x-1][u.y]=alt;
                        cola.add(new Nodo(u.x-1,u.y));
                    }
                }
                if(u.x+1<m){
                    alt=dist[u.x][u.y] + arr[u.x+1][u.y];
                    if(alt < dist[u.x+1][u.y] && !visitados[u.x+1][u.y]){
                        dist[u.x+1][u.y]=alt;
                        cola.add(new Nodo(u.x+1,u.y));
                    }
                }
                if(u.y-1>=0){
                    alt=dist[u.x][u.y] + arr[u.x][u.y-1];
                    if(alt < dist[u.x][u.y-1] && !visitados[u.x][u.y-1]){
                        dist[u.x][u.y-1]=alt;
                        cola.add(new Nodo(u.x,u.y-1));
                    }
                }
                if(u.y+1<n){
                    alt=dist[u.x][u.y] + arr[u.x][u.y+1];
                    if(alt < dist[u.x][u.y+1] && !visitados[u.x][u.y+1]){
                        dist[u.x][u.y+1]=alt;
                        cola.add(new Nodo(u.x,u.y+1));
                    }
                }
            }
            if(dist[xf-1][yf-1]<=t){
                System.out.println("YES\n"+(t-dist[xf-1][yf-1]));
            }else{
                System.out.println("NO");
            }
        }
    }
}