package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.C2603as;
import com.baidu.mobads.sdk.internal.C2632br;
import com.baidu.mobads.sdk.internal.C2736x;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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
        ClassLoader m50753a = C2632br.m50753a(context);
        this.mLoader = m50753a;
        View view = (View) C2603as.m50950a(C2736x.f9307e, m50753a, new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void changeViewLayoutParams(Object obj) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9307e, view, this.mLoader, "changeLayoutParams", new Class[]{Object.class}, obj);
        }
    }

    public int getAdContainerHeight() {
        View view = this.mAdView;
        if (view != null) {
            Object m50949a = C2603as.m50949a(C2736x.f9307e, view, this.mLoader, "getAdContainerHeight", new Class[0], new Object[0]);
            if (m50949a instanceof Number) {
                return ((Integer) m50949a).intValue();
            }
        }
        return 0;
    }

    public int getAdContainerWidth() {
        View view = this.mAdView;
        if (view != null) {
            Object m50949a = C2603as.m50949a(C2736x.f9307e, view, this.mLoader, "getAdContainerWidth", new Class[0], new Object[0]);
            if (m50949a instanceof Number) {
                return ((Integer) m50949a).intValue();
            }
        }
        return 0;
    }

    public RelativeLayout getContainerView() {
        View view = this.mAdView;
        if (view != null) {
            return (RelativeLayout) C2603as.m50949a(C2736x.f9307e, view, this.mLoader, "getAdView", new Class[0], new Object[0]);
        }
        return null;
    }

    public void setAdData(XAdNativeResponse xAdNativeResponse) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9307e, view, this.mLoader, "setAdResponse", new Class[]{Object.class}, xAdNativeResponse);
        }
    }

    public FeedNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FeedNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
