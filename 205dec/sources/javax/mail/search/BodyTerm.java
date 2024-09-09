package javax.mail.search;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BodyTerm extends StringTerm {
    private static final long serialVersionUID = -4888862527916911385L;

    public BodyTerm(String str) {
        super(str);
    }

    private boolean matchPart(Part part) {
        if (part.isMimeType("text/*")) {
            String str = (String) part.getContent();
            if (str == null) {
                return false;
            }
            return super.match(str);
        }
        if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int count = multipart.getCount();
            for (int i4 = 0; i4 < count; i4++) {
                if (matchPart(multipart.getBodyPart(i4))) {
                    return true;
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            return matchPart((Part) part.getContent());
        }
        return false;
    }

    @Override // javax.mail.search.StringTerm
    public boolean equals(Object obj) {
        if (obj instanceof BodyTerm) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        return matchPart(message);
    }
}
