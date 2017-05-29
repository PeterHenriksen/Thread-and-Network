/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telnetServer;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Peter Henriksen
 */
public class finalCount {
    static long count = 0;
    private final ReentrantLock lock = new ReentrantLock();
    
    public long countSum(int number){
        try{
            lock.lock();
            count += number;
            return count;
        } finally {
            lock.unlock();
        }
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        finalCount.count = count;
    }
}
