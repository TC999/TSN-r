package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AttrTest extends NodeTest {

    /* renamed from: a */
    private final String f23969a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttrTest(String str) {
        this.f23969a = str;
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTest
    /* renamed from: a */
    public void mo35052a(Visitor visitor) {
        visitor.mo35070b(this);
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTest
    /* renamed from: b */
    public boolean mo35051b() {
        return true;
    }

    /* renamed from: c */
    public String m35083c() {
        return this.f23969a;
    }

    public String toString() {
        return "@" + this.f23969a;
    }
}
