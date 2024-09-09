package com.qq.e.comm.plugin.rewardvideo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.n1;
import com.qq.e.comm.plugin.util.z;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    private TextView f45856c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f45857d;

    public a(Context context) {
        super(context);
    }

    public LinearLayout a(Context context, boolean z3, String str, String str2, String str3) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, f1.a(context, 137));
        linearLayout.setBackgroundDrawable(n1.a(f1.a(context, 10), -1, 255));
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(-16777216);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        int a4 = f1.a(context, 1);
        int i4 = a4 * 10;
        textView.setPadding(i4, 0, i4, 0);
        double c4 = z.c();
        double d4 = z3 ? 0.35d : 0.6d;
        Double.isNaN(c4);
        int i5 = a4 * 40;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(((int) (c4 * d4)) + i5, -2);
        layoutParams2.bottomMargin = i5;
        layoutParams2.topMargin = i5;
        linearLayout.addView(textView, layoutParams2);
        TextView textView2 = new TextView(context);
        textView2.setBackgroundColor(Color.parseColor("#ececec"));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, f1.a(context, 1)));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, f1.a(context, 44)));
        if (!TextUtils.isEmpty(str3)) {
            TextView textView3 = new TextView(context);
            this.f45857d = textView3;
            textView3.setText(str3);
            this.f45857d.setTextSize(16.0f);
            this.f45857d.setTextColor(-16777216);
            this.f45857d.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, f1.a(context, 44));
            layoutParams3.weight = 1.0f;
            linearLayout2.addView(this.f45857d, layoutParams3);
            TextView textView4 = new TextView(context);
            textView4.setBackgroundColor(Color.parseColor("#ececec"));
            linearLayout2.addView(textView4, new LinearLayout.LayoutParams(f1.a(context, 1), -1));
        }
        TextView textView5 = new TextView(context);
        this.f45856c = textView5;
        textView5.setText(str2);
        this.f45856c.setTextSize(16.0f);
        this.f45856c.setTextColor(Color.parseColor("#3185FC"));
        this.f45856c.setGravity(17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, f1.a(context, 44));
        layoutParams4.weight = 1.0f;
        linearLayout2.addView(this.f45856c, layoutParams4);
        return linearLayout;
    }

    public TextView b() {
        return this.f45856c;
    }

    public TextView a() {
        return this.f45857d;
    }
}
