package io.netty.handler.codec.xml;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class XmlProcessingInstruction {
    private final String data;
    private final String target;

    public XmlProcessingInstruction(String str, String str2) {
        this.data = str;
        this.target = str2;
    }

    public String data() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlProcessingInstruction xmlProcessingInstruction = (XmlProcessingInstruction) obj;
        String str = this.data;
        if (str == null ? xmlProcessingInstruction.data == null : str.equals(xmlProcessingInstruction.data)) {
            String str2 = this.target;
            String str3 = xmlProcessingInstruction.target;
            return str2 == null ? str3 == null : str2.equals(str3);
        }
        return false;
    }

    public int hashCode() {
        String str = this.data;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.target;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String target() {
        return this.target;
    }

    public String toString() {
        return "XmlProcessingInstruction{data='" + this.data + "', target='" + this.target + "'}";
    }
}
