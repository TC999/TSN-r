package com.acse.ottn;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q3 {

    /* renamed from: m  reason: collision with root package name */
    public static String f6168m = "ScreenLock_Width";

    /* renamed from: n  reason: collision with root package name */
    public static String f6169n = "ScreenLock_Height";

    /* renamed from: o  reason: collision with root package name */
    public static String f6170o = "ScreenLock_PositionX";

    /* renamed from: p  reason: collision with root package name */
    public static String f6171p = "ScreenLock_PositionY";

    /* renamed from: a  reason: collision with root package name */
    public int f6172a;

    /* renamed from: b  reason: collision with root package name */
    public int f6173b;

    /* renamed from: c  reason: collision with root package name */
    public int f6174c;

    /* renamed from: d  reason: collision with root package name */
    public int f6175d;

    /* renamed from: e  reason: collision with root package name */
    public Context f6176e;

    /* renamed from: f  reason: collision with root package name */
    public DevicePolicyManager f6177f;

    /* renamed from: g  reason: collision with root package name */
    public SharedPreferences f6178g;

    /* renamed from: h  reason: collision with root package name */
    public WindowManager f6179h;

    /* renamed from: i  reason: collision with root package name */
    public DisplayMetrics f6180i = new DisplayMetrics();

    /* renamed from: j  reason: collision with root package name */
    public ImageView f6181j;

    /* renamed from: k  reason: collision with root package name */
    public WindowManager.LayoutParams f6182k;

    /* renamed from: l  reason: collision with root package name */
    public View f6183l;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public long f6184a = System.currentTimeMillis();

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f6184a = System.currentTimeMillis();
        }
    }

    public q3(Context context) {
        this.f6176e = context;
        this.f6177f = (DevicePolicyManager) context.getSystemService("device_policy");
        this.f6179h = (WindowManager) context.getSystemService("window");
        this.f6178g = context.getSharedPreferences(context.getPackageName(), 0);
        this.f6179h.getDefaultDisplay().getRealMetrics(this.f6180i);
        this.f6172a = this.f6178g.getInt(f6168m, this.f6180i.widthPixels / 20);
        this.f6173b = this.f6178g.getInt(f6169n, this.f6180i.widthPixels / 20);
        this.f6174c = this.f6178g.getInt(f6170o, this.f6180i.widthPixels - this.f6172a);
        this.f6175d = this.f6178g.getInt(f6171p, this.f6180i.heightPixels - this.f6173b);
    }

    public void a() {
        if (this.f6181j != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f6182k = layoutParams;
        layoutParams.type = 2032;
        layoutParams.flags = 776;
        layoutParams.format = -2;
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 0.5f;
        layoutParams.width = this.f6172a;
        layoutParams.height = this.f6173b;
        layoutParams.x = this.f6174c;
        layoutParams.y = this.f6175d;
        ImageView imageView = new ImageView(this.f6176e);
        this.f6181j = imageView;
        imageView.setBackgroundColor(0);
        this.f6181j.setOnClickListener(new a());
        this.f6179h.addView(this.f6181j, this.f6182k);
    }
}
