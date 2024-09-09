package com.bytedance.adsdk.ugeno.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.component.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a<E extends ViewGroup> extends b {

    /* renamed from: c  reason: collision with root package name */
    protected List<b<View>> f26014c;

    /* renamed from: com.bytedance.adsdk.ugeno.component.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0358a {

        /* renamed from: a  reason: collision with root package name */
        protected float f26015a;

        /* renamed from: b  reason: collision with root package name */
        protected float f26016b;

        /* renamed from: c  reason: collision with root package name */
        protected float f26017c;

        /* renamed from: d  reason: collision with root package name */
        protected float f26018d;

        /* renamed from: e  reason: collision with root package name */
        protected float f26019e;

        /* renamed from: f  reason: collision with root package name */
        protected float f26020f;

        /* renamed from: g  reason: collision with root package name */
        protected float f26021g;

        /* renamed from: h  reason: collision with root package name */
        protected ViewGroup.LayoutParams f26022h;

        public ViewGroup.LayoutParams a() {
            FlexboxLayout.c cVar = new FlexboxLayout.c((int) this.f26015a, (int) this.f26016b);
            ((ViewGroup.MarginLayoutParams) cVar).leftMargin = (int) this.f26018d;
            ((ViewGroup.MarginLayoutParams) cVar).rightMargin = (int) this.f26019e;
            ((ViewGroup.MarginLayoutParams) cVar).topMargin = (int) this.f26020f;
            ((ViewGroup.MarginLayoutParams) cVar).bottomMargin = (int) this.f26021g;
            return cVar;
        }

        public void b(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str.hashCode();
            char c4 = '\uffff';
            switch (str.hashCode()) {
                case -1221029593:
                    if (str.equals("height")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 113126854:
                    if (str.equals("width")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        c4 = 6;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.f26016b = -1.0f;
                        return;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.f26016b = -2.0f;
                        return;
                    } else {
                        this.f26016b = l0.b.b(context, str2);
                        return;
                    }
                case 1:
                    this.f26017c = l0.b.b(context, str2);
                    return;
                case 2:
                    this.f26020f = l0.b.b(context, str2);
                    return;
                case 3:
                    this.f26021g = l0.b.b(context, str2);
                    return;
                case 4:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.f26015a = -1.0f;
                        return;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.f26015a = -2.0f;
                        return;
                    } else {
                        this.f26015a = l0.b.b(context, str2);
                        return;
                    }
                case 5:
                    this.f26019e = l0.b.b(context, str2);
                    return;
                case 6:
                    this.f26018d = l0.b.b(context, str2);
                    return;
                default:
                    return;
            }
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public void c(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f26014c.add(bVar);
        View gd = bVar.gd();
        if (gd != null) {
            ((ViewGroup) this.ux).addView(gd);
        }
    }

    public List<b<View>> ev() {
        return this.f26014c;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
    }

    public a(Context context, a aVar) {
        super(context, aVar);
        this.f26014c = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public b c(String str) {
        b<View> w3;
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, this.f26034p)) {
            for (b<View> bVar : this.f26014c) {
                if (bVar != null && (w3 = bVar.w(str)) != null) {
                    return w3;
                }
            }
            return null;
        }
        return this;
    }

    public C0358a c() {
        return new C0358a();
    }
}
