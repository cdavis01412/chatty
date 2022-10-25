// Christian Davis
// Cld113
// CS3354.225

import java.util.ArrayList;

public class Server implements IChatter {
    private ArrayList<IChatter> chatters = new ArrayList<>();
    public void Add(Chatter x) {chatters.add(x);}
    public void newMessage(String name, String message) {
        for(IChatter Chatter: chatters) Chatter.newMessage(name, message);
    }

}
