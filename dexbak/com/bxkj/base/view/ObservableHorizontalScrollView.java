package com.bxkj.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ObservableHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a */
    private InterfaceC3997a f15239a;

    /* renamed from: com.bxkj.base.view.ObservableHorizontalScrollView$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC3997a {
        /* renamed from: a */
        void mo43031a(ObservableHorizontalScrollView observableHorizontalScrollView, int i, int i2, int i3, int i4);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
        this.f15239a = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        InterfaceC3997a interfaceC3997a = this.f15239a;
        if (interfaceC3997a != null) {
            interfaceC3997a.mo43031a(this, i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(InterfaceC3997a interfaceC3997a) {
        this.f15239a = interfaceC3997a;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15239a = null;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15239a = null;
    }
}
