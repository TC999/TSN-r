package javax.mail.search;

import javax.mail.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class AndTerm extends SearchTerm {
    private static final long serialVersionUID = -3583274505380989582L;
    protected SearchTerm[] terms;

    public AndTerm(SearchTerm searchTerm, SearchTerm searchTerm2) {
        this.terms = r0;
        SearchTerm[] searchTermArr = {searchTerm, searchTerm2};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AndTerm)) {
            return false;
        }
        AndTerm andTerm = (AndTerm) obj;
        if (andTerm.terms.length != this.terms.length) {
            return false;
        }
        int i4 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i4 >= searchTermArr.length) {
                return true;
            }
            if (!searchTermArr[i4].equals(andTerm.terms[i4])) {
                return false;
            }
            i4++;
        }
    }

    public SearchTerm[] getTerms() {
        return (SearchTerm[]) this.terms.clone();
    }

    public int hashCode() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i4 >= searchTermArr.length) {
                return i5;
            }
            i5 += searchTermArr[i4].hashCode();
            i4++;
        }
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        int i4 = 0;
        while (true) {
            SearchTerm[] searchTermArr = this.terms;
            if (i4 >= searchTermArr.length) {
                return true;
            }
            if (!searchTermArr[i4].match(message)) {
                return false;
            }
            i4++;
        }
    }

    public AndTerm(SearchTerm[] searchTermArr) {
        this.terms = new SearchTerm[searchTermArr.length];
        for (int i4 = 0; i4 < searchTermArr.length; i4++) {
            this.terms[i4] = searchTermArr[i4];
        }
    }
}
