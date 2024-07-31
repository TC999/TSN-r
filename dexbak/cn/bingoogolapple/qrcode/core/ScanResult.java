package cn.bingoogolapple.qrcode.core;

import android.graphics.PointF;

/* renamed from: cn.bingoogolapple.qrcode.core.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ScanResult {

    /* renamed from: a */
    String f1628a;

    /* renamed from: b */
    PointF[] f1629b;

    public ScanResult(String str) {
        this.f1628a = str;
    }

    public ScanResult(String str, PointF[] pointFArr) {
        this.f1628a = str;
        this.f1629b = pointFArr;
    }
}
