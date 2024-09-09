package com.bytedance.adsdk.ugeno.component.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.adsdk.ugeno.component.b;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends b<EditText> {
    private int A;
    private String B;
    private int C;
    private String D;
    private String E;

    /* renamed from: d  reason: collision with root package name */
    private int f26183d;

    /* renamed from: e  reason: collision with root package name */
    private int f26184e;

    /* renamed from: l  reason: collision with root package name */
    private float f26185l;

    /* renamed from: o  reason: collision with root package name */
    private String f26186o;

    /* renamed from: v  reason: collision with root package name */
    private int f26187v;

    public a(Context context) {
        super(context);
        this.f26183d = 1;
        this.f26187v = Integer.MAX_VALUE;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int e(String str) {
        char c4;
        switch (str.hashCode()) {
            case -1034364087:
                if (str.equals("number")) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 3556653:
                if (str.equals("text")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 96619420:
                if (str.equals("email")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c4 = 1;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            default:
                c4 = '\uffff';
                break;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    return c4 != 3 ? 1 : 32;
                }
                return 2;
            }
            return 3;
        }
        return 128;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: b */
    public EditText xv() {
        UGEditText uGEditText = new UGEditText(this.f26040w);
        uGEditText.a(this);
        return uGEditText;
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
            case 3202695:
                if (str.equals("hint")) {
                    c4 = 4;
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c4 = 5;
                    break;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    c4 = 6;
                    break;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1706976804:
                if (str.equals("inputType")) {
                    c4 = '\t';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.C = d(str2);
                return;
            case 1:
                this.f26184e = l0.a.a(str2);
                return;
            case 2:
                this.f26186o = str2;
                return;
            case 3:
                this.f26185l = Float.parseFloat(str2);
                return;
            case 4:
                this.E = str2;
                return;
            case 5:
                this.D = str2;
                return;
            case 6:
                this.A = Integer.parseInt(str2);
                return;
            case 7:
                this.f26187v = Integer.parseInt(str2);
                return;
            case '\b':
                this.B = str2;
                return;
            case '\t':
                this.f26183d = e(str2);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((EditText) this.ux).setInputType(this.f26183d);
        ((EditText) this.ux).setText(this.D);
        ((EditText) this.ux).setTextSize(1, this.f26185l);
        ((EditText) this.ux).setTextColor(this.f26184e);
        ((EditText) this.ux).setLines(this.A);
        ((EditText) this.ux).setMaxLines(this.f26187v);
        ((EditText) this.ux).setGravity(this.C);
        ((EditText) this.ux).setHint(this.E);
    }
}
