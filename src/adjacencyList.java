public class adjacencyList {
    EdgeNode[] graph;

    private class EdgeNode{
        int vertex_id;
        int weight;

        EdgeNode prev;
        EdgeNode next;
    }

    public adjacencyList(int num_vertices){
        this.graph=new EdgeNode[num_vertices];
    }

    //add an edge to the graph
    public void addEdge(int from, int to, int weight){
        EdgeNode newNode=new EdgeNode();
        newNode.weight=weight;
        newNode.vertex_id=to;

        newNode.next=this.graph[from];
        if(this.graph[from]!=null){
            this.graph[from].prev=newNode;
        }
        this.graph[from]=newNode;
        newNode.prev=null;
    }

    public int[] getNeighbors(int v){
       // loop to figure out the length of the linkedList
        int count = 0;
        EdgeNode tmp=this.graph[v];
        while(tmp != null){
            count++;
            tmp=tmp.next;
        }
        int[] neighbors = new int[count];

        count=0;
        while(tmp != null){
            neighbors[count]=tmp.vertex_id;
            count++;
            tmp=tmp.next;
        }
        return neighbors;
    }
}
