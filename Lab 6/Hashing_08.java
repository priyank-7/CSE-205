class Node{
    int data;
    Node next;
    public Node(){}
    public Node(int N){
        this.data  = N;
        this.next = null;
    }
    public Node(int N, Node next){
        this.data  = N;
        this.next = next;
    }

}
class Servers {
    private int M;
    private int re_M;
    Node [] hash_table;
    int [] servers;

    public Servers(){}
    public Servers(int M){
        this.M = M;
        hash_table = new Node[M];
    }

    private int hashing(int val){
        return val % M;
    }

    private int reHashing(int val){
        return val % re_M;
    }

    private boolean contains(int n){
        for (int i = 0; i < servers.length; i++) {
            if(servers[i] == n){
                return true;
            }
        }
        return false;
    }

    public void add(int val) {
        int index = hashing(val);
        if(hash_table[index] == null){
            hash_table[index] = new Node(val);
            return;
        }
        Node temp = hash_table[index];
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void crashed_servers(int [] n){
        this.servers = n;
        this.re_M = M - n.length;
        re_allocation();
    }

    public void re_allocation(){
        for (int i = 0; i < servers.length; i++) {
            if (hash_table[servers[i]] != null) {
                Node temp = hash_table[i];
                while (temp != null) {
                    int index = reHashing(temp.data);
                    while(contains(index)) {
                        index = (index+1) % re_M;
                    }
                    re_allocate(temp, index);
                    temp = temp.next;
                }
                hash_table[servers[i]].next = null;
                hash_table[servers[i]] = null;
            }
        }
    }

    private void re_allocate(Node node, int index){
        if(hash_table[index] == null){
            hash_table[index] = node;
            return;
        }
        Node temp = hash_table[index];
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public boolean find(int val){
        if(contains(hashing(val))){
            return findNode(val, reHashing(val));
        }
        return findNode(val, hashing(val));
    }

    private boolean findNode(int node, int index){

        Node temp = hash_table[index];
        while(temp != null){
            if(temp.data == node){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
