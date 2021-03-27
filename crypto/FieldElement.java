package crypto;

import java.math.BigInteger;

public class FieldElement {
    private BigInteger prime;
    private BigInteger num;

    public FieldElement(BigInteger prime, BigInteger num) throws Exception {
        if (num.compareTo(BigInteger.ZERO) < 0 || num.compareTo(prime) >= 0)
            throw new Exception("Error: FiniteField num must be in range 0 and " + prime);

        this.prime = prime;
        this.num = num;
    }

    public BigInteger getNum() {
        return this.num;
    }

    public BigInteger getPrime() {
        return this.prime;
    }

    public boolean equals(FieldElement other) {
        return (this.prime.compareTo(other.getPrime()) == 0 && this.num.compareTo(other.getNum()) == 0);
    }

    public FieldElement add(FieldElement other) throws Exception {
        if (this.prime.compareTo(other.getPrime()) != 0)
            throw new Exception("Error: " + this + " and " + other + " cannot be added");
        
        BigInteger newNum = (this.num.add(other.getNum())).mod(this.prime);

        return new FieldElement(this.prime, newNum);
    }

    public FieldElement subtract(FieldElement other) throws Exception {
        if (this.prime.compareTo(other.getPrime()) != 0)
            throw new Exception("Error: " + this + " and " + other + " cannot be subtracted");
        
        BigInteger newNum = (this.num.subtract(other.getNum())).mod(this.prime);

        return new FieldElement(this.prime, newNum);
    }

    public FieldElement multiply(FieldElement other) throws Exception {
        if (this.prime.compareTo(other.getPrime()) != 0)
            throw new Exception("Error: " + this + " and " + other + " cannot be multiplied");

        BigInteger newNum = (this.num.multiply(other.getNum())).mod(this.prime);

        return new FieldElement(this.prime, newNum);
    }

    public FieldElement divide(FieldElement other) throws Exception {
        if (this.prime.compareTo(other.getPrime()) != 0)
            throw new Exception("Error: " + this + " and " + other + " cannot be divided");

        BigInteger newNum = this.num.multiply(other.getNum().modPow(this.prime.subtract(BigInteger.TWO), this.prime)).mod(this.prime);

        return new FieldElement(this.prime, newNum);
    }

    public FieldElement pow(int exp) throws Exception {
        BigInteger n = BigInteger.valueOf(exp).mod(this.prime.subtract(BigInteger.ONE));
        BigInteger newNum = this.num.modPow(n, this.prime);

        return new FieldElement(this.prime, newNum);
    }

    @Override
    public String toString() {
        return "FiniteField_" + this.num + "(" + this.prime + ")";
    }
}