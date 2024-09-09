package io.netty.handler.codec.xml;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class XmlContent {
    private final String data;

    /* JADX INFO: Access modifiers changed from: protected */
    public XmlContent(String str) {
        this.data = str;
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
        String str = this.data;
        String str2 = ((XmlContent) obj).data;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.data;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "XmlContent{data='" + this.data + "'}";
    }
}
