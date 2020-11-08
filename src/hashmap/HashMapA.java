package hashmap;

import java.util.HashMap;

public class HashMapA {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 取余(%)操作中如果除数是 2 的幂次则等价于与其除数减一的与(&)操作（也就是说 hash%length==hash&(length-1)的前提是 length 是 2 的 n 次方；）。” 并且 采用二进制位操作 &，相对于%能够提高运算效率，这就解释了 HashMap 的长度为什么是 2 的幂次方。
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        int size = tableSizeFor(3);

        System.out.println(size);

        int n = 6;

        System.out.println(Integer.toBinaryString(n));

        n|=n>>>1;


        System.out.println(n);

        //Collections
    }
}
