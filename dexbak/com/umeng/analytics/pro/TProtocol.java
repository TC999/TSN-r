package com.umeng.analytics.pro;

import java.nio.ByteBuffer;

/* renamed from: com.umeng.analytics.pro.cq */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class TProtocol {

    /* renamed from: g */
    protected TTransport f38043g;

    private TProtocol() {
    }

    /* renamed from: A */
    public abstract ByteBuffer mo14442A() throws TException;

    /* renamed from: B */
    public void mo14441B() {
    }

    /* renamed from: C */
    public TTransport m14440C() {
        return this.f38043g;
    }

    /* renamed from: D */
    public Class<? extends IScheme> mo14394D() {
        return StandardScheme.class;
    }

    /* renamed from: a */
    public abstract void mo14439a() throws TException;

    /* renamed from: a */
    public abstract void mo14438a(byte b) throws TException;

    /* renamed from: a */
    public abstract void mo14437a(double d) throws TException;

    /* renamed from: a */
    public abstract void mo14436a(int i) throws TException;

    /* renamed from: a */
    public abstract void mo14435a(long j) throws TException;

    /* renamed from: a */
    public abstract void mo14434a(TField tField) throws TException;

    /* renamed from: a */
    public abstract void mo14433a(TList tList) throws TException;

    /* renamed from: a */
    public abstract void mo14432a(TMap tMap) throws TException;

    /* renamed from: a */
    public abstract void mo14431a(TMessage tMessage) throws TException;

    /* renamed from: a */
    public abstract void mo14430a(TSet tSet) throws TException;

    /* renamed from: a */
    public abstract void mo14429a(TStruct tStruct) throws TException;

    /* renamed from: a */
    public abstract void mo14428a(String str) throws TException;

    /* renamed from: a */
    public abstract void mo14427a(ByteBuffer byteBuffer) throws TException;

    /* renamed from: a */
    public abstract void mo14426a(short s) throws TException;

    /* renamed from: a */
    public abstract void mo14425a(boolean z) throws TException;

    /* renamed from: b */
    public abstract void mo14424b() throws TException;

    /* renamed from: c */
    public abstract void mo14423c() throws TException;

    /* renamed from: d */
    public abstract void mo14422d() throws TException;

    /* renamed from: e */
    public abstract void mo14421e() throws TException;

    /* renamed from: f */
    public abstract void mo14420f() throws TException;

    /* renamed from: g */
    public abstract void mo14419g() throws TException;

    /* renamed from: h */
    public abstract TMessage mo14418h() throws TException;

    /* renamed from: i */
    public abstract void mo14417i() throws TException;

    /* renamed from: j */
    public abstract TStruct mo14416j() throws TException;

    /* renamed from: k */
    public abstract void mo14415k() throws TException;

    /* renamed from: l */
    public abstract TField mo14414l() throws TException;

    /* renamed from: m */
    public abstract void mo14413m() throws TException;

    /* renamed from: n */
    public abstract TMap mo14412n() throws TException;

    /* renamed from: o */
    public abstract void mo14411o() throws TException;

    /* renamed from: p */
    public abstract TList mo14410p() throws TException;

    /* renamed from: q */
    public abstract void mo14409q() throws TException;

    /* renamed from: r */
    public abstract TSet mo14408r() throws TException;

    /* renamed from: s */
    public abstract void mo14407s() throws TException;

    /* renamed from: t */
    public abstract boolean mo14406t() throws TException;

    /* renamed from: u */
    public abstract byte mo14405u() throws TException;

    /* renamed from: v */
    public abstract short mo14404v() throws TException;

    /* renamed from: w */
    public abstract int mo14403w() throws TException;

    /* renamed from: x */
    public abstract long mo14402x() throws TException;

    /* renamed from: y */
    public abstract double mo14401y() throws TException;

    /* renamed from: z */
    public abstract String mo14400z() throws TException;

    /* JADX INFO: Access modifiers changed from: protected */
    public TProtocol(TTransport tTransport) {
        this.f38043g = tTransport;
    }
}
