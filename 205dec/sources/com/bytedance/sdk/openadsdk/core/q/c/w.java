package com.bytedance.sdk.openadsdk.core.q.c;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.sr;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    int f34497c;
    private List<Object> sr;
    private Map<String, String> ux;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f34498w;
    private Bitmap xv;

    public w(byte[] bArr, int i4) {
        this.xv = null;
        this.sr = null;
        this.ux = null;
        this.f34498w = bArr;
        this.f34497c = i4;
    }

    public Bitmap c() {
        return this.xv;
    }

    public boolean sr() {
        if (this.xv != null) {
            return true;
        }
        byte[] bArr = this.f34498w;
        return bArr != null && bArr.length > 0;
    }

    public boolean ux() {
        byte[] bArr = this.f34498w;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public int w() {
        return this.f34497c;
    }

    public byte[] xv() {
        try {
            if (this.f34498w == null) {
                this.f34498w = sr.w(this.xv);
            }
        } catch (OutOfMemoryError e4) {
            e4.printStackTrace();
        }
        return this.f34498w;
    }

    public w(Bitmap bitmap, int i4) {
        this.f34498w = null;
        this.sr = null;
        this.ux = null;
        this.xv = bitmap;
        this.f34497c = i4;
    }
}
