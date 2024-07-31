package javax.mail.search;

import javax.mail.Address;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AddressTerm extends SearchTerm {
    private static final long serialVersionUID = 2005405551929769980L;
    protected Address address;

    /* JADX INFO: Access modifiers changed from: protected */
    public AddressTerm(Address address) {
        this.address = address;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AddressTerm) {
            return ((AddressTerm) obj).address.equals(this.address);
        }
        return false;
    }

    public Address getAddress() {
        return this.address;
    }

    public int hashCode() {
        return this.address.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean match(Address address) {
        return address.equals(this.address);
    }
}
