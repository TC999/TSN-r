package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class LayoutVideoDetail extends RelativeLayout {
    public LayoutVideoDetail(Context context) {
        super(context);
        c(context);
    }

    private void c(Context context) {
        setId(2114387713);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        addView(w(context));
        addView(new sr().c(context));
        addView(xv(context));
        addView(sr(context));
        addView(ux(context));
        addView(f(context));
        addView(r(context));
        addView(ev(context));
        TTViewStub tTViewStub = new TTViewStub(context, new f());
        tTViewStub.setId(2114387745);
        tTViewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new w());
        tTViewStub2.setId(2114387665);
        tTViewStub2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub2);
        addView(gd(context));
    }

    private View ev(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387627);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, xk.ux(context, 40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387814);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(xk.ux(context, 16.0f), 0, xk.ux(context, 12.0f), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setText("00:00");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        linearLayout.addView(textView);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(2114387875);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.gravity = 16;
        seekBar.setLayoutParams(layoutParams3);
        seekBar.setBackground(null);
        seekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            seekBar.setMaxHeight(xk.ux(context, 4.0f));
            seekBar.setMinHeight(xk.ux(context, 4.0f));
        } else {
            layoutParams3.height = xk.ux(context, 4.0f);
        }
        seekBar.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float ux = xk.ux(context, 1.0f);
        gradientDrawable.setCornerRadius(ux);
        int ux2 = xk.ux(context, 2.0f);
        gradientDrawable.setSize(-1, ux2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(ux);
        gradientDrawable2.setSize(-1, ux2);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(ux);
        gradientDrawable3.setSize(-1, ux2);
        seekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int ux3 = xk.ux(context, 15.0f);
        shapeDrawable.setIntrinsicWidth(ux3);
        shapeDrawable.setIntrinsicHeight(ux3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(xk.ux(context, 1.0f));
        paint.setColor(Color.parseColor("#1E000000"));
        seekBar.setThumb(shapeDrawable);
        seekBar.setThumbOffset(0);
        linearLayout.addView(seekBar);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387667);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(xk.ux(context, 12.0f), 0, xk.ux(context, 16.0f), 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("00:00");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 10.0f);
        linearLayout.addView(textView2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387660);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.setMargins(xk.ux(context, 16.0f), 0, xk.ux(context, 16.0f), 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setVisibility(8);
        imageView.setImageDrawable(i.xv(context, "tt_enlarge_video"));
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private View f(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387604);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387901);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = xk.ux(context, 12.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.c cVar = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar.c(parseColor);
        float ux = xk.ux(context, 2.0f);
        cVar.c(ux);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.c cVar2 = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar2.c(parseColor2);
        cVar2.c(ux);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        imageView.setImageDrawable(stateListDrawable);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387705);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        int ux2 = xk.ux(context, 15.0f);
        textView.setPadding(ux2, 0, ux2, 0);
        relativeLayout.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387799);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(ux2, 0, ux2, 0);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387849);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(-1);
        linearLayout.addView(textView2);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private View gd(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387761);
        textView.setBackgroundColor(0);
        textView.setMinHeight(xk.ux(context, 44.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = xk.ux(context, 12.0f);
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawablesWithIntrinsicBounds(p(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(p(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText("\u5173\u95ed");
        return textView;
    }

    private StateListDrawable p(Context context) {
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.c cVar = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar.c(parseColor);
        float ux = xk.ux(context, 2.0f);
        cVar.c(ux);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.c cVar2 = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar2.c(parseColor2);
        cVar2.c(ux);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        return stateListDrawable;
    }

    private View r(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, i.ux(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387652);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, xk.ux(context, 1.5f));
        layoutParams.addRule(12);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setBackground(null);
        tTProgressBar.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float ux = xk.ux(context, 1.0f);
        gradientDrawable.setCornerRadius(ux);
        int ux2 = xk.ux(context, 2.0f);
        gradientDrawable.setSize(-1, ux2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(ux);
        gradientDrawable2.setSize(-1, ux2);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(ux);
        gradientDrawable3.setSize(-1, ux2);
        com.bytedance.sdk.openadsdk.res.f.c(tTProgressBar, new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar.setVisibility(8);
        return tTProgressBar;
    }

    private View sr(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387677);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(xk.ux(context, 4.0f));
        imageView.setBackground(gradientDrawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.c cVar = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar.c(parseColor);
        float ux = xk.ux(context, 2.0f);
        cVar.c(ux);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.c cVar2 = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar2.c(parseColor2);
        cVar2.c(ux);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        imageView.setImageDrawable(stateListDrawable);
        int ux2 = xk.ux(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ux2, ux2);
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        int ux3 = xk.ux(context, 7.0f);
        layoutParams.setMargins(0, ux3, ux3, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private View ux(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387731);
        textView.setGravity(8388659);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(false);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        textView.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        textView.setBackground(gradientDrawable);
        int ux = xk.ux(context, 15.0f);
        textView.setPadding(ux, xk.ux(context, 14.0f), ux, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View w(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387904);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387650);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387630);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xk.ux(context, 60.0f), xk.ux(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setIndeterminateDrawable(i.xv(context, "tt_video_loading_progress_bar"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387826);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setVisibility(8);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387617);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageDrawable(i.xv(context, "tt_refreshing_video_textpage"));
        TextView textView = new TextView(context);
        textView.setId(2114387863);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(i.c(context, "tt_video_retry_des_txt"));
        textView.setTextColor(i.r(context, "tt_heise3"));
        linearLayout.addView(imageView2);
        linearLayout.addView(textView);
        relativeLayout.addView(imageView);
        relativeLayout.addView(tTProgressBar);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private View xv(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387625);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageDrawable(i.xv(context, "tt_play_movebar_textpage"));
        imageView.setVisibility(8);
        return imageView;
    }
}
