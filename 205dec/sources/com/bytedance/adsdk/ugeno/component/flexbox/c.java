package com.bytedance.adsdk.ugeno.component.flexbox;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.adsdk.ugeno.component.a;
import com.bytedance.adsdk.ugeno.component.flexbox.FlexboxLayout;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.adsdk.ugeno.component.a<FlexboxLayout> {

    /* renamed from: d  reason: collision with root package name */
    private int f26100d;

    /* renamed from: e  reason: collision with root package name */
    private int f26101e;

    /* renamed from: l  reason: collision with root package name */
    private int f26102l;

    /* renamed from: o  reason: collision with root package name */
    private int f26103o;

    /* renamed from: v  reason: collision with root package name */
    private int f26104v;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class a extends a.C0358a {

        /* renamed from: i  reason: collision with root package name */
        public int f26105i = 1;

        /* renamed from: j  reason: collision with root package name */
        public float f26106j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f26107k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public int f26108l = -1;

        /* renamed from: m  reason: collision with root package name */
        public float f26109m = -1.0f;

        /* renamed from: n  reason: collision with root package name */
        public int f26110n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f26111o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f26112p = 16777215;

        /* renamed from: q  reason: collision with root package name */
        public int f26113q = 16777215;

        private int c(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e4) {
                e4.printStackTrace();
                return 1;
            }
        }

        private float d(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e4) {
                e4.printStackTrace();
                return -1.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int e(String str) {
            char c4;
            str.hashCode();
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case -1364013995:
                    if (str.equals(AutoScrollViewPager.f4767g)) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1384876188:
                    if (str.equals("flex_start")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1744442261:
                    if (str.equals("flex_end")) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
            switch (c4) {
                case 0:
                    return 4;
                case 1:
                    return 3;
                case 2:
                    return 2;
                case 3:
                    return 0;
                case 4:
                    return 1;
                default:
                    return -1;
            }
        }

        private float f(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e4) {
                e4.printStackTrace();
                return 0.0f;
            }
        }

        private float h(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e4) {
                e4.printStackTrace();
                return 0.0f;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.component.a.C0358a
        public void b(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.b(context, str, str2);
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -1962496832:
                    if (str.equals("flexBasisPercent")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 106006350:
                    if (str.equals("order")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1031115618:
                    if (str.equals("flexShrink")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1743739820:
                    if (str.equals("flexGrow")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 1767100401:
                    if (str.equals("alignSelf")) {
                        c4 = 4;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    this.f26109m = d(str2);
                    return;
                case 1:
                    this.f26105i = c(str2);
                    return;
                case 2:
                    this.f26107k = h(str2);
                    return;
                case 3:
                    this.f26106j = f(str2);
                    return;
                case 4:
                    this.f26108l = e(str2);
                    return;
                default:
                    return;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.component.a.C0358a
        /* renamed from: g */
        public FlexboxLayout.c a() {
            FlexboxLayout.c cVar = new FlexboxLayout.c((int) this.f26015a, (int) this.f26016b);
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = (int) this.f26018d;
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = (int) this.f26019e;
            ((ViewGroup.MarginLayoutParams) cVar).topMargin = (int) this.f26020f;
            ((ViewGroup.MarginLayoutParams) cVar).bottomMargin = (int) this.f26021g;
            cVar.h(this.f26105i);
            cVar.d(this.f26108l);
            cVar.b(this.f26106j);
            cVar.e(this.f26107k);
            cVar.g(this.f26109m);
            return cVar;
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.f26015a + ", mHeight=" + this.f26016b + ", mMargin=" + this.f26017c + ", mMarginLeft=" + this.f26018d + ", mMarginRight=" + this.f26019e + ", mMarginTop=" + this.f26020f + ", mMarginBottom=" + this.f26021g + ", mParams=" + this.f26022h + ", mOrder=" + this.f26105i + ", mFlexGrow=" + this.f26106j + ", mFlexShrink=" + this.f26107k + ", mAlignSelf=" + this.f26108l + ", mFlexBasisPercent=" + this.f26109m + ", mMinWidth=" + this.f26110n + ", mMinHeight=" + this.f26111o + ", mMaxWidth=" + this.f26112p + ", mMaxHeight=" + this.f26113q + "} " + super.toString();
        }
    }

    public c(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int b(String str) {
        char c4;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4767g)) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c4 = 1;
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
                    return c4 != 3 ? 4 : 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private int d(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int g(String str) {
        char c4;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c4 = 5;
                    break;
                }
                c4 = '\uffff';
                break;
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4767g)) {
                    c4 = 2;
                    break;
                }
                c4 = '\uffff';
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c4 = 3;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c4 = 0;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c4 = 4;
                    break;
                }
                c4 = '\uffff';
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c4 = 1;
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
                    if (c4 != 3) {
                        return c4 != 4 ? 5 : 3;
                    }
                    return 4;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private int h(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(AutoScrollViewPager.f4767g)) {
                    c4 = 0;
                    break;
                }
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 2;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            default:
                return 0;
        }
    }

    private int i(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c4 = 1;
                    break;
                }
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.a
    public a.C0358a c() {
        return new a();
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: e */
    public FlexboxLayout xv() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.f26040w);
        flexboxLayout.k(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.component.a, com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((FlexboxLayout) this.ux).setFlexDirection(this.f26100d);
        ((FlexboxLayout) this.ux).setFlexWrap(this.f26101e);
        ((FlexboxLayout) this.ux).setJustifyContent(this.f26102l);
        ((FlexboxLayout) this.ux).setAlignItems(this.f26103o);
        ((FlexboxLayout) this.ux).setAlignContent(this.f26104v);
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
            case -1063257157:
                if (str.equals("alignItems")) {
                    c4 = 0;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c4 = 1;
                    break;
                }
                break;
            case -752601676:
                if (str.equals("alignContent")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1744216035:
                if (str.equals("flexWrap")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1860657097:
                if (str.equals("justifyContent")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.f26103o = b(str2);
                return;
            case 1:
                this.f26100d = i(str2);
                return;
            case 2:
                this.f26104v = g(str2);
                return;
            case 3:
                this.f26101e = d(str2);
                return;
            case 4:
                this.f26102l = h(str2);
                return;
            default:
                return;
        }
    }
}
