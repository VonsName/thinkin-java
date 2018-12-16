package io;

public class User {
    private float f;
    private double d;

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "User{" +
                "f=" + f +
                ", d=" + d +
                '}';
    }
}
