package javax.mail.search;

import javax.mail.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SubjectTerm extends StringTerm {
    private static final long serialVersionUID = 7481568618055573432L;

    public SubjectTerm(String str) {
        super(str);
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof SubjectTerm) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            String subject = message.getSubject();
            if (subject == null) {
                return false;
            }
            return super.match(subject);
        } catch (Exception unused) {
            return false;
        }
    }
}
