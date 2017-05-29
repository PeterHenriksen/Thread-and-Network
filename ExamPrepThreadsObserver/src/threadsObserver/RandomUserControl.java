package threadsObserver;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends java.util.Observable {

    public void fetchRandomUser(RandomUserForm gui) {
        Runnable fUser = () -> {
        RandomUser user = null;
            try {
                System.out.println("fetching");
                user = RandomUserGenerator.getRandomUser();
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.out.println("fetching");
                setChanged();
                addObserver(gui);
                notifyObservers(user);
                System.out.println(user);
            }
        }; new Thread(fUser).start();
    }
}
