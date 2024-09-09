package com.bytedance.msdk.core.w;

import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private final String f28281c;

    /* renamed from: w  reason: collision with root package name */
    private final float[] f28282w;
    private final int[] xv;

    public ux(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.f28281c = str;
        this.f28282w = new float[jSONArray.length()];
        this.xv = new int[jSONArray2.length()];
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            this.f28282w[i4] = (float) jSONArray.optDouble(i4);
        }
        for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
            this.xv[i5] = jSONArray2.optInt(i5);
        }
    }

    public int c(float f4) {
        int[] iArr;
        int i4;
        float[] fArr = this.f28282w;
        int i5 = -1;
        if (fArr == null || fArr.length == 0 || (iArr = this.xv) == null || iArr.length == 0) {
            return -1;
        }
        int length = fArr.length;
        int i6 = 0;
        while (i6 < length) {
            float[] fArr2 = this.f28282w;
            if (f4 > fArr2[i6] && (i4 = i6 + 1) < length && f4 <= fArr2[i4]) {
                int[] iArr2 = this.xv;
                return i6 < iArr2.length ? iArr2[i6] : i5;
            }
            if (i6 == length - 1 && f4 > fArr2[i6]) {
                i5 = this.xv[i6];
            }
            i6++;
        }
        return i5;
    }
}
