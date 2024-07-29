package bloomFilter;

import java.util.BitSet;

public class BitsetTest {

    //位图是用位来表示数字是否存在，一个字节8位，因此一亿个数如果用位图来存储的话需要 100000000/8 bytes 大约等于12M，如果用Integer来存储的话，一个数需要4个字节，即32位来存储，因此缩小了32倍
    //java的bitsets底层是用long[]来存储的，即一个long8个字节64位，即存储0-63用long[0]来表示，存储64-127用long[1]来表示
    public static void main(String[] args) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);


//        public void set(int bitIndex) {
//            if (bitIndex < 0)
//                throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
//
//            int wordIndex = wordIndex(bitIndex);
//            expandTo(wordIndex);
//
//            words[wordIndex] |= (1L << bitIndex); // Restores invariants
//
//            checkInvariants();
//        }
        //words[wordIndex] |= (1L << bitIndex); 相当于 work[index] |= 2的(bitindex次方)
        //当bitIndex为0 时 words[0] = words[0] |= 2的0次方
        //当bitIndex为1 时 words[1] =

        bits1.set(0);
        System.out.println(bits1);


    }
}
