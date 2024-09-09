package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: Text.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class r extends i {

    /* renamed from: g  reason: collision with root package name */
    private StringBuffer f37428g;

    public r(String str) {
        this.f37428g = new StringBuffer(str);
    }

    public String A() {
        return this.f37428g.toString();
    }

    public void B(String str) {
        this.f37428g = new StringBuffer(str);
        j();
    }

    @Override // com.hp.hpl.sparta.i
    protected int a() {
        return this.f37428g.toString().hashCode();
    }

    @Override // com.hp.hpl.sparta.i
    public Object clone() {
        return new r(this.f37428g.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return this.f37428g.toString().equals(((r) obj).f37428g.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hp.hpl.sparta.i
    public void p(Writer writer) throws IOException {
        writer.write(this.f37428g.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hp.hpl.sparta.i
    public void r(Writer writer) throws IOException {
        String stringBuffer = this.f37428g.toString();
        if (stringBuffer.length() < 50) {
            i.g(writer, stringBuffer);
            return;
        }
        writer.write("<![CDATA[");
        writer.write(stringBuffer);
        writer.write("]]>");
    }

    @Override // com.hp.hpl.sparta.i
    public g s(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration t(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.i
    public String u(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration v(String str) {
        throw new Error("Sorry, not implemented");
    }

    public void x(char c4) {
        this.f37428g.append(c4);
        j();
    }

    public void y(String str) {
        this.f37428g.append(str);
        j();
    }

    public void z(char[] cArr, int i4, int i5) {
        this.f37428g.append(cArr, i4, i5);
        j();
    }

    public r(char c4) {
        StringBuffer stringBuffer = new StringBuffer();
        this.f37428g = stringBuffer;
        stringBuffer.append(c4);
    }
}
