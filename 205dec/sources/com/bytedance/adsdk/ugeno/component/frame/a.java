package com.bytedance.adsdk.ugeno.component.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.bytedance.adsdk.ugeno.component.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.adsdk.ugeno.component.a<UGFrameLayout> {

    /* renamed from: d  reason: collision with root package name */
    private UGFrameLayout f26134d;

    /* renamed from: com.bytedance.adsdk.ugeno.component.frame.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0361a extends a.C0358a {

        /* renamed from: i  reason: collision with root package name */
        protected int f26135i = -1;

        private int c(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split("\\|")) == null || split.length <= 0) {
                return -1;
            }
            int i4 = 0;
            for (String str2 : split) {
                i4 |= d(str2);
            }
            return i4;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int d(String str) {
            char c4;
            str.hashCode();
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals("bottom")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case -1364013995:
                    if (str.equals(AutoScrollViewPager.f4767g)) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case -348726240:
                    if (str.equals("center_vertical")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c4 = 4;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c4 = 5;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1063616078:
                    if (str.equals("center_horizontal")) {
                        c4 = 6;
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
                    return 80;
                case 1:
                    return 17;
                case 2:
                    return 16;
                case 3:
                    return 48;
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.component.a.C0358a
        public void b(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.b(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.f26135i = c(str2);
            }
        }

        @Override // com.bytedance.adsdk.ugeno.component.a.C0358a
        /* renamed from: e */
        public FrameLayout.LayoutParams a() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f26015a, (int) this.f26016b);
            layoutParams.leftMargin = (int) this.f26018d;
            layoutParams.rightMargin = (int) this.f26019e;
            layoutParams.topMargin = (int) this.f26020f;
            layoutParams.bottomMargin = (int) this.f26021g;
            layoutParams.gravity = this.f26135i;
            return layoutParams;
        }
    }

    public a(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.component.a
    public a.C0358a c() {
        return new C0361a();
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: fz */
    public UGFrameLayout xv() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.f26040w);
        this.f26134d = uGFrameLayout;
        uGFrameLayout.a(this);
        return this.f26134d;
    }

    @Override // com.bytedance.adsdk.ugeno.component.a, com.bytedance.adsdk.ugeno.component.b
    public void w() {
        this.f26134d.setEventMap(this.up);
        super.w();
    }
}
