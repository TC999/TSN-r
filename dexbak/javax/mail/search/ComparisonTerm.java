package javax.mail.search;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ComparisonTerm extends SearchTerm {

    /* renamed from: EQ */
    public static final int f40798EQ = 3;

    /* renamed from: GE */
    public static final int f40799GE = 6;

    /* renamed from: GT */
    public static final int f40800GT = 5;

    /* renamed from: LE */
    public static final int f40801LE = 1;

    /* renamed from: LT */
    public static final int f40802LT = 2;

    /* renamed from: NE */
    public static final int f40803NE = 4;
    private static final long serialVersionUID = 1456646953666474308L;
    protected int comparison;

    public boolean equals(Object obj) {
        return (obj instanceof ComparisonTerm) && ((ComparisonTerm) obj).comparison == this.comparison;
    }

    public int hashCode() {
        return this.comparison;
    }
}
