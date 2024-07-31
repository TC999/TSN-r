package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.p072g.C3138av;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RegionClickView extends LinearLayout {

    /* renamed from: a */
    GradientDrawable f11632a;

    /* renamed from: b */
    TextView f11633b;

    /* renamed from: c */
    private boolean f11634c;

    public RegionClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11634c = false;
        init(context);
    }

    /* renamed from: a */
    private void m48059a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f11632a = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            this.f11632a.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.f11632a.setCornerRadius(C3138av.m48304a(context, 30.0f));
        setBackgroundDrawable(this.f11632a);
    }

    public void init(Context context) {
        if (this.f11634c) {
            return;
        }
        this.f11634c = true;
        m48059a(context, 1);
        TextView textView = new TextView(context);
        this.f11633b = textView;
        textView.setLines(1);
        this.f11633b.setTextSize(2, 18.0f);
        this.f11633b.setTextColor(Color.parseColor("#949494"));
        this.f11633b.setText("点击跳转详情页或第三方应用     >");
        this.f11633b.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.f11633b);
    }

    public void setBackGroundAlpha(double d) {
        GradientDrawable gradientDrawable = this.f11632a;
        if (gradientDrawable == null || d <= Utils.DOUBLE_EPSILON) {
            return;
        }
        gradientDrawable.setAlpha((int) (d * 255.0d));
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.f11632a;
        if (gradientDrawable == null || str == null) {
            return;
        }
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRegionalClickViewBean(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        if (regionalClickViewBean == null) {
            return;
        }
        setTitle(regionalClickViewBean.getTitle());
        setTitleColor(regionalClickViewBean.getTitleColor());
        setBackGroundAlpha(regionalClickViewBean.getBackgroundAlpha());
        setBackgroundColor(regionalClickViewBean.getBackgroundColor());
    }

    public void setTitle(String str) {
        TextView textView = this.f11633b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.f11633b;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11634c = false;
        init(context);
    }

    public RegionClickView(Context context) {
        super(context);
        this.f11634c = false;
        init(context);
    }
}
