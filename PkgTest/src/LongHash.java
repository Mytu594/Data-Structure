import java.security.SecureRandom;
import java.util.Random;
 
public class LongHash {
 
    private static long seed = 0xc4ceb9fe1a85ec53L;
    private static Random rand = new SecureRandom();
 
    /**
     * Hash algorithm by Bob Jenkins, 1996.
     *
     * @param k           utils on which hash is computed
     * @param length      utils size
     * @param pc          primary init value
     * @param pb          secondary init value
     * @param is32BitHash true if just 32-bit hash is expected.
     *
     * @return
     */
    private static long hash(byte[] k, int length, int pc, int pb, boolean is32BitHash) {
        int a, b, c;
 
        a = b = c = 0xdeadbeef + length + pc;
        c += pb;
 
        int offset = 0;
        while (length > 12) {
            a += k[offset + 0];
            a += k[offset + 1] << 8;
            a += k[offset + 2] << 16;
            a += k[offset + 3] << 24;
            b += k[offset + 4];
            b += k[offset + 5] << 8;
            b += k[offset + 6] << 16;
            b += k[offset + 7] << 24;
            c += k[offset + 8];
            c += k[offset + 9] << 8;
            c += k[offset + 10] << 16;
            c += k[offset + 11] << 24;
 
            // mix(a, b, c);
            a -= c;
            a ^= rot(c, 4);
            c += b;
            b -= a;
            b ^= rot(a, 6);
            a += c;
            c -= b;
            c ^= rot(b, 8);
            b += a;
            a -= c;
            a ^= rot(c, 16);
            c += b;
            b -= a;
            b ^= rot(a, 19);
            a += c;
            c -= b;
            c ^= rot(b, 4);
            b += a;
 
            length -= 12;
            offset += 12;
        }
 
        switch (length) {
            case 12:
                c += k[offset + 11] << 24;
            case 11:
                c += k[offset + 10] << 16;
            case 10:
                c += k[offset + 9] << 8;
            case 9:
                c += k[offset + 8];
            case 8:
                b += k[offset + 7] << 24;
            case 7:
                b += k[offset + 6] << 16;
            case 6:
                b += k[offset + 5] << 8;
            case 5:
                b += k[offset + 4];
            case 4:
                a += k[offset + 3] << 24;
            case 3:
                a += k[offset + 2] << 16;
            case 2:
                a += k[offset + 1] << 8;
            case 1:
                a += k[offset + 0];
                break;
            case 0:
                return is32BitHash ? c : ((((long) c) << 32)) | ((long) b &0xFFFFFFFFL);
        }
 
        // Final mixing of thrree 32-bit values in to c
        c ^= b;
        c -= rot(b, 14);
        a ^= c;
        a -= rot(c, 11);
        b ^= a;
        b -= rot(a, 25);
        c ^= b;
        c -= rot(b, 16);
        a ^= c;
        a -= rot(c, 4);
        b ^= a;
        b -= rot(a, 14);
        c ^= b;
        c -= rot(b, 24);
 
        return is32BitHash ? c : ((((long) c) << 32)) | ((long) b &0xFFFFFFFFL);
    }
 
    private static long rot(int x, int distance) {
        return (x << distance) | (x >>> (32 - distance));
        // return (x << distance) | (x >>> -distance);
    }
 
    public static long hash(long a, long b){
        byte[] buf = new byte[8*3];
        long _seed = seed;
        for (int i = 7; i >= 0; i--) {
            buf[16 + i] = (byte)(_seed&0xFF);
            _seed >>= 8;
        }
        for (int i = 7; i >= 0; i--) {
            buf[8 + i] = (byte)(a & 0xFF);
            a >>= 8;
        }
        for (int i = 7; i >= 0; i--) {
            buf[i] = (byte)(b & 0xFF);
            b >>= 8;
        }
        return hash(buf, buf.length, 0, 0, false) & Long.MAX_VALUE;
    }
 
    public static long create() {
        return rand.nextLong();
    }
 
    public static void main(String[] args) {
        System.out.println(hash(1, 2));
        System.out.println(hash(2, 1));
        System.out.println(hash(2691843745796435739L, 4372953417481662997L));
        System.out.println(hash(4372953417481662997L, 2691843745796435739L));
    }
}