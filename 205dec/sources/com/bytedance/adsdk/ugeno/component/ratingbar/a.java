package com.bytedance.adsdk.ugeno.component.ratingbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.component.b;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends b<UGRatingBar> {

    /* renamed from: d  reason: collision with root package name */
    private int f26208d;

    /* renamed from: e  reason: collision with root package name */
    private int f26209e;

    /* renamed from: l  reason: collision with root package name */
    private float f26210l;

    /* renamed from: o  reason: collision with root package name */
    private int f26211o;

    public a(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public UGRatingBar xv() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.f26040w);
        uGRatingBar.b(this);
        return uGRatingBar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1810866385:
                if (str.equals("highLightColor")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1804390815:
                if (str.equals("lowLightColor")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c4 = 2;
                    break;
                }
                break;
            case 109264530:
                if (str.equals("score")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f26208d = l0.a.a(str2);
                return;
            case 1:
                this.f26209e = l0.a.a(str2);
                return;
            case 2:
                try {
                    this.f26211o = Integer.parseInt(str2);
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            case 3:
                try {
                    this.f26210l = Float.parseFloat(str2);
                    return;
                } catch (NumberFormatException unused2) {
                    this.f26210l = 5.0f;
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((UGRatingBar) this.ux).a(this.f26210l, this.f26208d, this.f26211o, 5);
    }
}
