package com.p200hp.hpl.sparta;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/* renamed from: com.hp.hpl.sparta.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Text extends Node {

    /* renamed from: g */
    private StringBuffer f23945g;

    public Text(String str) {
        this.f23945g = new StringBuffer(str);
    }

    /* renamed from: A */
    public String m35118A() {
        return this.f23945g.toString();
    }

    /* renamed from: B */
    public void m35117B(String str) {
        this.f23945g = new StringBuffer(str);
        mo35241j();
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: a */
    protected int mo35116a() {
        return this.f23945g.toString().hashCode();
    }

    @Override // com.p200hp.hpl.sparta.Node
    public Object clone() {
        return new Text(this.f23945g.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Text) {
            return this.f23945g.toString().equals(((Text) obj).f23945g.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: p */
    public void mo35115p(Writer writer) throws IOException {
        writer.write(this.f23945g.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: r */
    public void mo35114r(Writer writer) throws IOException {
        String stringBuffer = this.f23945g.toString();
        if (stringBuffer.length() < 50) {
            Node.m35244g(writer, stringBuffer);
            return;
        }
        writer.write("<![CDATA[");
        writer.write(stringBuffer);
        writer.write("]]>");
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: s */
    public Element mo35113s(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: t */
    public Enumeration mo35112t(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: u */
    public String mo35111u(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.p200hp.hpl.sparta.Node
    /* renamed from: v */
    public Enumeration mo35110v(String str) {
        throw new Error("Sorry, not implemented");
    }

    /* renamed from: x */
    public void m35109x(char c) {
        this.f23945g.append(c);
        mo35241j();
    }

    /* renamed from: y */
    public void m35108y(String str) {
        this.f23945g.append(str);
        mo35241j();
    }

    /* renamed from: z */
    public void m35107z(char[] cArr, int i, int i2) {
        this.f23945g.append(cArr, i, i2);
        mo35241j();
    }

    public Text(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        this.f23945g = stringBuffer;
        stringBuffer.append(c);
    }
}
