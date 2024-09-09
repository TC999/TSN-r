package com.acse.ottn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private a f6968a;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a(int i4);
    }

    public d(Context context) {
        super(context);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public d(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        a aVar = this.f6968a;
        if (aVar != null) {
            aVar.a(getScrollY());
        }
    }

    public void setOnScrollListener(a aVar) {
        this.f6968a = aVar;
    }
}
