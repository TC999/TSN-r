package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class XmlElement {
    private final String name;
    private final String namespace;
    private final List<XmlNamespace> namespaces = new LinkedList();
    private final String prefix;

    /* JADX INFO: Access modifiers changed from: protected */
    public XmlElement(String str, String str2, String str3) {
        this.name = str;
        this.namespace = str2;
        this.prefix = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        XmlElement xmlElement = (XmlElement) obj;
        if (this.name.equals(xmlElement.name)) {
            String str = this.namespace;
            if (str == null ? xmlElement.namespace == null : str.equals(xmlElement.namespace)) {
                List<XmlNamespace> list = this.namespaces;
                if (list == null ? xmlElement.namespaces == null : list.equals(xmlElement.namespaces)) {
                    String str2 = this.prefix;
                    String str3 = xmlElement.prefix;
                    return str2 == null ? str3 == null : str2.equals(str3);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.namespace;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.prefix;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<XmlNamespace> list = this.namespaces;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String name() {
        return this.name;
    }

    public String namespace() {
        return this.namespace;
    }

    public List<XmlNamespace> namespaces() {
        return this.namespaces;
    }

    public String prefix() {
        return this.prefix;
    }

    public String toString() {
        return ", name='" + this.name + "', namespace='" + this.namespace + "', prefix='" + this.prefix + "', namespaces=" + this.namespaces;
    }
}
