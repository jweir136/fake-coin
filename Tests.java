import crypto.FieldElement;

import java.math.BigInteger;

public class Tests {
    public static void fieldElementInitTest1() throws Exception {
        FieldElement f = new FieldElement(BigInteger.valueOf(24), BigInteger.valueOf(10));
        System.out.println("\tfieldElementInitTest1() - passed");
    }
    public static void fieldElementInitTest2() throws Exception {
        try {
            FieldElement f = new FieldElement(BigInteger.valueOf(10), BigInteger.valueOf(100));
        } catch (Exception err) {
            System.out.println("\tfieldElementInitTest2() - passed");
        }
    }

    public static void fieldElementEqTest() throws Exception {
        FieldElement x = new FieldElement(BigInteger.valueOf(24), BigInteger.valueOf(10));
        FieldElement y = new FieldElement(BigInteger.valueOf(24), BigInteger.valueOf(10));
        FieldElement z = new FieldElement(BigInteger.valueOf(11), BigInteger.valueOf(10));

        if (x.equals(y) && !x.equals(z))
            System.out.println("\tfieldElementEqTest() - passed");
        else   
            throw new Exception("\tfieldElementEqTest() - failed");
    }

    public static void fieldElementAddTest() throws Exception {
        FieldElement a = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(7));
        FieldElement b = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(12));
        FieldElement c = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(6));

        if (a.add(b).equals(c))
            System.out.println("\tfieldElementAddTest() - passed");
        else
            throw new Exception("\tfieldElementAddTest() - failed");
    }

    public static void fieldElementSubtractTest() throws Exception {
        FieldElement a = new FieldElement(new BigInteger("732875670306"), new BigInteger("7865681629"));
        FieldElement b = new FieldElement(new BigInteger("732875670306"), new BigInteger("362504994319"));
        FieldElement c = new FieldElement(new BigInteger("732875670306"), new BigInteger("378236357616"));

        if (a.subtract(b).equals(c))
            System.out.println("\tfieldElementSubtractTest() - passed");
        else   
            throw new Exception("\tfieldElementSubtractTest() - failed");
    }

    public static void fieldElementMultTest() throws Exception {
        FieldElement a = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(3));
        FieldElement b = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(12));
        FieldElement c = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(10));

        if (a.multiply(b).equals(c))
            System.out.println("\tfieldElementMultTest() - passed");
        else
            throw new Exception("\tfieldElementMultTest() - failed");
    }

    public static void fieldElementDivTest() throws Exception {
        FieldElement a = new FieldElement(new BigInteger("281992282315"), new BigInteger("43487556543"));
        FieldElement b = new FieldElement(new BigInteger("281992282315"), new BigInteger("119252362870"));
        FieldElement c = new FieldElement(new BigInteger("281992282315"), new BigInteger("271694051130"));

        if (a.divide(b).equals(c))
            System.out.println("\tfieldElementDivTest() - passed");
        else
            throw new Exception("\tfieldElementDivTest() - failed");
    }

    public static void fieldElementPowTest() throws Exception {
        FieldElement a = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(7));
        FieldElement b = new FieldElement(BigInteger.valueOf(13), BigInteger.valueOf(8));

        if (a.pow(-3).equals(b))
            System.out.println("\tfieldElementPowTest() - passed");
        else
            System.out.println("\tfieldElementPowTest() - failed");
    }
    public static void main(String[] args) throws Exception {
        fieldElementInitTest1();
        fieldElementInitTest2();
        fieldElementEqTest();
        fieldElementAddTest();
        fieldElementSubtractTest();
        fieldElementMultTest();
        fieldElementDivTest();
        fieldElementPowTest();
    }
}
