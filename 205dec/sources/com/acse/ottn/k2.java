package com.acse.ottn;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k2 extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public a f5807a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(int i4);
    }

    public k2(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        a aVar = this.f5807a;
        if (aVar != null) {
            aVar.a(getScrollY());
        }
    }

    public void setOnScrollListener(a aVar) {
        this.f5807a = aVar;
    }

    public k2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public k2(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
