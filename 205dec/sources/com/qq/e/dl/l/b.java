package com.qq.e.dl.l;

import com.qq.e.dl.k.i;
import com.qq.e.dl.k.n;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private float f47040a;

    /* renamed from: b  reason: collision with root package name */
    private i f47041b;

    /* renamed from: c  reason: collision with root package name */
    private i f47042c;

    /* renamed from: d  reason: collision with root package name */
    private i f47043d;

    /* renamed from: e  reason: collision with root package name */
    private i f47044e;

    /* renamed from: f  reason: collision with root package name */
    private i f47045f;

    /* renamed from: g  reason: collision with root package name */
    private i f47046g;

    /* renamed from: h  reason: collision with root package name */
    private int f47047h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f47048i;

    /* renamed from: j  reason: collision with root package name */
    private int f47049j;

    /* renamed from: k  reason: collision with root package name */
    private int f47050k;

    /* renamed from: l  reason: collision with root package name */
    private int f47051l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f47052m;

    /* renamed from: n  reason: collision with root package name */
    private int f47053n;

    /* renamed from: o  reason: collision with root package name */
    private int f47054o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f47055p;

    public final boolean a(int i4, int i5) {
        this.f47054o = i5;
        this.f47053n = i4;
        return this.f47055p;
    }

    public final float b() {
        return this.f47040a;
    }

    public final int c() {
        return this.f47047h;
    }

    public final int d() {
        return a(this.f47042c);
    }

    public final int e() {
        i iVar = this.f47046g;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47053n, this.f47054o);
    }

    public final int f() {
        i iVar = this.f47043d;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47053n, this.f47054o);
    }

    public final int g() {
        i iVar = this.f47044e;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47053n, this.f47054o);
    }

    public final int h() {
        i iVar = this.f47045f;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47053n, this.f47054o);
    }

    public final int i() {
        return this.f47051l;
    }

    public final int j() {
        return this.f47049j;
    }

    public final int k() {
        return this.f47050k;
    }

    public final int l() {
        return this.f47048i;
    }

    public int m() {
        return this.f47054o;
    }

    public int n() {
        return this.f47053n;
    }

    public final int o() {
        return a(this.f47041b);
    }

    public final boolean p() {
        return this.f47052m;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        boolean z3 = false;
        if (hashCode == 1570) {
            if (str.equals("13")) {
                c4 = 6;
            }
            c4 = '\uffff';
        } else if (hashCode != 1666) {
            switch (hashCode) {
                case 51:
                    if (str.equals("3")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 52:
                    if (str.equals("4")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 53:
                    if (str.equals("5")) {
                        c4 = 5;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 54:
                    if (str.equals("6")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 55:
                    if (str.equals("7")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 56:
                    if (str.equals("8")) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    switch (hashCode) {
                        case 1759:
                            if (str.equals("76")) {
                                c4 = '\b';
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        case 1760:
                            if (str.equals("77")) {
                                c4 = '\t';
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        case 1761:
                            if (str.equals("78")) {
                                c4 = '\n';
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        case 1762:
                            if (str.equals("79")) {
                                c4 = 11;
                                break;
                            }
                            c4 = '\uffff';
                            break;
                        default:
                            c4 = '\uffff';
                            break;
                    }
            }
        } else {
            if (str.equals("46")) {
                c4 = 7;
            }
            c4 = '\uffff';
        }
        switch (c4) {
            case 0:
                i f4 = gVar.f(new JSONObject[0]);
                this.f47041b = f4;
                this.f47055p = (this.f47055p || f4.c()) ? true : true;
                break;
            case 1:
                i f5 = gVar.f(new JSONObject[0]);
                this.f47042c = f5;
                this.f47055p = (this.f47055p || f5.c()) ? true : true;
                break;
            case 2:
                i f6 = gVar.f(new JSONObject[0]);
                this.f47045f = f6;
                this.f47055p = (this.f47055p || f6.c()) ? true : true;
                break;
            case 3:
                i f7 = gVar.f(new JSONObject[0]);
                this.f47044e = f7;
                this.f47055p = (this.f47055p || f7.c()) ? true : true;
                break;
            case 4:
                i f8 = gVar.f(new JSONObject[0]);
                this.f47046g = f8;
                this.f47055p = (this.f47055p || f8.c()) ? true : true;
                break;
            case 5:
                i f9 = gVar.f(new JSONObject[0]);
                this.f47043d = f9;
                this.f47055p = (this.f47055p || f9.c()) ? true : true;
                break;
            case 6:
                this.f47047h = n.b(gVar);
                break;
            case 7:
                this.f47040a = gVar.d(new JSONObject[0]);
                break;
            case '\b':
                this.f47048i = gVar.a(new JSONObject[0]);
                break;
            case '\t':
                this.f47049j = gVar.a(new JSONObject[0]);
                break;
            case '\n':
                this.f47050k = gVar.a(new JSONObject[0]);
                break;
            case 11:
                this.f47051l = gVar.a(new JSONObject[0]);
                break;
            default:
                return false;
        }
        this.f47052m = true;
        return true;
    }

    private int a(i iVar) {
        if (iVar == null) {
            return 0;
        }
        int b4 = (int) iVar.b();
        if (b4 < 0) {
            if (b4 == -1 || b4 == -2) {
                return b4;
            }
            return 0;
        }
        int a4 = iVar.a(this.f47053n, this.f47054o);
        if (a4 < 0) {
            return 0;
        }
        return a4;
    }

    public final void a() {
        this.f47052m = false;
    }
}
