package com.acse.ottn.receiver;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: com.acse.ottn.receiver.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1560h {

    /* renamed from: a */
    private static String f2928a = "ScreenLock_Width";

    /* renamed from: b */
    private static String f2929b = "ScreenLock_Height";

    /* renamed from: c */
    private static String f2930c = "ScreenLock_PositionX";

    /* renamed from: d */
    private static String f2931d = "ScreenLock_PositionY";

    /* renamed from: e */
    private int f2932e;

    /* renamed from: f */
    private int f2933f;

    /* renamed from: g */
    private int f2934g;

    /* renamed from: h */
    private int f2935h;

    /* renamed from: i */
    private Context f2936i;

    /* renamed from: j */
    private DevicePolicyManager f2937j;

    /* renamed from: k */
    private SharedPreferences f2938k;

    /* renamed from: l */
    private WindowManager f2939l;

    /* renamed from: m */
    private DisplayMetrics f2940m = new DisplayMetrics();

    /* renamed from: n */
    private ImageView f2941n;

    /* renamed from: o */
    private WindowManager.LayoutParams f2942o;

    /* renamed from: p */
    private View f2943p;

    public C1560h(Context context) {
        this.f2936i = context;
        this.f2937j = (DevicePolicyManager) context.getSystemService("device_policy");
        this.f2939l = (WindowManager) context.getSystemService("window");
        this.f2938k = context.getSharedPreferences(context.getPackageName(), 0);
        this.f2939l.getDefaultDisplay().getRealMetrics(this.f2940m);
        this.f2932e = this.f2938k.getInt(f2928a, this.f2940m.widthPixels / 20);
        this.f2933f = this.f2938k.getInt(f2929b, this.f2940m.widthPixels / 20);
        this.f2934g = this.f2938k.getInt(f2930c, this.f2940m.widthPixels - this.f2932e);
        this.f2935h = this.f2938k.getInt(f2931d, this.f2940m.heightPixels - this.f2933f);
    }

    /* renamed from: a */
    public void m56433a() {
        if (this.f2941n != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f2942o = layoutParams;
        layoutParams.type = 2032;
        layoutParams.flags = 776;
        layoutParams.format = -2;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.alpha = 0.5f;
        layoutParams.width = this.f2932e;
        layoutParams.height = this.f2933f;
        layoutParams.x = this.f2934g;
        layoutParams.y = this.f2935h;
        ImageView imageView = new ImageView(this.f2936i);
        this.f2941n = imageView;
        imageView.setBackgroundColor(0);
        this.f2941n.setOnClickListener(new View$OnClickListenerC1559g(this));
        this.f2939l.addView(this.f2941n, this.f2942o);
    }
}
