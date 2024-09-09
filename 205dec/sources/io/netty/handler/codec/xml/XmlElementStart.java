package io.netty.handler.codec.xml;

import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class XmlElementStart extends XmlElement {
    private final List<XmlAttribute> attributes;

    public XmlElementStart(String str, String str2, String str3) {
        super(str, str2, str3);
        this.attributes = new LinkedList();
    }

    public List<XmlAttribute> attributes() {
        return this.attributes;
    }

    @Override // io.netty.handler.codec.xml.XmlElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && super.equals(obj)) {
            List<XmlAttribute> list = this.attributes;
            List<XmlAttribute> list2 = ((XmlElementStart) obj).attributes;
            return list == null ? list2 == null : list.equals(list2);
        }
        return false;
    }

    @Override // io.netty.handler.codec.xml.XmlElement
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        List<XmlAttribute> list = this.attributes;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @Override // io.netty.handler.codec.xml.XmlElement
    public String toString() {
        return "XmlElementStart{attributes=" + this.attributes + super.toString() + "} ";
    }
}
