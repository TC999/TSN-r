package com.p200hp.hpl.sparta.xpath;

/* renamed from: com.hp.hpl.sparta.xpath.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface BooleanExprVisitor {
    /* renamed from: a */
    void mo35082a(TrueExpr trueExpr);

    /* renamed from: d */
    void mo35081d(TextNotEqualsExpr textNotEqualsExpr) throws XPathException;

    /* renamed from: e */
    void mo35080e(PositionEqualsExpr positionEqualsExpr) throws XPathException;

    /* renamed from: f */
    void mo35079f(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException;

    /* renamed from: g */
    void mo35078g(TextExistsExpr textExistsExpr) throws XPathException;

    /* renamed from: i */
    void mo35077i(AttrGreaterExpr attrGreaterExpr) throws XPathException;

    /* renamed from: j */
    void mo35076j(AttrEqualsExpr attrEqualsExpr) throws XPathException;

    /* renamed from: m */
    void mo35075m(AttrLessExpr attrLessExpr) throws XPathException;

    /* renamed from: o */
    void mo35074o(AttrExistsExpr attrExistsExpr) throws XPathException;

    /* renamed from: p */
    void mo35073p(TextEqualsExpr textEqualsExpr) throws XPathException;
}
