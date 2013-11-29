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
        int w=1,h=1;
        String linea;
        int [][]arr;
        int x_fin=0,y_fin=0;
        while(true){
            linea=br.readLine();
            String[] dim=linea.split(" ");
            w=Integer.parseInt(dim[0].trim());
            h=Integer.parseInt(dim[1].trim());

            if(w==0 && h==0){break;}

            arr=new int[h][w];
            boolean [][]visitados=new boolean[h][w];
            int [][]dist=new int[h][w];
            ArrayList<Nodo> cola=new ArrayList<Nodo>();
            for(int i=0;i<h;i++){
                linea=br.readLine().trim();
                for(int j=0;j<w;j++){
                    dist[i][j]=6250;
                    char c=linea.charAt(j);
                    if(c=='S'){
                        cola.add(new Nodo(i,j));
                        dist[i][j]=0;
                        arr[i][j]=0;
                    }else if(c=='D'){
                        x_fin=i;y_fin=j;
                        arr[i][j]=0;
                    }else if(c=='X'){
                        visitados[i][j]=true;
                        arr[i][j]=6250;
                    }else{
                        arr[i][j]=c-'0';
                    }
                }
            }

            ///BFS
            while(!cola.isEmpty()){
                int alt=-1;
                int index=0;
                int min=6250;
                //Buscamos u;
                for(int i=0;i<cola.size();i++){
                    Nodo t=cola.get(i);
                    if(dist[t.x][t.y] < min){
                        min=dist[t.x][t.y];
                        index=i;
                    }
                }
                Nodo u=cola.remove(index);

                visitados[u.x][u.y]=true;

                if(u.x==x_fin && u.y==y_fin){break;}

                if(u.x-1>=0){
                    alt=dist[u.x][u.y] + arr[u.x-1][u.y];
                    if(alt < dist[u.x-1][u.y] && !visitados[u.x-1][u.y]){
                        dist[u.x-1][u.y]=alt;
                        cola.add(new Nodo(u.x-1,u.y));
                    }
                }
                if(u.x+1<h){
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
                if(u.y+1<w){
                    alt=dist[u.x][u.y] + arr[u.x][u.y+1];
                    if(alt < dist[u.x][u.y+1] && !visitados[u.x][u.y+1]){
                        dist[u.x][u.y+1]=alt;
                        cola.add(new Nodo(u.x,u.y+1));
                    }
                }
            }
            System.out.println(dist[x_fin][y_fin]);

            br.readLine();//linea en blanco para separar los casos de prueba
        }
    }

}