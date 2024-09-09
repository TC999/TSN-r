package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.x;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class FeedNativeView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public FeedNativeView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        Object[] objArr = {context};
        ClassLoader a4 = bu.a(context);
        this.mLoader = a4;
        View view = (View) av.a(x.f13024e, a4, new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void changeViewLayoutParams(Object obj) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13024e, view, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    public int getAdContainerHeight() {
        View view = this.mAdView;
        if (view != null) {
            Object a4 = av.a(x.f13024e, view, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0]);
            if (a4 instanceof Number) {
                return ((Integer) a4).intValue();
            }
        }
        return 0;
    }

    public int getAdContainerWidth() {
        View view = this.mAdView;
        if (view != null) {
            Object a4 = av.a(x.f13024e, view, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0]);
            if (a4 instanceof Number) {
                return ((Integer) a4).intValue();
            }
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        View view = this.mAdView;
        if (view != null) {
            return (RelativeLayout) av.a(x.f13024e, view, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13024e, view, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }

    public FeedNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context);
    }
}
