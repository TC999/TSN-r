package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f45687c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f45688d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f45689e;

    public c(Context context) {
        this(context, -1);
    }

    private void a(Context context, int i4) {
        setGravity(17);
        TextView textView = new TextView(context);
        this.f45687c = textView;
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 5, 0);
        this.f45687c.setLayoutParams(layoutParams);
        this.f45687c.setTextSize(1, 14.0f);
        this.f45687c.setTextColor(i4);
        this.f45687c.setSingleLine();
        this.f45687c.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = new TextView(context);
        this.f45689e = textView2;
        textView2.setIncludeFontPadding(false);
        this.f45689e.setLayoutParams(new LinearLayout.LayoutParams(f1.a(context, 16), -2));
        this.f45689e.setTextSize(1, 14.0f);
        this.f45689e.setTextColor(i4);
        this.f45689e.setSingleLine();
        this.f45689e.setGravity(17);
        TextView textView3 = new TextView(context);
        this.f45688d = textView3;
        textView3.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(5, 0, 0, 0);
        this.f45688d.setLayoutParams(layoutParams2);
        this.f45688d.setTextSize(1, 14.0f);
        this.f45688d.setTextColor(i4);
        this.f45688d.setSingleLine();
        this.f45688d.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.f45687c);
        addView(this.f45689e);
        addView(this.f45688d);
    }

    public c(Context context, int i4) {
        super(context);
        a(context, i4);
    }

    public void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f45687c.setVisibility(charSequence == null ? 8 : 0);
        this.f45689e.setVisibility(charSequence2 == null ? 8 : 0);
        this.f45688d.setVisibility(charSequence3 != null ? 0 : 8);
        this.f45687c.setText(charSequence);
        if (charSequence2 == null) {
            charSequence2 = "";
        }
        int a4 = f1.a(getContext(), charSequence2.length() * 9);
        ViewGroup.LayoutParams layoutParams = this.f45689e.getLayoutParams();
        layoutParams.width = a4;
        this.f45689e.setLayoutParams(layoutParams);
        this.f45689e.setText(charSequence2);
        this.f45688d.setText(charSequence3);
    }

    public void a(CharSequence charSequence) {
        this.f45689e.setText(charSequence);
    }

    public void a(String str) {
        this.f45687c.setVisibility(8);
        this.f45688d.setVisibility(8);
        this.f45689e.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f45689e.getLayoutParams();
        layoutParams.width = -2;
        this.f45689e.setLayoutParams(layoutParams);
    }

    public TextView a() {
        return this.f45687c;
    }

    public void a(int i4, int i5) {
        float f4 = i5;
        this.f45687c.setTextSize(i4, f4);
        this.f45689e.setTextSize(i4, f4);
        this.f45688d.setTextSize(i4, f4);
    }

    public void a(int i4) {
        this.f45687c.setTextColor(i4);
        this.f45689e.setTextColor(i4);
        this.f45688d.setTextColor(i4);
    }
}
