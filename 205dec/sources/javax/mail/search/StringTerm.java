package javax.mail.search;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class StringTerm extends SearchTerm {
    private static final long serialVersionUID = 1274042129007696269L;
    protected boolean ignoreCase;
    protected String pattern;

    /* JADX INFO: Access modifiers changed from: protected */
    public StringTerm(String str) {
        this.pattern = str;
        this.ignoreCase = true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StringTerm) {
            StringTerm stringTerm = (StringTerm) obj;
            return this.ignoreCase ? stringTerm.pattern.equalsIgnoreCase(this.pattern) && stringTerm.ignoreCase == this.ignoreCase : stringTerm.pattern.equals(this.pattern) && stringTerm.ignoreCase == this.ignoreCase;
        }
        return false;
    }

    public boolean getIgnoreCase() {
        return this.ignoreCase;
    }

    public String getPattern() {
        return this.pattern;
    }

    public int hashCode() {
        return this.ignoreCase ? this.pattern.hashCode() : this.pattern.hashCode() ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean match(String str) {
        int length = str.length() - this.pattern.length();
        for (int i4 = 0; i4 <= length; i4++) {
            boolean z3 = this.ignoreCase;
            String str2 = this.pattern;
            if (str.regionMatches(z3, i4, str2, 0, str2.length())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StringTerm(String str, boolean z3) {
        this.pattern = str;
        this.ignoreCase = z3;
    }
}
