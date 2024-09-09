package com.bytedance.sdk.openadsdk.core.u;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.w.sr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    private View bk;
    private String fz;
    private String ia;

    /* renamed from: q  reason: collision with root package name */
    private String f34686q;

    /* renamed from: t  reason: collision with root package name */
    private View f34689t;
    private boolean ys;

    /* renamed from: c  reason: collision with root package name */
    private float f34681c = -1.0f;

    /* renamed from: w  reason: collision with root package name */
    private float f34691w = -1.0f;
    private float xv = -1.0f;
    private float sr = -1.0f;
    private long ux = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f34682f = -1;

    /* renamed from: r  reason: collision with root package name */
    private int f34687r = -1;
    private int ev = -1;
    private int gd = -1024;

    /* renamed from: p  reason: collision with root package name */
    private boolean f34685p = true;

    /* renamed from: k  reason: collision with root package name */
    private int f34684k = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f34680a = 0;
    private boolean fp = false;

    /* renamed from: s  reason: collision with root package name */
    private int f34688s = -1;

    /* renamed from: u  reason: collision with root package name */
    private SparseArray<sr.c> f34690u = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    private List<Integer> f34683i = new ArrayList();

    public long a() {
        return this.f34682f;
    }

    public float bk() {
        return this.f34681c;
    }

    public int c() {
        return this.f34687r;
    }

    public int ev() {
        return this.f34680a;
    }

    public View f() {
        return this.f34689t;
    }

    public float fp() {
        return this.sr;
    }

    public String fz() {
        return this.fz;
    }

    public SparseArray<sr.c> gd() {
        return this.f34690u;
    }

    public String i() {
        return this.f34686q;
    }

    public String ia() {
        return this.ia;
    }

    public long k() {
        return this.ux;
    }

    public List<Integer> p() {
        return this.f34683i;
    }

    public int r() {
        return this.f34684k;
    }

    public int s() {
        return this.f34688s;
    }

    public boolean sr() {
        return this.f34685p;
    }

    public float t() {
        return this.f34691w;
    }

    public boolean u() {
        return this.fp;
    }

    public View ux() {
        return this.bk;
    }

    public int w() {
        return this.ev;
    }

    public int xv() {
        return this.gd;
    }

    public float ys() {
        return this.xv;
    }

    public void c(int i4) {
        this.f34687r = i4;
    }

    public void f(int i4) {
        this.f34688s = i4;
    }

    public void sr(int i4) {
        this.f34684k = i4;
    }

    public void ux(int i4) {
        this.f34680a = i4;
    }

    public void w(int i4) {
        this.ev = i4;
    }

    public void xv(int i4) {
        this.gd = i4;
    }

    public void c(boolean z3) {
        this.f34685p = z3;
    }

    public void sr(float f4) {
        this.sr = f4;
    }

    public void w(View view) {
        this.f34689t = (View) new WeakReference(view).get();
    }

    public void xv(float f4) {
        this.xv = f4;
    }

    public void c(View view) {
        this.bk = (View) new WeakReference(view).get();
    }

    public void w(long j4) {
        this.f34682f = j4;
    }

    public void xv(boolean z3) {
        this.fp = z3;
    }

    public void c(SparseArray<sr.c> sparseArray) {
        this.f34690u = sparseArray;
    }

    public void w(float f4) {
        this.f34691w = f4;
    }

    public void xv(String str) {
        this.f34686q = str;
    }

    public void c(long j4) {
        this.ux = j4;
    }

    public void w(boolean z3) {
        this.ys = z3;
    }

    public void c(float f4) {
        this.f34681c = f4;
    }

    public void w(String str) {
        this.fz = str;
    }

    public void c(String str) {
        this.ia = str;
    }
}
