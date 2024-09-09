package com.qq.e.dl.l.j;

import android.view.View;
import com.qq.e.dl.k.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f47179a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47180b;

    /* renamed from: c  reason: collision with root package name */
    private final float f47181c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(JSONArray jSONArray, boolean z3) {
        this.f47180b = z3;
        float f4 = z3 ? -1.0f : 0.0f;
        this.f47181c = f4;
        this.f47179a = new float[]{f4, f4, f4, f4};
        if (jSONArray == null || (r7 = jSONArray.length()) <= 0) {
            return;
        }
        float[] fArr = this.f47179a;
        int length = length > fArr.length ? fArr.length : length;
        for (int i4 = 0; i4 < length; i4++) {
            Object opt = jSONArray.opt(i4);
            if (!JSONObject.NULL.equals(opt)) {
                this.f47179a[i4] = l.c(opt).a(new JSONObject[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        View view2 = (View) view.getParent();
        int width = view2.getWidth() - view.getRight();
        int height = view2.getHeight() - view.getBottom();
        float f4 = this.f47180b ? -2.1474836E9f : -view.getTop();
        float f5 = this.f47180b ? 2.1474836E9f : height;
        float[] fArr = this.f47179a;
        float f6 = fArr[0];
        if (f6 > this.f47181c) {
            f4 = Math.min(0.0f, f6 - view.getTop());
        }
        fArr[0] = f4;
        float[] fArr2 = this.f47179a;
        float f7 = fArr2[1];
        if (f7 > this.f47181c) {
            f5 = Math.max(0.0f, height - f7);
        }
        fArr2[1] = f5;
        float f8 = this.f47180b ? -2.1474836E9f : -view.getLeft();
        float f9 = this.f47180b ? 2.1474836E9f : width;
        float[] fArr3 = this.f47179a;
        float f10 = fArr3[2];
        if (f10 > this.f47181c) {
            f8 = Math.min(0.0f, f10 - view.getLeft());
        }
        fArr3[2] = f8;
        float[] fArr4 = this.f47179a;
        float f11 = fArr4[3];
        if (f11 > this.f47181c) {
            f9 = Math.max(0.0f, width - f11);
        }
        fArr4[3] = f9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f47179a[2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f47179a[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f47179a[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f47179a[3];
    }
}
