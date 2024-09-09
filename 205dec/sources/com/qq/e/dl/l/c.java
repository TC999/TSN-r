package com.qq.e.dl.l;

import com.qq.e.dl.k.i;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private i f47056a;

    /* renamed from: b  reason: collision with root package name */
    private i f47057b;

    /* renamed from: c  reason: collision with root package name */
    private i f47058c;

    /* renamed from: d  reason: collision with root package name */
    private i f47059d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f47060e;

    /* renamed from: f  reason: collision with root package name */
    private int f47061f;

    /* renamed from: g  reason: collision with root package name */
    private int f47062g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f47063h;

    public final boolean a(int i4, int i5) {
        this.f47062g = i5;
        this.f47061f = i4;
        return this.f47063h;
    }

    public int b() {
        i iVar = this.f47059d;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47061f, this.f47062g);
    }

    public int c() {
        i iVar = this.f47056a;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47061f, this.f47062g);
    }

    public int d() {
        i iVar = this.f47057b;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47061f, this.f47062g);
    }

    public int e() {
        i iVar = this.f47058c;
        if (iVar == null) {
            return 0;
        }
        return iVar.a(this.f47061f, this.f47062g);
    }

    public boolean f() {
        return this.f47060e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        boolean z3 = false;
        if (hashCode != 57) {
            switch (hashCode) {
                case 1567:
                    if (str.equals("10")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1568:
                    if (str.equals("11")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1569:
                    if (str.equals("12")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
        } else {
            if (str.equals("9")) {
                c4 = 0;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            i f4 = gVar.f(new JSONObject[0]);
            this.f47056a = f4;
            this.f47063h = (this.f47063h || f4.c()) ? true : true;
        } else if (c4 == 1) {
            i f5 = gVar.f(new JSONObject[0]);
            this.f47057b = f5;
            this.f47063h = (this.f47063h || f5.c()) ? true : true;
        } else if (c4 == 2) {
            i f6 = gVar.f(new JSONObject[0]);
            this.f47058c = f6;
            this.f47063h = (this.f47063h || f6.c()) ? true : true;
        } else if (c4 != 3) {
            return false;
        } else {
            i f7 = gVar.f(new JSONObject[0]);
            this.f47059d = f7;
            this.f47063h = (this.f47063h || f7.c()) ? true : true;
        }
        this.f47060e = true;
        return true;
    }

    public void a() {
        this.f47060e = false;
    }
}
