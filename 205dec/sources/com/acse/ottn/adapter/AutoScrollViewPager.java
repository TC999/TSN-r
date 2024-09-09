package com.acse.ottn.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.d0;
import com.acse.ottn.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class AutoScrollViewPager extends RelativeLayout {

    /* renamed from: f  reason: collision with root package name */
    public static final String f4766f = "right";

    /* renamed from: g  reason: collision with root package name */
    public static final String f4767g = "center";

    /* renamed from: h  reason: collision with root package name */
    public static final int f4768h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f4769i = 1;

    /* renamed from: a  reason: collision with root package name */
    public s f4770a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4771b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f4772c;

    /* renamed from: d  reason: collision with root package name */
    public View f4773d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f4774e;

    public AutoScrollViewPager(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.f4771b = context;
        s sVar = new s(context);
        this.f4770a = sVar;
        addView(sVar);
        View view = this.f4773d;
        if (view != null) {
            this.f4774e = (TextView) view.findViewById(R.id.subTitle);
            this.f4772c = (LinearLayout) this.f4773d.findViewById(R.id.pointLayout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            this.f4773d.setLayoutParams(layoutParams);
            addView(this.f4773d);
        }
    }

    public void b(int i4) {
        int childCount = this.f4772c.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            ImageView imageView = (ImageView) this.f4772c.getChildAt(i5);
            if (i5 == i4) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
        }
    }

    public void c() {
        s sVar = this.f4770a;
        if (sVar == null || sVar.c()) {
            return;
        }
        this.f4770a.g();
    }

    public TextView getSubTitle() {
        return this.f4774e;
    }

    public s getViewPager() {
        return this.f4770a;
    }

    public void setAdapter(d0 d0Var) {
        s sVar = this.f4770a;
        if (sVar != null) {
            sVar.a(sVar, d0Var);
        }
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoScrollViewPager, i4, 0);
        String string = obtainStyledAttributes.getString(R.styleable.AutoScrollViewPager_point_layout);
        string = string == null ? "center" : string;
        if (string.equals("center")) {
            this.f4773d = LayoutInflater.from(context).inflate(R.layout.point_center_text, (ViewGroup) null);
        } else if (!string.equals("right")) {
            this.f4773d = LayoutInflater.from(context).inflate(R.layout.point_center_text, (ViewGroup) null);
        } else {
            this.f4773d = LayoutInflater.from(context).inflate(R.layout.point_right_text, (ViewGroup) null);
        }
        obtainStyledAttributes.recycle();
        a(context);
    }

    public void b() {
        s sVar = this.f4770a;
        if (sVar != null) {
            sVar.f();
        }
    }

    public void a(int i4) {
        a(i4, 0);
    }

    public void a(int i4, int i5) {
        this.f4772c.removeAllViews();
        for (int i6 = 0; i6 < i4; i6++) {
            View imageView = new ImageView(this.f4771b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
            layoutParams.leftMargin = 8;
            imageView.setLayoutParams(layoutParams);
            if (i6 == i5) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }
            this.f4772c.addView(imageView);
        }
    }

    public void a() {
        s sVar = this.f4770a;
        if (sVar != null) {
            sVar.d();
        }
    }
}
