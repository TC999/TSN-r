package javax.mail.search;

import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DateTerm extends ComparisonTerm {
    private static final long serialVersionUID = 4818873430063720043L;
    protected Date date;

    /* JADX INFO: Access modifiers changed from: protected */
    public DateTerm(int i4, Date date) {
        this.comparison = i4;
        this.date = date;
    }

    @Override // javax.mail.search.ComparisonTerm
    public boolean equals(Object obj) {
        return (obj instanceof DateTerm) && ((DateTerm) obj).date.equals(this.date) && super.equals(obj);
    }

    public int getComparison() {
        return this.comparison;
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    @Override // javax.mail.search.ComparisonTerm
    public int hashCode() {
        return this.date.hashCode() + super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean match(Date date) {
        switch (this.comparison) {
            case 1:
                return date.before(this.date) || date.equals(this.date);
            case 2:
                return date.before(this.date);
            case 3:
                return date.equals(this.date);
            case 4:
                return !date.equals(this.date);
            case 5:
                return date.after(this.date);
            case 6:
                return date.after(this.date) || date.equals(this.date);
            default:
                return false;
        }
    }
}
