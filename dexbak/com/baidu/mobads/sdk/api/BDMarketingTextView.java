package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.C2603as;
import com.baidu.mobads.sdk.internal.C2632br;
import com.baidu.mobads.sdk.internal.C2736x;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BDMarketingTextView extends RelativeLayout {
    private View mAdView;
    private Context mContext;
    private ClassLoader mLoader;

    public BDMarketingTextView(Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        try {
            this.mContext = context;
            Object[] objArr = {context};
            ClassLoader m50753a = C2632br.m50753a(context);
            this.mLoader = m50753a;
            View view = (View) C2603as.m50950a(C2736x.f9308f, m50753a, new Class[]{Context.class}, objArr);
            this.mAdView = view;
            if (view != null) {
                addView(view, new RelativeLayout.LayoutParams(-2, -2));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAdData(NativeResponse nativeResponse, String str) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setAdData", new Class[]{Object.class, String.class}, nativeResponse, str);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setEllipsize", new Class[]{TextUtils.TruncateAt.class}, truncateAt);
        }
    }

    public void setLabelFontSizeSp(int i) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setLabelVisibility(int i) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setLabelVisibility", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setLineSpacingExtra(int i) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setLineSpacingExtra", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setTextFontColor(int i) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setTextFontColor", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setTextFontSizeSp(int i) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setTextFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setTextFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setTextFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setTextMaxLines(int i) {
        View view = this.mAdView;
        if (view != null) {
            C2603as.m50949a(C2736x.f9308f, view, this.mLoader, "setTextMaxLines", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public BDMarketingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
