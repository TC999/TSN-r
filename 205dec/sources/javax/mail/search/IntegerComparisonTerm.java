package javax.mail.search;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class IntegerComparisonTerm extends ComparisonTerm {
    private static final long serialVersionUID = -6963571240154302484L;
    protected int number;

    /* JADX INFO: Access modifiers changed from: protected */
    public IntegerComparisonTerm(int i4, int i5) {
        this.comparison = i4;
        this.number = i5;
    }

    @Override // javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        return (obj instanceof IntegerComparisonTerm) && ((IntegerComparisonTerm) obj).number == this.number && super.equals(obj);
    }

    public int getComparison() {
        return this.comparison;
    }

    public int getNumber() {
        return this.number;
    }

    @Override // javax.mail.search.ComparisonTerm
    public int hashCode() {
        return this.number + super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean match(int i4) {
        switch (this.comparison) {
            case 1:
                return i4 <= this.number;
            case 2:
                return i4 < this.number;
            case 3:
                return i4 == this.number;
            case 4:
                return i4 != this.number;
            case 5:
                return i4 > this.number;
            case 6:
                return i4 >= this.number;
            default:
                return false;
        }
    }
}
