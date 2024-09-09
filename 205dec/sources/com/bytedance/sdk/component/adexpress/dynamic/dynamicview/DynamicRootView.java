package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.dynamic.xv.f;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.adexpress.w.k;
import com.bytedance.sdk.component.adexpress.w.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.sr, com.bytedance.sdk.component.adexpress.theme.c {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.ux f29179a;
    private int bk;

    /* renamed from: c  reason: collision with root package name */
    protected final t f29180c;
    private com.bytedance.sdk.component.adexpress.dynamic.w ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.ux.c f29181f;
    private Context fp;
    private ViewGroup gd;
    private String ia;

    /* renamed from: k  reason: collision with root package name */
    private List<com.bytedance.sdk.component.adexpress.dynamic.xv> f29182k;

    /* renamed from: p  reason: collision with root package name */
    private int f29183p;

    /* renamed from: r  reason: collision with root package name */
    private ThemeStatusBroadcastReceiver f29184r;

    /* renamed from: s  reason: collision with root package name */
    private Map<Integer, String> f29185s;
    private k sr;

    /* renamed from: t  reason: collision with root package name */
    private int f29186t;
    private DynamicBaseWidget ux;

    /* renamed from: w  reason: collision with root package name */
    boolean f29187w;
    public View xv;
    private bk ys;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z3, bk bkVar, com.bytedance.sdk.component.adexpress.dynamic.ux.c cVar) {
        super(context);
        this.gd = null;
        this.f29183p = 0;
        this.f29182k = new ArrayList();
        this.bk = 0;
        this.f29186t = 0;
        this.fp = context;
        t tVar = new t();
        this.f29180c = tVar;
        tVar.c(2);
        this.f29181f = cVar;
        cVar.c(this);
        this.f29184r = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.c(this);
        this.f29187w = z3;
        this.ys = bkVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.c
    public void b_(int i4) {
        DynamicBaseWidget dynamicBaseWidget = this.ux;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.c(i4);
    }

    public void c(ev evVar, int i4) {
        this.ux = c(evVar, this, i4);
        this.f29180c.c(true);
        this.f29180c.c(this.ux.ux);
        this.f29180c.w(this.ux.f29134f);
        this.f29180c.c(this.xv);
        this.sr.c(this.f29180c);
    }

    public String getBgColor() {
        return this.ia;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.f29185s;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ux.c getDynamicClickListener() {
        return this.f29181f;
    }

    public int getLogoUnionHeight() {
        return this.bk;
    }

    public k getRenderListener() {
        return this.sr;
    }

    public bk getRenderRequest() {
        return this.ys;
    }

    public int getScoreCountWithIcon() {
        return this.f29186t;
    }

    public ViewGroup getTimeOut() {
        return this.gd;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.xv> getTimeOutListener() {
        return this.f29182k;
    }

    public int getTimedown() {
        return this.f29183p;
    }

    public void setBgColor(String str) {
        this.ia = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.f29185s = map;
    }

    public void setDislikeView(View view) {
        this.f29181f.w(view);
    }

    public void setLogoUnionHeight(int i4) {
        this.bk = i4;
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.w wVar) {
        this.ev = wVar;
    }

    public void setRenderListener(k kVar) {
        this.sr = kVar;
        this.f29181f.c(kVar);
    }

    public void setScoreCountWithIcon(int i4) {
        this.f29186t = i4;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr
    public void setSoundMute(boolean z3) {
        com.bytedance.sdk.component.adexpress.dynamic.w wVar = this.ev;
        if (wVar != null) {
            wVar.setSoundMute(z3);
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.gd = viewGroup;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.xv xvVar) {
        this.f29182k.add(xvVar);
    }

    public void setTimeUpdate(int i4) {
        this.f29179a.setTimeUpdate(i4);
    }

    public void setTimedown(int i4) {
        this.f29183p = i4;
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.ux uxVar) {
        this.f29179a = uxVar;
    }

    public void w() {
        c(this.ux, 4);
    }

    public DynamicBaseWidget c(ev evVar, ViewGroup viewGroup, int i4) {
        if (evVar == null) {
            return null;
        }
        List<ev> k4 = evVar.k();
        DynamicBaseWidget c4 = com.bytedance.sdk.component.adexpress.dynamic.c.w.c(this.fp, this, evVar);
        if (c4 instanceof DynamicUnKnowView) {
            c(i4 == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        c(evVar);
        c4.c();
        if (viewGroup != null) {
            viewGroup.addView(c4);
            c(viewGroup, evVar);
        }
        if (k4 == null || k4.size() <= 0) {
            return null;
        }
        for (ev evVar2 : k4) {
            c(evVar2, c4, i4);
        }
        return c4;
    }

    private void c(ev evVar) {
        f sr;
        com.bytedance.sdk.component.adexpress.dynamic.xv.ux p3 = evVar.p();
        if (p3 == null || (sr = p3.sr()) == null) {
            return;
        }
        this.f29180c.w(sr.nc());
    }

    private void c(ViewGroup viewGroup, ev evVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !evVar.ls()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void c(double d4, double d5, double d6, double d7, float f4) {
        this.f29180c.xv(d4);
        this.f29180c.sr(d5);
        this.f29180c.ux(d6);
        this.f29180c.f(d7);
        this.f29180c.c(f4);
        this.f29180c.w(f4);
        this.f29180c.xv(f4);
        this.f29180c.sr(f4);
    }

    public void c(int i4, String str) {
        this.f29180c.c(false);
        this.f29180c.w(i4);
        this.f29180c.c(str);
        this.sr.c(this.f29180c);
    }

    public void c() {
        c(this.ux, 0);
    }

    public void c(DynamicBaseWidget dynamicBaseWidget, int i4) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i4);
            View view = dynamicBaseWidget.ys;
            if (view != null) {
                view.setVisibility(i4);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            if (dynamicBaseWidget.getChildAt(i5) instanceof DynamicBaseWidget) {
                c((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i5), i4);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr
    public void c(CharSequence charSequence, int i4, int i5, boolean z3) {
        for (int i6 = 0; i6 < this.f29182k.size(); i6++) {
            if (this.f29182k.get(i6) != null) {
                this.f29182k.get(i6).c(charSequence, i4 == 1, i5, z3);
            }
        }
    }
}
