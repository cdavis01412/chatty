public class Main {
    public static void main(String[] args) throws Exception {

        Server svr = new Server(); 
        
        svr.Add(new Chatter("Steve",svr));
        svr.Add(new Chatter("Adam",svr));
        svr.Add(new Chatter("Chad",svr));
        svr.Add(new Chatter("Mike",svr));
        
    }
}
