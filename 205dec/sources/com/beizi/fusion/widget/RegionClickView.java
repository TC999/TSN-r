package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.model.AdSpacesBean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RegionClickView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    GradientDrawable f15218a;

    /* renamed from: b  reason: collision with root package name */
    TextView f15219b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15220c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f15221d;

    public RegionClickView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f15220c = false;
        init(context);
    }

    private void a(Context context, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f15218a = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i4 == 1) {
            this.f15218a.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.f15218a.setCornerRadius(aw.a(context, 30.0f));
        setBackgroundDrawable(this.f15218a);
    }

    public void init(Context context) {
        if (this.f15220c) {
            return;
        }
        this.f15220c = true;
        a(context, 1);
        TextView textView = new TextView(context);
        this.f15219b = textView;
        textView.setLines(1);
        this.f15219b.setTextSize(2, 18.0f);
        this.f15219b.setTextColor(Color.parseColor("#949494"));
        this.f15219b.setText("\u70b9\u51fb\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528     >");
        this.f15219b.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.f15219b);
    }

    public void setBackGroundAlpha(double d4) {
        GradientDrawable gradientDrawable = this.f15218a;
        if (gradientDrawable == null || d4 <= 0.0d) {
            return;
        }
        gradientDrawable.setAlpha((int) (d4 * 255.0d));
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.f15218a;
        if (gradientDrawable == null || str == null) {
            return;
        }
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.f15221d = bool;
    }

    public void setRegionalClickViewBean(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        String downloadTitle;
        if (regionalClickViewBean == null) {
            return;
        }
        if (!this.f15221d.booleanValue()) {
            downloadTitle = regionalClickViewBean.getTitle();
        } else {
            downloadTitle = regionalClickViewBean.getDownloadTitle();
            if (TextUtils.isEmpty(downloadTitle)) {
                downloadTitle = "\u70b9\u51fb\u4e0b\u8f7d\u5e94\u7528";
            }
        }
        setTitle(downloadTitle);
        setTitleColor(regionalClickViewBean.getTitleColor());
        setBackGroundAlpha(regionalClickViewBean.getBackgroundAlpha());
        setBackgroundColor(regionalClickViewBean.getBackgroundColor());
    }

    public void setTitle(String str) {
        TextView textView = this.f15219b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.f15219b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15220c = false;
        init(context);
    }

    public RegionClickView(Context context) {
        super(context);
        this.f15220c = false;
        init(context);
    }
}
