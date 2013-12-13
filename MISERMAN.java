import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
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
        int w=1,h=1;
        String linea,pedazos[];
        int [][]arr;
        int x_fin=0,y_fin=0;
        //int T=Integer.parseInt(br.readLine().trim());
        //while(T-->0){
            String[] dim=br.readLine().trim().split("\\s+");
            w=Integer.parseInt(dim[1].trim());
            h=Integer.parseInt(dim[0].trim());

            arr=new int[h][w];
            Integer [][]dist=new Integer[h][w];
            ArrayList<Nodo> cola=new ArrayList<Nodo>();
            boolean [][]visitados=new boolean[h][w];

            for(int i=0;i<h;i++){
                pedazos=br.readLine().trim().split("\\s+");
                for(int j=0;j<w;j++){
                    arr[i][j]=Integer.parseInt(pedazos[j].trim());
                    dist[i][j]=10001;
                }
            }
            for(int j=0;j<w;j++){
                cola.add(new Nodo(0,j));
                dist[0][j]=arr[0][j];
            }

            ///BFS
            while(!cola.isEmpty()){
                int alt=-1;
                int index=0;
                int min=10001;
                //Buscamos u;
                for(int i=0;i<cola.size();i++){
                    Nodo t=cola.get(i);
                    if(dist[t.x][t.y] < min){
                        min=dist[t.x][t.y];
                        index=i;
                    }
                }
                Nodo u=cola.remove(index);

                if(u.x+1<h){
                    if(u.y-1>=0){
                        alt=dist[u.x][u.y] + arr[u.x+1][u.y-1];
                        if(alt < dist[u.x+1][u.y-1]){
                            dist[u.x+1][u.y-1]=alt;
                            cola.add(new Nodo(u.x+1,u.y-1));
                        }
                    }
                    if(u.y+1<w){
                        alt=dist[u.x][u.y] + arr[u.x+1][u.y+1];
                        if(alt < dist[u.x+1][u.y+1]){
                            dist[u.x+1][u.y+1]=alt;
                            cola.add(new Nodo(u.x+1,u.y+1));
                        }
                    }

                    alt=dist[u.x][u.y] + arr[u.x+1][u.y];
                    if(alt < dist[u.x+1][u.y]){
                        dist[u.x+1][u.y]=alt;
                        cola.add(new Nodo(u.x+1,u.y));
                    }
                }
            }
            System.out.println(Collections.min(Arrays.asList(dist[h-1])));
        //}
    }
}