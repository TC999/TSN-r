package com.acse.ottn.receiver;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f6231a = "ScreenLock_Width";

    /* renamed from: b  reason: collision with root package name */
    private static String f6232b = "ScreenLock_Height";

    /* renamed from: c  reason: collision with root package name */
    private static String f6233c = "ScreenLock_PositionX";

    /* renamed from: d  reason: collision with root package name */
    private static String f6234d = "ScreenLock_PositionY";

    /* renamed from: e  reason: collision with root package name */
    private int f6235e;

    /* renamed from: f  reason: collision with root package name */
    private int f6236f;

    /* renamed from: g  reason: collision with root package name */
    private int f6237g;

    /* renamed from: h  reason: collision with root package name */
    private int f6238h;

    /* renamed from: i  reason: collision with root package name */
    private Context f6239i;

    /* renamed from: j  reason: collision with root package name */
    private DevicePolicyManager f6240j;

    /* renamed from: k  reason: collision with root package name */
    private SharedPreferences f6241k;

    /* renamed from: l  reason: collision with root package name */
    private WindowManager f6242l;

    /* renamed from: m  reason: collision with root package name */
    private DisplayMetrics f6243m = new DisplayMetrics();

    /* renamed from: n  reason: collision with root package name */
    private ImageView f6244n;

    /* renamed from: o  reason: collision with root package name */
    private WindowManager.LayoutParams f6245o;

    /* renamed from: p  reason: collision with root package name */
    private View f6246p;

    public h(Context context) {
        this.f6239i = context;
        this.f6240j = (DevicePolicyManager) context.getSystemService("device_policy");
        this.f6242l = (WindowManager) context.getSystemService("window");
        this.f6241k = context.getSharedPreferences(context.getPackageName(), 0);
        this.f6242l.getDefaultDisplay().getRealMetrics(this.f6243m);
        this.f6235e = this.f6241k.getInt(f6231a, this.f6243m.widthPixels / 20);
        this.f6236f = this.f6241k.getInt(f6232b, this.f6243m.widthPixels / 20);
        this.f6237g = this.f6241k.getInt(f6233c, this.f6243m.widthPixels - this.f6235e);
        this.f6238h = this.f6241k.getInt(f6234d, this.f6243m.heightPixels - this.f6236f);
    }

    public void a() {
        if (this.f6244n != null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f6245o = layoutParams;
        layoutParams.type = 2032;
        layoutParams.flags = 776;
        layoutParams.format = -2;
        layoutParams.gravity = 8388659;
        layoutParams.alpha = 0.5f;
        layoutParams.width = this.f6235e;
        layoutParams.height = this.f6236f;
        layoutParams.x = this.f6237g;
        layoutParams.y = this.f6238h;
        ImageView imageView = new ImageView(this.f6239i);
        this.f6244n = imageView;
        imageView.setBackgroundColor(0);
        this.f6244n.setOnClickListener(new g(this));
        this.f6242l.addView(this.f6244n, this.f6245o);
    }
}
