package javax.mail.internet;

import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Address;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class NewsAddress extends Address {
    private static final long serialVersionUID = -4203797299824684143L;
    protected String host;
    protected String newsgroup;

    public NewsAddress() {
    }

    public static NewsAddress[] parse(String str) throws AddressException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        Vector vector = new Vector();
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(new NewsAddress(stringTokenizer.nextToken()));
        }
        int size = vector.size();
        NewsAddress[] newsAddressArr = new NewsAddress[size];
        if (size > 0) {
            vector.copyInto(newsAddressArr);
        }
        return newsAddressArr;
    }

    @Override // javax.mail.Address
    public boolean equals(Object obj) {
        String str;
        if (obj instanceof NewsAddress) {
            NewsAddress newsAddress = (NewsAddress) obj;
            if (this.newsgroup.equals(newsAddress.newsgroup)) {
                String str2 = this.host;
                if (str2 == null && newsAddress.host == null) {
                    return true;
                }
                if (str2 != null && (str = newsAddress.host) != null && str2.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public String getNewsgroup() {
        return this.newsgroup;
    }

    @Override // javax.mail.Address
    public String getType() {
        return "news";
    }

    public int hashCode() {
        String str = this.newsgroup;
        int hashCode = str != null ? 0 + str.hashCode() : 0;
        String str2 = this.host;
        return str2 != null ? hashCode + str2.toLowerCase(Locale.ENGLISH).hashCode() : hashCode;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setNewsgroup(String str) {
        this.newsgroup = str;
    }

    @Override // javax.mail.Address
    public String toString() {
        return this.newsgroup;
    }

    public NewsAddress(String str) {
        this(str, null);
    }

    public static String toString(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(((NewsAddress) addressArr[0]).toString());
        for (int i = 1; i < addressArr.length; i++) {
            stringBuffer.append(",");
            stringBuffer.append(((NewsAddress) addressArr[i]).toString());
        }
        return stringBuffer.toString();
    }

    public NewsAddress(String str, String str2) {
        this.newsgroup = str;
        this.host = str2;
    }
}
