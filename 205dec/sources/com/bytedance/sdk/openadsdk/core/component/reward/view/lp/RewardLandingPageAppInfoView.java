package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardLandingPageAppInfoView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private DownloadItemView f32655c;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    private View w(Context context, RelativeLayout relativeLayout, int i4) {
        TextView textView = new TextView(context);
        textView.setText("\u529f\u80fd");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i4);
        layoutParams.rightMargin = xk.ux(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int ux = xk.ux(context, 6.0f);
        xk.c(textView, ux, ux, 0, 0);
        return textView;
    }

    private View xv(Context context, RelativeLayout relativeLayout, int i4) {
        TextView textView = new TextView(context);
        textView.setText("\u6743\u9650");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        textView.setId(View.generateViewId());
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i4);
        layoutParams.rightMargin = xk.ux(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int ux = xk.ux(context, 6.0f);
        xk.c(textView, ux, ux, 0, 0);
        return textView;
    }

    public void c(me meVar, String str) {
        if (meVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        c(meVar);
        ux zg = meVar.zg();
        if (zg == null) {
            return;
        }
        int ux = xk.ux(context, 12.0f);
        View c4 = c(context, zg);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ux;
        addView(c4, layoutParams);
        View c5 = c(context, meVar, zg, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = ux;
        addView(c5, layoutParams2);
        int ux2 = xk.ux(context, 16.0f);
        setPadding(ux2, ux, ux2, ux);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.f32655c;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    private void c(me meVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.f32655c = downloadItemView;
        downloadItemView.c(meVar);
        addView(this.f32655c);
    }

    private View c(Context context, ux uxVar) {
        TextView textView = new TextView(context);
        textView.setText(uxVar.r());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    private View c(final Context context, final me meVar, ux uxVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("\u7248\u672c\u53f7\uff1a%s", uxVar.ux()));
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        relativeLayout.addView(textView, layoutParams);
        View c4 = c(context, relativeLayout);
        c4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.c(meVar, context, str);
            }
        });
        View xv = xv(context, relativeLayout, c(context, relativeLayout, c4.getId()).getId());
        xv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.w(meVar, context, str);
            }
        });
        w(context, relativeLayout, c(context, relativeLayout, xv.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.c(context, meVar, str);
            }
        });
        return relativeLayout;
    }

    private View c(Context context, RelativeLayout relativeLayout, int i4) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xk.ux(context, 1.5f), xk.ux(context, 8.0f));
        layoutParams.rightMargin = xk.ux(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i4);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View c(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setText("\u9690\u79c1");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(textView, layoutParams);
        int ux = xk.ux(context, 6.0f);
        xk.c(textView, ux, ux, 0, 0);
        return textView;
    }
}
