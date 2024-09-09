package com.bytedance.sdk.openadsdk.core.component.splash.w.c;

import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev extends c {

    /* renamed from: a  reason: collision with root package name */
    private long f33002a;
    private Map<String, String> bk;
    private boolean fp;
    private long fz;
    private com.bytedance.sdk.openadsdk.ys.w.w.w ia;

    /* renamed from: k  reason: collision with root package name */
    private long f33004k;

    /* renamed from: p  reason: collision with root package name */
    private long f33005p;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.component.ev.w f33006r;

    /* renamed from: s  reason: collision with root package name */
    private String f33007s;
    private com.bytedance.sdk.openadsdk.core.q.c.w sr;

    /* renamed from: t  reason: collision with root package name */
    private String f33008t;
    private com.bytedance.sdk.openadsdk.core.q.c.w ux;
    private boolean ys;

    /* renamed from: f  reason: collision with root package name */
    private boolean f33003f = false;
    private boolean ev = false;
    private boolean gd = false;

    /* renamed from: u  reason: collision with root package name */
    private AtomicBoolean f33009u = new AtomicBoolean(false);

    public ev(me meVar, boolean z3) {
        this.f33001w = meVar;
        this.ys = z3;
    }

    public String a() {
        return this.f33008t;
    }

    public boolean bk() {
        return this.ys;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.c.c
    public int c() {
        return this.f33000c;
    }

    public long ev() {
        return this.f33005p;
    }

    public boolean f() {
        return this.f33003f;
    }

    public long fp() {
        return this.fz;
    }

    public long gd() {
        return this.f33002a;
    }

    public boolean ia() {
        return this.f33009u.get();
    }

    public boolean k() {
        return this.gd;
    }

    public Map<String, String> p() {
        return this.bk;
    }

    public boolean r() {
        return this.ev;
    }

    public com.bytedance.sdk.openadsdk.core.q.c.w sr() {
        return this.sr;
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.w t() {
        return this.ia;
    }

    public com.bytedance.sdk.openadsdk.core.q.c.w ux() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.c.c
    public me w() {
        return this.f33001w;
    }

    public void xv(long j4) {
        this.f33004k = j4;
    }

    public String ys() {
        return this.f33007s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.c.c
    public void c(int i4) {
        this.f33000c = i4;
    }

    public void sr(long j4) {
        this.f33002a = j4;
    }

    public void ux(long j4) {
        this.fz = j4;
    }

    public void w(boolean z3) {
        this.ev = z3;
    }

    public void xv(boolean z3) {
        this.gd = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.c.c
    public void c(me meVar) {
        this.f33001w = meVar;
    }

    public void sr(boolean z3) {
        this.fp = z3;
    }

    public void ux(boolean z3) {
        this.f33009u.set(z3);
    }

    public void w(long j4) {
        this.f33005p = j4;
    }

    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar) {
        this.ux = wVar;
    }

    public void w(String str) {
        this.f33007s = str;
    }

    public void c(boolean z3) {
        this.f33003f = z3;
    }

    public void c(com.bytedance.sdk.component.ev.w wVar) {
        this.f33006r = wVar;
    }

    public void c(Map<String, String> map) {
        this.bk = map;
    }

    public ev(com.bytedance.sdk.openadsdk.core.q.c.w wVar, me meVar, boolean z3) {
        this.sr = wVar;
        this.f33001w = meVar;
        this.ys = z3;
    }

    public void c(String str) {
        this.f33008t = str;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        this.ia = wVar;
    }
}
