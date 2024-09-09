package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.sr.f;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.xv {

    /* renamed from: c  reason: collision with root package name */
    int f29200c;

    /* renamed from: i  reason: collision with root package name */
    private int f29201i;

    /* renamed from: q  reason: collision with root package name */
    private boolean f29202q;

    /* renamed from: u  reason: collision with root package name */
    private int f29203u;

    /* renamed from: w  reason: collision with root package name */
    boolean f29204w;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29201i = 0;
        setTag(Integer.valueOf(getClickArea()));
        gd();
        dynamicRootView.setTimeOutListener(this);
    }

    private void gd() {
        List<ev> k4 = this.bk.k();
        if (k4 == null || k4.size() <= 0) {
            return;
        }
        Iterator<ev> it = k4.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ev next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.p().getType())) {
                int c4 = (int) f.c(this.f29136k, next.ev() + (com.bytedance.sdk.component.adexpress.sr.c() ? next.bk() : 0));
                this.f29203u = c4;
                this.f29200c = this.f29138r - c4;
            }
        }
        this.f29201i = this.f29138r - this.f29200c;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xv
    public void c(CharSequence charSequence, boolean z3, int i4, boolean z4) {
        if (z4 && this.f29202q != z4) {
            this.f29202q = z4;
            ux();
            return;
        }
        if (z3 && this.f29204w != z3) {
            this.f29204w = z3;
            ux();
        }
        this.f29204w = z3;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        if (com.bytedance.sdk.component.adexpress.sr.ux.w(this.f29140t.getRenderRequest().sr())) {
            return true;
        }
        super.ev();
        setPadding((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.w()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.sr()), (int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.c()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f29202q && this.f29132a != null) {
            setMeasuredDimension(this.f29203u + ((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv())) + ((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.sr())), this.ev);
        } else if (this.f29204w) {
            setMeasuredDimension(this.f29138r, this.ev);
        } else {
            setMeasuredDimension(this.f29200c, this.ev);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ux() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.f29204w) {
            layoutParams.leftMargin = this.gd;
        } else {
            layoutParams.leftMargin = this.gd + this.f29201i;
        }
        if (this.f29202q && this.f29132a != null) {
            layoutParams.leftMargin = ((this.gd + this.f29201i) - ((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.xv()))) - ((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.sr()));
        }
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            layoutParams.topMargin = this.f29137p - ((int) f.c(com.bytedance.sdk.component.adexpress.sr.getContext(), this.f29132a.w()));
        } else {
            layoutParams.topMargin = this.f29137p;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
