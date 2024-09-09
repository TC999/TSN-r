package com.bytedance.adsdk.ugeno.component.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.component.b;
import l0.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends b<UGProgressBar> {
    private float A;

    /* renamed from: d  reason: collision with root package name */
    private int f26193d;

    /* renamed from: e  reason: collision with root package name */
    private int f26194e;

    /* renamed from: l  reason: collision with root package name */
    private String f26195l;

    /* renamed from: o  reason: collision with root package name */
    private int f26196o;

    /* renamed from: v  reason: collision with root package name */
    private float f26197v;

    public a(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public UGProgressBar xv() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.f26040w);
        uGProgressBar.c(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1295741135:
                if (str.equals("progressBgColor")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c4 = 3;
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c4 = 4;
                    break;
                }
                break;
            case 755159350:
                if (str.equals("progressColor")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f26194e = l0.a.a(str2);
                return;
            case 1:
                this.f26196o = l0.a.a(str2);
                return;
            case 2:
                this.f26197v = l0.b.b(this.f26040w, str2);
                return;
            case 3:
                this.A = i.a(str2, 0.0f);
                return;
            case 4:
                this.f26195l = str2;
                return;
            case 5:
                this.f26193d = l0.a.a(str2);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((UGProgressBar) this.ux).setBackgroundColor(this.f26194e);
        ((UGProgressBar) this.ux).setText(this.f26195l);
        ((UGProgressBar) this.ux).setProgressBgColor(this.f26194e);
        ((UGProgressBar) this.ux).setProgressColor(this.f26193d);
        ((UGProgressBar) this.ux).setTextColor(this.f26196o);
    }
}
