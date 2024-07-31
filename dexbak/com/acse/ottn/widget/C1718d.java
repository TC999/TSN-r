package com.acse.ottn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* renamed from: com.acse.ottn.widget.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1718d extends ScrollView {

    /* renamed from: a */
    private InterfaceC1719a f3421a;

    /* renamed from: com.acse.ottn.widget.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1719a {
        /* renamed from: a */
        void m55845a(int i);
    }

    public C1718d(Context context) {
        super(context);
    }

    public C1718d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C1718d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        InterfaceC1719a interfaceC1719a = this.f3421a;
        if (interfaceC1719a != null) {
            interfaceC1719a.m55845a(getScrollY());
        }
    }

    public void setOnScrollListener(InterfaceC1719a interfaceC1719a) {
        this.f3421a = interfaceC1719a;
    }
}
