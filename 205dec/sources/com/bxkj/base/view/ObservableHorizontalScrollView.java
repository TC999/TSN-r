package com.bxkj.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ObservableHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private a f18809a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a(ObservableHorizontalScrollView observableHorizontalScrollView, int i4, int i5, int i6, int i7);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
        this.f18809a = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        a aVar = this.f18809a;
        if (aVar != null) {
            aVar.a(this, i4, i5, i6, i7);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.f18809a = aVar;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f18809a = null;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18809a = null;
    }
}
