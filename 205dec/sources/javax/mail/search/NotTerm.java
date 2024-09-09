package javax.mail.search;

import javax.mail.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class NotTerm extends SearchTerm {
    private static final long serialVersionUID = 7152293214217310216L;
    protected SearchTerm term;

    public NotTerm(SearchTerm searchTerm) {
        this.term = searchTerm;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NotTerm) {
            return ((NotTerm) obj).term.equals(this.term);
        }
        return false;
    }

    public SearchTerm getTerm() {
        return this.term;
    }

    public int hashCode() {
        return this.term.hashCode() << 1;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        return !this.term.match(message);
    }
}
