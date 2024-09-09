package com.bytedance.adsdk.ugeno.component.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.component.b;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends b<DislikeView> {

    /* renamed from: d  reason: collision with root package name */
    private int f26059d;

    /* renamed from: e  reason: collision with root package name */
    private int f26060e;

    /* renamed from: l  reason: collision with root package name */
    private int f26061l;

    public a(Context context) {
        super(context);
        this.f26059d = 0;
        this.f26061l = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public DislikeView xv() {
        DislikeView dislikeView = new DislikeView(this.f26040w);
        dislikeView.b(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.c(str, str2);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -991792834:
                if (str.equals("dislikeColor")) {
                    c4 = 0;
                    break;
                }
                break;
            case -973508703:
                if (str.equals("dislikeWidth")) {
                    c4 = 1;
                    break;
                }
                break;
            case 95494139:
                if (str.equals("dislikeFillColor")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f26059d = l0.a.a(str2);
                return;
            case 1:
                this.f26060e = (int) l0.b.a(this.f26040w, Integer.parseInt(str2));
                return;
            case 2:
                this.f26061l = l0.a.a(str2);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((DislikeView) this.ux).setRadius(this.f26042y);
        ((DislikeView) this.ux).setStrokeWidth((int) this.yu);
        ((DislikeView) this.ux).setDislikeColor(this.f26059d);
        ((DislikeView) this.ux).setStrokeColor(this.wx);
        ((DislikeView) this.ux).setDislikeWidth(this.f26060e);
        ((DislikeView) this.ux).setBgColor(this.f26061l);
    }
}
