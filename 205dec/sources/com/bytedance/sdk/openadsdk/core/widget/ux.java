package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f35481a;
    private String ba;
    private TextView bk;

    /* renamed from: c  reason: collision with root package name */
    protected Context f35482c;
    private View ck;
    private LinearLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f35483f;
    private Button fp;
    private String fz;
    private float gb;
    private LinearLayout gd;

    /* renamed from: i  reason: collision with root package name */
    private String f35484i;
    private com.bytedance.adsdk.xv.a ia;

    /* renamed from: j  reason: collision with root package name */
    private String f35485j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f35486k;
    private JSONArray ls;

    /* renamed from: n  reason: collision with root package name */
    private RelativeLayout f35487n;

    /* renamed from: p  reason: collision with root package name */
    private TTRatingBar2 f35488p;

    /* renamed from: q  reason: collision with root package name */
    private String f35489q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f35490r;

    /* renamed from: s  reason: collision with root package name */
    private String f35491s;
    private TTRoundRectImageView sr;

    /* renamed from: t  reason: collision with root package name */
    private TextView f35492t;

    /* renamed from: u  reason: collision with root package name */
    private String f35493u;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    Stack<View> f35494w;
    private ImageView xv;
    private TextView ys;

    /* renamed from: z  reason: collision with root package name */
    private c f35495z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);

        void sr(Dialog dialog);

        void ux(Dialog dialog);

        void w(Dialog dialog);

        void xv(Dialog dialog);
    }

    public ux(Context context) {
        super(context, i.ux(context, "tt_dialog_full"));
        this.f35494w = new Stack<>();
        this.f35482c = context;
    }

    private void f() {
        RelativeLayout relativeLayout;
        if (this.ck == null || (relativeLayout = this.f35487n) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            this.f35487n.getChildAt(i4).setVisibility(4);
        }
        this.ck.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.ux.6
            @Override // java.lang.Runnable
            public void run() {
                ux.this.xv(childCount);
            }
        }, 10L);
    }

    private void r() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.fp;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.fp.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.fp.setLayoutParams(layoutParams4);
            }
        }
        com.bytedance.adsdk.xv.a aVar = this.ia;
        if (aVar != null) {
            LottieAnimationView gd = aVar.gd();
            if (gd != null) {
                layoutParams = (RelativeLayout.LayoutParams) gd.getLayoutParams();
            } else {
                int ux = xk.ux(this.f35482c, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(ux, ux);
            }
            layoutParams.topMargin = -xk.ux(this.f35482c, 53.0f);
            this.ia.c(layoutParams);
        }
    }

    private View ux() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f35482c);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.f35482c);
        this.xv = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int ux = xk.ux(this.f35482c, 46.0f);
        this.xv.setMaxHeight(ux);
        this.xv.setMaxWidth(ux);
        this.xv.setMinimumHeight(ux);
        this.xv.setMinimumWidth(ux);
        com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(xk.ux(this.f35482c, 14.0f));
        xvVar.c(-16777216);
        xvVar.c(xk.ux(this.f35482c, 2.0f));
        this.xv.setImageDrawable(xvVar);
        relativeLayout.addView(this.xv);
        TextView textView = new TextView(this.f35482c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("\u5e94\u7528\u8be6\u60c5");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        this.f35487n.addView(relativeLayout);
        return c(relativeLayout);
    }

    private LinearLayout w(int i4, LinearLayout linearLayout, LinearLayout linearLayout2, int i5) {
        this.ev = new LinearLayout(this.f35482c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = xk.ux(this.f35482c, 10.0f);
        this.ev.setLayoutParams(layoutParams);
        this.ev.setOrientation(0);
        linearLayout2.addView(this.ev);
        this.gd = new LinearLayout(this.f35482c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = xk.ux(this.f35482c, 10.0f);
        if (i4 == 0) {
            layoutParams2.topMargin = xk.ux(this.f35482c, 16.0f);
        } else {
            layoutParams2.topMargin = xk.ux(this.f35482c, 10.0f);
        }
        this.gd.setLayoutParams(layoutParams2);
        this.gd.setOrientation(0);
        this.f35488p = new TTRatingBar2(this.f35482c, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.f35488p.setLayoutParams(layoutParams3);
        this.gd.addView(this.f35488p);
        this.f35486k = new TextView(this.f35482c);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = xk.ux(this.f35482c, 3.0f);
        this.f35486k.setTextSize(16.0f);
        this.f35486k.setTextColor(Color.parseColor("#161823"));
        this.f35486k.setLayoutParams(layoutParams4);
        this.gd.addView(this.f35486k);
        linearLayout2.addView(this.gd);
        return c(i4, linearLayout, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(int i4) {
        try {
            Rect rect = new Rect();
            if (this.f35482c.getResources().getConfiguration().orientation == 1) {
                this.f35481a.getGlobalVisibleRect(rect);
            } else {
                this.fp.getGlobalVisibleRect(rect);
            }
            while (!this.f35494w.isEmpty()) {
                Rect rect2 = new Rect();
                View pop = this.f35494w.pop();
                if (pop != null && pop.getVisibility() != 8) {
                    pop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    } else if (pop == this.ux) {
                        View pop2 = this.f35494w.pop();
                        if (pop2 != null) {
                            pop2.setVisibility(8);
                        }
                    } else {
                        pop.setVisibility(8);
                    }
                }
            }
            if (this.f35494w.isEmpty()) {
                r();
            }
        } catch (Throwable unused) {
        }
        this.f35487n.setVisibility(0);
        for (int i5 = 0; i5 < i4; i5++) {
            this.f35487n.getChildAt(i5).setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        c cVar = this.f35495z;
        if (cVar != null) {
            cVar.xv(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c();
        setCanceledOnTouchOutside(false);
        w();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        xv();
    }

    public ux sr(String str) {
        this.f35493u = str;
        return this;
    }

    public String sr() {
        return this.ba;
    }

    public void c() {
        if (this.f35482c == null) {
            this.f35482c = ls.getContext();
        }
        if (this.f35482c.getResources().getConfiguration().orientation == 1) {
            this.ck = c(1);
        } else {
            this.ck = c(0);
        }
        setContentView(this.ck);
    }

    public ux f(String str) {
        this.f35489q = str;
        return this;
    }

    private View c(int i4) {
        int ux;
        LinearLayout w3 = w(i4);
        LinearLayout linearLayout = new LinearLayout(this.f35482c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i4 == 0) {
            ux = xk.ux(this.f35482c, 40.0f);
        } else {
            layoutParams.addRule(3, ux().getId());
            ux = xk.ux(this.f35482c, 16.0f);
        }
        layoutParams.leftMargin = ux;
        layoutParams.rightMargin = ux;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.f35487n.addView(linearLayout);
        this.sr = new TTRoundRectImageView(this.f35482c);
        int ux2 = xk.ux(this.f35482c, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ux2, ux2);
        layoutParams2.gravity = 1;
        if (i4 == 0) {
            layoutParams2.topMargin = xk.ux(this.f35482c, 40.0f);
        } else {
            layoutParams2.topMargin = xk.ux(this.f35482c, 36.0f);
        }
        this.sr.setMaxHeight(ux2);
        this.sr.setMaxWidth(ux2);
        this.sr.setMinimumHeight(ux2);
        this.sr.setMinimumWidth(ux2);
        this.sr.setLayoutParams(layoutParams2);
        linearLayout.addView(this.sr);
        return c(i4, w3, linearLayout, ux);
    }

    public ux r(String str) {
        this.ba = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv() {
        int i4;
        Rect rect;
        if (this.f35482c == null) {
            this.f35482c = ls.getContext();
        }
        TextView textView = this.ux;
        if (textView != null) {
            textView.setText(this.f35491s);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.sr;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.sr != null && !TextUtils.isEmpty(this.fz)) {
            com.bytedance.sdk.openadsdk.r.w.c(this.fz).c(this.sr);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.sr;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.f35483f != null) {
            if (TextUtils.isEmpty(this.f35493u)) {
                this.f35483f.setVisibility(8);
            } else {
                this.f35483f.setText(this.f35493u);
            }
        }
        if (this.ev != null) {
            JSONArray jSONArray = this.ls;
            if (jSONArray != null && jSONArray.length() > 0) {
                WindowManager windowManager = (WindowManager) this.f35482c.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double sr = xk.sr(this.f35482c, width);
                        Double.isNaN(sr);
                        Double.isNaN(sr);
                        i4 = ((int) (sr - (0.38d * sr))) - 80;
                    } else {
                        i4 = xk.sr(this.f35482c, width) - 36;
                    }
                } else {
                    i4 = 0;
                }
                int length = this.ls.length() <= 3 ? this.ls.length() : 3;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    String optString = this.ls.optString(i5);
                    if (!TextUtils.isEmpty(optString)) {
                        TextView textView2 = new TextView(this.f35482c);
                        textView2.setText(optString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int ux = xk.ux(this.f35482c, 6.0f);
                        textView2.setPadding(ux, 0, ux, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int ux2 = xk.ux(this.f35482c, 3.0f);
                        layoutParams.leftMargin = ux2;
                        layoutParams.rightMargin = ux2;
                        textView2.setLayoutParams(layoutParams);
                        textView2.getPaint().getTextBounds(optString, 0, optString.length(), new Rect());
                        i4 -= xk.sr(this.f35482c, rect.width()) + 20;
                        if (i4 >= 0) {
                            this.ev.addView(textView2);
                        } else if (this.ev.getChildCount() <= 0) {
                            this.ev.setVisibility(8);
                        }
                    }
                    i5++;
                }
            } else {
                this.ev.setVisibility(8);
            }
        }
        if (this.f35488p != null && this.f35486k != null) {
            float f4 = this.gb;
            if (f4 <= 0.0f) {
                LinearLayout linearLayout = this.gd;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.f35488p.setVisibility(8);
                this.f35486k.setVisibility(8);
            } else {
                if (f4 > 5.0f) {
                    f4 = 5.0f;
                }
                this.gb = f4;
                this.f35486k.setText(new DecimalFormat(".0").format(this.gb));
                this.f35488p.setRating(this.gb);
                this.f35488p.c(xk.ux(this.f35482c, 16.0f), xk.ux(this.f35482c, 15.0f));
                this.f35488p.c(xk.ux(this.f35482c, 3.0f), 0, xk.ux(this.f35482c, 3.0f), 0);
                this.f35488p.c();
            }
        }
        if (this.f35481a != null) {
            String format = TextUtils.isEmpty(this.f35484i) ? String.format("\u7248\u672c\u53f7\uff1a%1$s", "\u6682\u65e0") : String.format("\u7248\u672c\u53f7\uff1a%1$s", this.f35484i);
            if (this.f35482c.getResources().getConfiguration().orientation == 2) {
                TextPaint paint = this.f35481a.getPaint();
                Rect rect2 = new Rect();
                paint.getTextBounds(format, 0, format.length(), rect2);
                double p3 = xk.p(this.f35482c);
                Double.isNaN(p3);
                Double.isNaN(p3);
                int width2 = (((int) (p3 - (0.4d * p3))) - rect2.width()) - xk.ux(this.f35482c, 106.0f);
                TextView textView3 = this.f35492t;
                if (textView3 != null) {
                    TextPaint paint2 = textView3.getPaint();
                    String charSequence = this.f35492t.getText().toString();
                    paint2.getTextBounds(charSequence, 0, charSequence.length(), rect2);
                    width2 -= rect2.width();
                }
                TextView textView4 = this.f35490r;
                if (textView4 != null) {
                    TextPaint paint3 = textView4.getPaint();
                    String charSequence2 = this.f35490r.getText().toString();
                    paint3.getTextBounds(charSequence2, 0, charSequence2.length(), rect2);
                    width2 -= rect2.width();
                }
                if (width2 <= 0) {
                    ((LinearLayout.LayoutParams) this.f35481a.getLayoutParams()).weight = 1.0f;
                }
            }
            this.f35481a.setText(format);
        }
        TextView textView5 = this.bk;
        if (textView5 != null) {
            textView5.setSelected(true);
            this.bk.setText(TextUtils.isEmpty(this.f35489q) ? String.format("\u5f00\u53d1\u8005\uff1a%1$s", "\u8865\u5145\u4e2d\uff0c\u53ef\u4e8e\u5e94\u7528\u5b98\u7f51\u67e5\u770b") : String.format("\u5f00\u53d1\u8005\uff1a%1$s", this.f35489q));
        }
    }

    public ux ux(String str) {
        this.f35484i = str;
        return this;
    }

    private LinearLayout w(int i4, LinearLayout linearLayout, int i5, LinearLayout linearLayout2, View view) {
        if (i4 == 0) {
            c(i4, (ViewGroup) linearLayout2);
            ImageView imageView = new ImageView(this.f35482c);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(xk.ux(this.f35482c, 0.5f), xk.ux(this.f35482c, 9.0f));
            layoutParams.leftMargin = xk.ux(this.f35482c, 8.0f);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
            linearLayout2.addView(imageView);
        }
        int ux = xk.ux(this.f35482c, 8.0f);
        c(linearLayout2, ux);
        w(linearLayout2, ux);
        return c(i4, linearLayout, i5, linearLayout2, view, ux);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, LinearLayout linearLayout2, int i5) {
        this.ux = new TextView(this.f35482c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i4 == 0) {
            layoutParams.topMargin = xk.ux(this.f35482c, 16.0f);
            int ux = xk.ux(this.f35482c, 25.0f);
            layoutParams.leftMargin = ux;
            layoutParams.rightMargin = ux;
        } else {
            layoutParams.topMargin = xk.ux(this.f35482c, 14.0f);
        }
        this.ux.setLayoutParams(layoutParams);
        this.ux.setEllipsize(TextUtils.TruncateAt.END);
        this.ux.setTextColor(Color.parseColor("#161823"));
        this.ux.setTextSize(18.0f);
        this.ux.setGravity(17);
        this.ux.setTypeface(null, 1);
        linearLayout2.addView(this.ux);
        this.f35483f = new TextView(this.f35482c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = xk.ux(this.f35482c, 5.0f);
        this.f35483f.setLayoutParams(layoutParams2);
        this.f35483f.setEllipsize(TextUtils.TruncateAt.END);
        this.f35483f.setSingleLine(true);
        this.f35483f.setAlpha(0.5f);
        this.f35483f.setTextColor(Color.parseColor("#161823"));
        this.f35483f.setTextSize(14.0f);
        this.f35483f.setGravity(17);
        linearLayout2.addView(this.f35483f);
        return w(i4, linearLayout, linearLayout2, i5);
    }

    private void w(LinearLayout linearLayout, int i4) {
        ImageView imageView = new ImageView(this.f35482c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(xk.ux(this.f35482c, 0.5f), xk.ux(this.f35482c, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        linearLayout.addView(imageView);
        this.f35490r = new TextView(this.f35482c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.f35490r.setLayoutParams(layoutParams2);
        this.f35490r.setAlpha(0.75f);
        this.f35490r.setTextColor(Color.parseColor("#161823"));
        this.f35490r.setTextSize(12.0f);
        this.f35490r.setText("\u6743\u9650");
        linearLayout.addView(this.f35490r);
    }

    private LinearLayout w(int i4) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f35482c);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i4);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f35482c);
        if (i4 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.f35487n = new RelativeLayout(this.f35482c);
        if (i4 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(xk.ux(this.f35482c, 8.0f));
        this.f35487n.setBackground(gradientDrawable);
        this.f35487n.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f35487n);
        return c(i4, linearLayout);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, int i5) {
        Button button = new Button(this.f35482c);
        this.fp = button;
        button.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.f35482c);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.f35482c);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.f35482c);
        this.bk = textView;
        textView.setId(View.generateViewId());
        if (i4 == 1) {
            c(i4, this.f35487n);
        } else {
            c(xk.ux(this.f35482c, 89.0f), i4);
        }
        return c(i4, linearLayout, i5, linearLayout2, view);
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, int i5, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i4 == 1) {
            layoutParams.leftMargin = i5;
            layoutParams.rightMargin = i5;
        } else {
            int ux = xk.ux(this.f35482c, 16.0f);
            layoutParams.leftMargin = ux;
            layoutParams.rightMargin = ux;
        }
        layoutParams.topMargin = xk.ux(this.f35482c, 3.0f);
        this.bk.setEllipsize(TextUtils.TruncateAt.END);
        this.bk.setGravity(17);
        this.bk.setTextColor(Color.parseColor("#4D161823"));
        this.bk.setTextSize(12.0f);
        this.bk.setLayoutParams(layoutParams);
        this.f35487n.addView(this.bk);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i5;
        layoutParams2.rightMargin = i5;
        if (i4 == 1) {
            layoutParams2.topMargin = xk.ux(this.f35482c, 9.0f);
        } else {
            layoutParams2.topMargin = xk.ux(this.f35482c, 2.0f);
            layoutParams2.bottomMargin = xk.ux(this.f35482c, 20.0f);
        }
        if (i4 == 1) {
            layoutParams2.addRule(2, view.getId());
        } else {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setGravity(1);
        return w(i4, linearLayout, i5, linearLayout2, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (this.f35482c == null) {
            this.f35482c = ls.getContext();
        }
        this.f35494w.clear();
        this.f35494w.push(this.sr);
        this.f35494w.push(this.ux);
        this.f35494w.push(this.f35483f);
        this.f35494w.push(this.ev);
        this.f35494w.push(this.gd);
        f();
        this.ys.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ux.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ux.this.f35495z == null) {
                    return;
                }
                ux.this.f35495z.ux(ux.this);
            }
        });
        this.f35490r.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ux.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ux.this.f35495z != null) {
                    ux.this.f35495z.w(ux.this);
                }
            }
        });
        this.xv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ux.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ux.this.f35495z != null) {
                    ux.this.f35495z.xv(ux.this);
                }
            }
        });
        this.f35492t.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ux.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ux.this.f35495z != null) {
                    ux.this.f35495z.sr(ux.this);
                }
            }
        });
        this.fp.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ux.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ux.this.f35495z != null) {
                    ux.this.f35495z.c(ux.this);
                }
            }
        });
    }

    public ux w(String str) {
        this.fz = str;
        return this;
    }

    private void c(LinearLayout linearLayout, int i4) {
        this.ys = new TextView(this.f35482c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i4;
        layoutParams.rightMargin = i4;
        this.ys.setLayoutParams(layoutParams);
        this.ys.setAlpha(0.75f);
        this.ys.setTextColor(Color.parseColor("#161823"));
        this.ys.setTextSize(12.0f);
        this.ys.setText("\u529f\u80fd");
        linearLayout.addView(this.ys);
    }

    public ux xv(String str) {
        this.f35485j = str;
        return this;
    }

    private LinearLayout c(int i4, LinearLayout linearLayout, int i5, LinearLayout linearLayout2, View view, int i6) {
        ImageView imageView = new ImageView(this.f35482c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(xk.ux(this.f35482c, 0.5f), xk.ux(this.f35482c, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        linearLayout2.addView(imageView);
        this.f35492t = new TextView(this.f35482c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = i6;
        layoutParams2.rightMargin = i6;
        this.f35492t.setLayoutParams(layoutParams2);
        this.f35492t.setAlpha(0.75f);
        this.f35492t.setTextColor(Color.parseColor("#161823"));
        this.f35492t.setTextSize(12.0f);
        this.f35492t.setText("\u9690\u79c1");
        linearLayout2.addView(this.f35492t);
        this.f35487n.addView(linearLayout2);
        if (i4 == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, xk.ux(this.f35482c, 1.0f));
        layoutParams3.topMargin = xk.ux(this.f35482c, 12.0f);
        layoutParams3.addRule(2, this.fp.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.f35487n.addView(view);
        c(i5, i4);
        return linearLayout;
    }

    private LinearLayout c(int i4, LinearLayout linearLayout) {
        if (i4 == 0) {
            this.xv = new ImageView(this.f35482c);
            int ux = xk.ux(this.f35482c, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ux, ux);
            int ux2 = xk.ux(this.f35482c, 36.0f);
            layoutParams.topMargin = ux2;
            layoutParams.rightMargin = ux2;
            layoutParams.leftMargin = ux2;
            layoutParams.bottomMargin = ux2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.xv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.xv.setLayoutParams(layoutParams);
            this.xv.setMaxHeight(ux);
            this.xv.setMaxWidth(ux);
            this.xv.setMinimumHeight(ux);
            this.xv.setMinimumWidth(ux);
            com.bytedance.sdk.openadsdk.res.w wVar = new com.bytedance.sdk.openadsdk.res.w(xk.ux(this.f35482c, 28.0f));
            wVar.c(Color.parseColor("#66161823"));
            float ux3 = xk.ux(this.f35482c, 2.0f);
            wVar.c(ux3);
            com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(xk.ux(this.f35482c, 12.0f));
            xvVar.c(-1);
            xvVar.c(ux3);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{wVar, xvVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int ux4 = xk.ux(this.f35482c, 8.0f);
            layerDrawable.setLayerInset(1, ux4, ux4, ux4, ux4);
            this.xv.setImageDrawable(layerDrawable);
            this.f35487n.addView(this.xv);
        }
        return linearLayout;
    }

    private void c(int i4, ViewGroup viewGroup) {
        this.f35481a = new TextView(this.f35482c);
        if (i4 == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.bk.getId());
            int ux = xk.ux(this.f35482c, 16.0f);
            layoutParams.leftMargin = ux;
            layoutParams.rightMargin = ux;
            layoutParams.topMargin = xk.ux(this.f35482c, 30.0f);
            this.f35481a.setLayoutParams(layoutParams);
            this.f35481a.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 8388611;
            this.f35481a.setLayoutParams(layoutParams2);
        }
        this.f35481a.setEllipsize(TextUtils.TruncateAt.END);
        this.f35481a.setTextColor(Color.parseColor("#57161823"));
        this.f35481a.setTextSize(12.0f);
        viewGroup.addView(this.f35481a);
    }

    private void c(int i4, int i5) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i4;
        layoutParams.rightMargin = i4;
        if (i5 == 1) {
            layoutParams.topMargin = xk.ux(this.f35482c, 14.0f);
            layoutParams.bottomMargin = xk.ux(this.f35482c, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = xk.ux(this.f35482c, 16.0f);
            layoutParams.addRule(2, this.bk.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(xk.ux(this.f35482c, 3.0f));
        this.fp.setBackground(gradientDrawable);
        this.fp.setGravity(17);
        this.fp.setText("\u7acb\u5373\u4e0b\u8f7d");
        int ux = xk.ux(this.f35482c, 13.0f);
        this.fp.setPadding(0, ux, 0, ux);
        this.fp.setTextColor(-1);
        this.fp.setLayoutParams(layoutParams);
        this.fp.setTextSize(15.0f);
        this.f35487n.addView(this.fp);
        if (i5 != 1 || TextUtils.isEmpty(this.f35485j)) {
            return;
        }
        int ux2 = xk.ux(this.f35482c, 60.0f);
        com.bytedance.adsdk.xv.a aVar = new com.bytedance.adsdk.xv.a(this.f35482c);
        this.ia = aVar;
        aVar.c("src", this.f35485j);
        this.ia.c("loop", "true");
        this.ia.c("autoPlay", "true");
        this.ia.c("width", String.valueOf(ux2));
        this.ia.c("height", String.valueOf(ux2));
        this.ia.c("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ux2, ux2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.fp.getId());
        layoutParams2.rightMargin = xk.ux(this.f35482c, 73.0f);
        layoutParams2.topMargin = -xk.ux(this.f35482c, 85.0f);
        this.ia.c(layoutParams2);
        LottieAnimationView gd = this.ia.gd();
        if (gd == null) {
            return;
        }
        this.ia.w();
        this.f35487n.addView(gd);
    }

    private View c(RelativeLayout relativeLayout) {
        View view = new View(this.f35482c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, xk.ux(this.f35482c, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.f35487n.addView(view);
        return view;
    }

    public ux c(String str) {
        this.f35491s = str;
        return this;
    }

    public ux c(JSONArray jSONArray) {
        this.ls = jSONArray;
        return this;
    }

    public ux c(float f4) {
        this.gb = f4;
        return this;
    }

    public ux c(c cVar) {
        this.f35495z = cVar;
        return this;
    }
}
