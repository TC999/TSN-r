package javax.mail.internet;

import javax.mail.internet.HeaderTokenizer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ContentDisposition {
    private String disposition;
    private ParameterList list;

    public ContentDisposition() {
    }

    public String getDisposition() {
        return this.disposition;
    }

    public String getParameter(String str) {
        ParameterList parameterList = this.list;
        if (parameterList == null) {
            return null;
        }
        return parameterList.get(str);
    }

    public ParameterList getParameterList() {
        return this.list;
    }

    public void setDisposition(String str) {
        this.disposition = str;
    }

    public void setParameter(String str, String str2) {
        if (this.list == null) {
            this.list = new ParameterList();
        }
        this.list.set(str, str2);
    }

    public void setParameterList(ParameterList parameterList) {
        this.list = parameterList;
    }

    public String toString() {
        String str = this.disposition;
        if (str == null) {
            return null;
        }
        if (this.list == null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(this.list.toString(stringBuffer.length() + 21));
        return stringBuffer.toString();
    }

    public ContentDisposition(String str, ParameterList parameterList) {
        this.disposition = str;
        this.list = parameterList;
    }

    public ContentDisposition(String str) throws ParseException {
        HeaderTokenizer headerTokenizer = new HeaderTokenizer(str, "()<>@,;:\\\"\t []/?=");
        HeaderTokenizer.Token next = headerTokenizer.next();
        if (next.getType() == -1) {
            this.disposition = next.getValue();
            String remainder = headerTokenizer.getRemainder();
            if (remainder != null) {
                this.list = new ParameterList(remainder);
                return;
            }
            return;
        }
        throw new ParseException();
    }
}
