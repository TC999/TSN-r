package com.p200hp.hpl.sparta.xpath;

import com.p200hp.hpl.sparta.Sparta;

/* renamed from: com.hp.hpl.sparta.xpath.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ElementTest extends NodeTest {

    /* renamed from: a */
    private final String f23970a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ElementTest(String str) {
        this.f23970a = Sparta.m35124a(str);
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTest
    /* renamed from: a */
    public void mo35052a(Visitor visitor) {
        visitor.mo35068h(this);
    }

    @Override // com.p200hp.hpl.sparta.xpath.NodeTest
    /* renamed from: b */
    public boolean mo35051b() {
        return false;
    }

    /* renamed from: c */
    public String m35072c() {
        return this.f23970a;
    }

    public String toString() {
        return this.f23970a;
    }
}
