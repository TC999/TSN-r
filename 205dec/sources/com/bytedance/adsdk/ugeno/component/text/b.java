package com.bytedance.adsdk.ugeno.component.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import l0.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends com.bytedance.adsdk.ugeno.component.b<TextView> {
    private int A;
    private int B;
    private int C;
    private TextUtils.TruncateAt D;
    private float E;
    private float F;
    private int G;
    private float H;
    private float I;
    private float J;

    /* renamed from: d  reason: collision with root package name */
    private String f26219d;

    /* renamed from: e  reason: collision with root package name */
    private int f26220e;

    /* renamed from: l  reason: collision with root package name */
    private float f26221l;

    /* renamed from: o  reason: collision with root package name */
    private int f26222o;

    /* renamed from: v  reason: collision with root package name */
    private int f26223v;

    public b(Context context) {
        super(context);
        this.f26223v = Integer.MAX_VALUE;
        this.B = 2;
        this.E = -1.0f;
        this.F = -1.0f;
    }

    private int e(String str) {
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

    private TextUtils.TruncateAt g(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4767g)) {
                    c4 = 0;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c4 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_START)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.D = TextUtils.TruncateAt.MIDDLE;
                break;
            case 1:
                this.D = TextUtils.TruncateAt.END;
                break;
            case 2:
                this.D = TextUtils.TruncateAt.START;
                break;
            default:
                this.D = null;
                break;
        }
        return this.D;
    }

    private int h(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1026963764:
                if (str.equals("underline")) {
                    c4 = 0;
                    break;
                }
                break;
            case -972521773:
                if (str.equals("strikethrough")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 8;
            case 1:
                return 16;
            case 2:
            default:
                return Integer.MAX_VALUE;
        }
    }

    private int i(String str) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode == -1178781136) {
            if (str.equals("italic")) {
                c4 = 1;
            }
            c4 = '\uffff';
        } else if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c4 = 0;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("normal")) {
                c4 = 2;
            }
            c4 = '\uffff';
        }
        if (c4 != 0) {
            return c4 != 1 ? 0 : 2;
        }
        return 1;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public TextView xv() {
        UGTextView uGTextView = new UGTextView(this.f26040w);
        uGTextView.a(this);
        return uGTextView;
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
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    c4 = 4;
                    break;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    c4 = 5;
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c4 = 6;
                    break;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    c4 = 7;
                    break;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    c4 = '\b';
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c4 = '\t';
                    break;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c4 = 11;
                    break;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    c4 = '\r';
                    break;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    c4 = 14;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.J = i.a(str2, 0.0f);
                return;
            case 1:
                this.G = l0.a.a(str2);
                return;
            case 2:
                this.B = e(str2);
                return;
            case 3:
                this.f26220e = l0.a.a(str2);
                return;
            case 4:
                this.f26222o = i(str2);
                return;
            case 5:
                this.f26221l = i.a(str2, 0.0f);
                return;
            case 6:
                this.C = h(str2);
                return;
            case 7:
                this.H = i.a(str2, 0.0f);
                return;
            case '\b':
                this.I = i.a(str2, 0.0f);
                return;
            case '\t':
                this.F = i.a(str2, -1.0f);
                return;
            case '\n':
                this.E = i.a(str2, 1.0f);
                return;
            case 11:
                this.f26219d = str2;
                return;
            case '\f':
                this.A = i.b(str2, 0);
                return;
            case '\r':
                this.f26223v = Integer.parseInt(str2);
                return;
            case 14:
                this.D = g(str2);
                return;
            default:
                return;
        }
    }

    public void d(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((TextView) this.ux).setEllipsize(truncateAt);
    }

    public void j(String str) {
        this.f26219d = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.f26219d = "";
        }
        ((TextView) this.ux).setText(this.f26219d);
    }

    public void l(int i4) {
        this.C = i4;
        if (i4 == Integer.MAX_VALUE) {
            return;
        }
        ((TextView) this.ux).setPaintFlags(i4);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        if (TextUtils.equals("null", this.f26219d)) {
            this.f26219d = "";
        }
        j(this.f26219d);
        ((TextView) this.ux).setTextSize(1, this.f26221l);
        ((TextView) this.ux).setTextColor(this.f26220e);
        ((TextView) this.ux).setLines(this.A);
        ((TextView) this.ux).setMaxLines(this.f26223v);
        ((TextView) this.ux).setGravity(this.B);
        ((TextView) this.ux).setIncludeFontPadding(false);
        l(this.C);
        d(this.D);
        ((TextView) this.ux).setTypeface(Typeface.DEFAULT, this.f26222o);
        if (Build.VERSION.SDK_INT >= 28) {
            float f4 = this.E;
            if (f4 >= 0.0f) {
                ((TextView) this.ux).setLineSpacing(0.0f, f4);
            }
        }
        ((TextView) this.ux).setShadowLayer(this.J, this.H, this.I, this.G);
    }
}
