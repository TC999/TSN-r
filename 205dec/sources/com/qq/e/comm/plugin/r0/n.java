package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qq.e.comm.plugin.util.f1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f45829c;

    /* renamed from: d  reason: collision with root package name */
    private c f45830d;

    /* renamed from: e  reason: collision with root package name */
    private int f45831e;

    /* renamed from: f  reason: collision with root package name */
    private int f45832f;

    /* renamed from: g  reason: collision with root package name */
    private final GradientDrawable f45833g;

    public n(Context context) {
        super(context);
        this.f45831e = f1.a(getContext(), 2);
        this.f45832f = Color.parseColor("#48FFFFFF");
        this.f45833g = new GradientDrawable();
        a(context);
    }

    private void a(Context context) {
        setGravity(16);
        setPadding(f1.a(context, 10), 0, f1.a(context, 10), 0);
        this.f45833g.setColor(Color.parseColor("#80000000"));
        this.f45833g.setCornerRadius(54.0f);
        this.f45833g.setStroke(this.f45831e, this.f45832f);
        setBackgroundDrawable(this.f45833g);
        c cVar = new c(context);
        this.f45830d = cVar;
        addView(cVar);
    }

    public ImageView b() {
        return this.f45829c;
    }

    public void c(int i4) {
        this.f45831e = i4;
        this.f45833g.setStroke(i4, this.f45832f);
    }

    public void d(int i4) {
        this.f45830d.a(i4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f45833g.setColor(i4);
    }

    public void setWidth(int i4) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i4;
        setLayoutParams(layoutParams);
    }

    public void b(int i4) {
        this.f45833g.setCornerRadius(i4);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (this.f45829c == null) {
            this.f45829c = new ImageView(getContext());
            int a4 = f1.a(getContext(), 16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a4, a4);
            layoutParams.rightMargin = f1.a(getContext(), 4);
            this.f45829c.setLayoutParams(layoutParams);
            addView(this.f45829c, 0);
        }
        this.f45829c.setImageBitmap(bitmap);
    }

    public c a() {
        return this.f45830d;
    }

    public void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f45830d.a(charSequence, charSequence2, charSequence3);
    }

    public void a(CharSequence charSequence) {
        this.f45830d.a(charSequence);
    }

    public void a(String str) {
        this.f45830d.a(str);
    }

    public void a(int i4) {
        this.f45832f = i4;
        this.f45833g.setStroke(this.f45831e, i4);
    }

    public void a(int i4, int i5) {
        this.f45830d.a(i4, i5);
    }
}
