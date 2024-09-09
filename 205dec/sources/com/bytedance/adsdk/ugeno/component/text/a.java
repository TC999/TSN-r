package com.bytedance.adsdk.ugeno.component.text;

import android.content.Context;
import android.text.TextUtils;
import com.acse.ottn.adapter.AutoScrollViewPager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.adsdk.ugeno.component.b<RichTextView> {
    private int A;
    private String B;
    private int C;

    /* renamed from: d  reason: collision with root package name */
    private String f26214d;

    /* renamed from: e  reason: collision with root package name */
    private int f26215e;

    /* renamed from: l  reason: collision with root package name */
    private float f26216l;

    /* renamed from: o  reason: collision with root package name */
    private String f26217o;

    /* renamed from: v  reason: collision with root package name */
    private int f26218v;

    public a(Context context) {
        super(context);
        this.f26218v = Integer.MAX_VALUE;
        this.C = 2;
    }

    private int d(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4767g)) {
                    c4 = 0;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c4 = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 17;
            case 1:
                return 3;
            case 2:
                return 5;
            default:
                return 2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public RichTextView xv() {
        return new RichTextView(this.f26040w);
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
            case -1065511464:
                if (str.equals("textAlign")) {
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
            case -1048634236:
                if (str.equals("textStyle")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
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
            case 102977279:
                if (str.equals("lines")) {
                    c4 = 5;
                    break;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.C = d(str2);
                return;
            case 1:
                this.f26215e = l0.a.a(str2);
                return;
            case 2:
                this.f26217o = str2;
                return;
            case 3:
                this.f26216l = Float.parseFloat(str2);
                return;
            case 4:
                this.f26214d = str2;
                return;
            case 5:
                this.A = Integer.parseInt(str2);
                return;
            case 6:
                this.f26218v = Integer.parseInt(str2);
                return;
            case 7:
                this.B = str2;
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((RichTextView) this.ux).setRichText(this.f26214d);
        ((RichTextView) this.ux).setTextSize(1, this.f26216l);
        ((RichTextView) this.ux).setTextColor(this.f26215e);
        ((RichTextView) this.ux).setLines(this.A);
        ((RichTextView) this.ux).setMaxLines(this.f26218v);
        ((RichTextView) this.ux).setGravity(this.C);
    }
}
