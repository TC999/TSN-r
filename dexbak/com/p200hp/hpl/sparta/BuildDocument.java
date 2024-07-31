package com.p200hp.hpl.sparta;

/* renamed from: com.hp.hpl.sparta.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class BuildDocument implements DocumentSource, ParseHandler {

    /* renamed from: c */
    private final ParseLog f23845c;

    /* renamed from: d */
    private Element f23846d;

    /* renamed from: e */
    private final Document f23847e;

    /* renamed from: f */
    private InterfaceC7048o f23848f;

    public BuildDocument() {
        this(null);
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    /* renamed from: a */
    public String mo35144a() {
        InterfaceC7048o interfaceC7048o = this.f23848f;
        if (interfaceC7048o != null) {
            return interfaceC7048o.mo35144a();
        }
        return null;
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: b */
    public InterfaceC7048o mo35154b() {
        return this.f23848f;
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: c */
    public void mo35153c() {
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    /* renamed from: d */
    public int mo35143d() {
        InterfaceC7048o interfaceC7048o = this.f23848f;
        if (interfaceC7048o != null) {
            return interfaceC7048o.mo35143d();
        }
        return -1;
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: e */
    public void mo35152e(Element element) {
        this.f23846d = this.f23846d.m35246e();
    }

    @Override // com.p200hp.hpl.sparta.DocumentSource
    /* renamed from: f */
    public Document mo35271f() {
        return this.f23847e;
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: g */
    public void mo35151g() {
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: h */
    public void mo35150h(InterfaceC7048o interfaceC7048o) {
        this.f23848f = interfaceC7048o;
        this.f23847e.m35283D(interfaceC7048o.toString());
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: i */
    public void mo35149i(char[] cArr, int i, int i2) {
        Element element = this.f23846d;
        if (element.m35264G() instanceof Text) {
            ((Text) element.m35264G()).m35107z(cArr, i, i2);
        } else {
            element.m35251y(new Text(new String(cArr, i, i2)));
        }
    }

    @Override // com.p200hp.hpl.sparta.ParseHandler
    /* renamed from: j */
    public void mo35148j(Element element) {
        Element element2 = this.f23846d;
        if (element2 == null) {
            this.f23847e.m35284C(element);
        } else {
            element2.m35252x(element);
        }
        this.f23846d = element;
    }

    @Override // com.p200hp.hpl.sparta.InterfaceC7048o
    public String toString() {
        if (this.f23848f != null) {
            return "BuildDoc: " + this.f23848f.toString();
        }
        return null;
    }

    public BuildDocument(ParseLog parseLog) {
        this.f23846d = null;
        this.f23847e = new Document();
        this.f23848f = null;
        this.f23845c = parseLog == null ? InterfaceC7048o.f23940a : parseLog;
    }
}
