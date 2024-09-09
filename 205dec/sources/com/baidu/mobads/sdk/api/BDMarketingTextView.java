package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
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
            ClassLoader a4 = bu.a(context);
            this.mLoader = a4;
            View view = (View) av.a(x.f13025f, a4, new Class[]{Context.class}, objArr);
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
            av.a(x.f13025f, view, this.mLoader, "setAdData", new Class[]{Object.class, String.class}, nativeResponse, str);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setEllipsize", new Class[]{TextUtils.TruncateAt.class}, truncateAt);
        }
    }

    public void setLabelFontSizeSp(int i4) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setLabelFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setLabelFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setLabelVisibility(int i4) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setLabelVisibility", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
        }
    }

    public void setLineSpacingExtra(int i4) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setLineSpacingExtra", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
        }
    }

    public void setTextFontColor(int i4) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setTextFontColor", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
        }
    }

    public void setTextFontSizeSp(int i4) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setTextFontSizeSp", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
        }
    }

    public void setTextFontTypeFace(Typeface typeface) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setTextFontTypeFace", new Class[]{Typeface.class}, typeface);
        }
    }

    public void setTextMaxLines(int i4) {
        View view = this.mAdView;
        if (view != null) {
            av.a(x.f13025f, view, this.mLoader, "setTextMaxLines", new Class[]{Integer.TYPE}, Integer.valueOf(i4));
        }
    }

    public BDMarketingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDMarketingTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        initView(context);
    }
}
