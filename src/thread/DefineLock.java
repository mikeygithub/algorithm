package thread;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义同步锁
 */
public class DefineLock {

    /**
     * 当前加锁状态,记录加锁次数
     */
    private volatile int state = 0;

    /**
     * 当前持有锁的线层
     */
    private Thread lockHolder;

    /**
     * 当前阻塞的线层队列
     */
    private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>();

    /**
     * 绕过虚拟机直接操作本地线层
     */
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    private static long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    /**
     * 尝试获取锁
     * @return
     */
    public boolean acquire(){

        //cas比较原子交换
        Thread currentThread = Thread.currentThread();

        int c = getState();

        //判断是否有线程持有锁
        if (c == 0){
            if (waiters.size()==0||compareAndSetState(0,1)){
                setLockHolder(currentThread);
                return true;
            }
        }

        return false;
    }

    protected final boolean compareAndSetState(int expect, int update) {
        // See below for intrinsics setup to support this
        return unsafe.compareAndSwapInt(this,stateOffset,expect, update);
    }

    /**
     * 加锁
     */
    public void lock(){
        //加锁成功
        if (acquire()){
            return;
        }
        Thread currentThread = Thread.currentThread();
        //自旋
        while (true){
            if (acquire()) {
                return;
            }
            //阻塞当前线层
            LockSupport.park(currentThread);
        }
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Thread getLockHolder() {
        return lockHolder;
    }

    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }

    public ConcurrentLinkedQueue<Thread> getWaiters() {
        return waiters;
    }

    public void setWaiters(ConcurrentLinkedQueue<Thread> waiters) {
        this.waiters = waiters;
    }
}
