package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.xv.ev;
import com.bytedance.sdk.component.adexpress.dynamic.xv.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {

    /* renamed from: c  reason: collision with root package name */
    private TextView f29172c;

    /* renamed from: i  reason: collision with root package name */
    private TextView f29173i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f29174j;

    /* renamed from: q  reason: collision with root package name */
    private TextView f29175q;

    /* renamed from: u  reason: collision with root package name */
    private TextView f29176u;

    /* renamed from: w  reason: collision with root package name */
    private TextView f29177w;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, ev evVar) {
        super(context, dynamicRootView, evVar);
        this.f29172c = new TextView(this.f29136k);
        this.f29177w = new TextView(this.f29136k);
        this.f29176u = new TextView(this.f29136k);
        this.f29174j = new LinearLayout(this.f29136k);
        this.f29173i = new TextView(this.f29136k);
        this.f29175q = new TextView(this.f29136k);
        this.f29172c.setTag(9);
        this.f29177w.setTag(10);
        this.f29176u.setTag(12);
        this.f29174j.addView(this.f29176u);
        this.f29174j.addView(this.f29175q);
        this.f29174j.addView(this.f29177w);
        this.f29174j.addView(this.f29173i);
        this.f29174j.addView(this.f29172c);
        addView(this.f29174j, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.sr
    public boolean ev() {
        this.f29176u.setText("\u529f\u80fd");
        this.f29177w.setText("\u6743\u9650");
        this.f29173i.setText(" | ");
        this.f29175q.setText(" | ");
        this.f29172c.setText("\u9690\u79c1");
        r rVar = this.f29132a;
        if (rVar != null) {
            this.f29176u.setTextColor(rVar.r());
            this.f29176u.setTextSize(this.f29132a.ux());
            this.f29177w.setTextColor(this.f29132a.r());
            this.f29177w.setTextSize(this.f29132a.ux());
            this.f29173i.setTextColor(this.f29132a.r());
            this.f29175q.setTextColor(this.f29132a.r());
            this.f29172c.setTextColor(this.f29132a.r());
            this.f29172c.setTextSize(this.f29132a.ux());
            return false;
        }
        this.f29176u.setTextColor(-1);
        this.f29176u.setTextSize(12.0f);
        this.f29177w.setTextColor(-1);
        this.f29177w.setTextSize(12.0f);
        this.f29173i.setTextColor(-1);
        this.f29175q.setTextColor(-1);
        this.f29172c.setTextColor(-1);
        this.f29172c.setTextSize(12.0f);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.f29138r, this.ev);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected boolean xv() {
        this.f29172c.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.f29172c.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.f29177w.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.f29177w.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.f29176u.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.f29176u.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }
}
