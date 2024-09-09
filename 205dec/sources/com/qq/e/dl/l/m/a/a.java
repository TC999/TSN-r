package com.qq.e.dl.l.m.a;

import com.qq.e.dl.k.g;
import com.qq.e.dl.l.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a extends h {
    private boolean A;

    /* renamed from: w  reason: collision with root package name */
    private int f47236w;

    /* renamed from: x  reason: collision with root package name */
    protected Object f47237x;

    /* renamed from: y  reason: collision with root package name */
    protected int f47238y;

    /* renamed from: z  reason: collision with root package name */
    protected JSONArray f47239z;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f47238y = 0;
        this.A = false;
    }

    protected abstract void a(Object obj);

    protected abstract void a(float[] fArr);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, g gVar) {
        char c4;
        switch (str.hashCode()) {
            case 1816:
                if (str.equals("91")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1817:
            default:
                c4 = '\uffff';
                break;
            case 1818:
                if (str.equals("93")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1819:
                if (str.equals("94")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1820:
                if (str.equals("95")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1821:
                if (str.equals("96")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
        }
        if (c4 == 0) {
            this.f47237x = gVar.c(new JSONObject[0]);
            this.A = true;
        } else if (c4 == 1) {
            int b4 = gVar.b(new JSONObject[0]);
            this.f47236w = b4;
            i(b4);
        } else if (c4 == 2) {
            this.f47238y = gVar.b(new JSONObject[0]);
            this.A = true;
        } else if (c4 == 3) {
            this.f47239z = (JSONArray) gVar.c(new JSONObject[0]);
            this.A = true;
        } else if (c4 != 4) {
            return super.a(str, gVar);
        } else {
            if (gVar.c(new JSONObject[0]) instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) gVar.c(new JSONObject[0]);
                if (jSONArray.length() != 0) {
                    float[] fArr = {(float) jSONArray.optDouble(0, 0.0d), (float) jSONArray.optDouble(1, 0.0d), (float) jSONArray.optDouble(2, 1.0d), (float) jSONArray.optDouble(3, 1.0d)};
                    if (fArr[0] != 1.0f && fArr[1] != 1.0f && fArr[2] != 0.0f && fArr[3] != 0.0f && (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 1.0f || fArr[3] != 1.0f)) {
                        a(fArr);
                    }
                }
            }
        }
        return true;
    }

    protected abstract void i(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        if (this.A) {
            this.A = false;
            a(this.f47237x);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int v() {
        return this.f47236w;
    }
}
