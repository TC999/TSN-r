package io.netty.handler.codec.xml;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class XmlNamespace {
    private final String prefix;
    private final String uri;

    public XmlNamespace(String str, String str2) {
        this.prefix = str;
        this.uri = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlNamespace xmlNamespace = (XmlNamespace) obj;
        String str = this.prefix;
        if (str == null ? xmlNamespace.prefix == null : str.equals(xmlNamespace.prefix)) {
            String str2 = this.uri;
            String str3 = xmlNamespace.uri;
            return str2 == null ? str3 == null : str2.equals(str3);
        }
        return false;
    }

    public int hashCode() {
        String str = this.prefix;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uri;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String prefix() {
        return this.prefix;
    }

    public String toString() {
        return "XmlNamespace{prefix='" + this.prefix + "', uri='" + this.uri + "'}";
    }

    public String uri() {
        return this.uri;
    }
}
