package enums;

import java.util.Iterator;
import java.util.Random;

public class Mail {

    enum General {/***/ YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannab {/***/ UNSACNABLE, YES1, YES2, YES3, YES4, YES5}

    enum Readable {/***/ ILLEGIBLE, YES1, YES2, YES3, YES4, YES5}

    enum Address {/***/ INCORECT, OK1, OK2, OK3, OK4, OK5}

    enum ReturnAddress {/***/ MISSING, OK1, OK2, OK3, OK4, OK5}

    private General general;
    private Scannab scannab;
    private Readable readable;
    private Address address;
    private ReturnAddress returnAddress;

    public String details() {
        return "Mail{" +
                "general=" + general +
                ", scannab=" + scannab +
                ", readable=" + readable +
                ", address=" + address +
                ", returnAddress=" + returnAddress +
                '}';
    }


    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public Scannab getScannab() {
        return scannab;
    }

    public void setScannab(Scannab scannab) {
        this.scannab = scannab;
    }

    public Readable getReadable() {
        return readable;
    }

    public void setReadable(Readable readable) {
        this.readable = readable;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ReturnAddress getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(ReturnAddress returnAddress) {
        this.returnAddress = returnAddress;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.setAddress(Address.values()[new Random(47).nextInt(Scannab.values().length)]);
        m.setGeneral(General.values()[new Random(50).nextInt(Scannab.values().length)]);
        m.setReadable(Readable.values()[new Random(99).nextInt(Scannab.values().length)]);
        m.setScannab(Scannab.values()[new Random(100).nextInt(Scannab.values().length)]);
        m.setReturnAddress(ReturnAddress.values()[new Random(23).nextInt(Scannab.values().length)]);
        return m;
    }

    public static Iterable<Mail> genertor(int count) {
        return new Iterable<>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

        };
    }

    public static void main(String[] args) {
        int i = new Random(47).nextInt(Address.values().length);
        System.out.println(i);
    }
}
