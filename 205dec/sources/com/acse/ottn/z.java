package com.acse.ottn;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class z extends AppCompatActivity {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7006d = "BaseActivity";

    /* renamed from: a  reason: collision with root package name */
    public Toast f7007a;

    /* renamed from: b  reason: collision with root package name */
    public long f7008b = 0;

    /* renamed from: c  reason: collision with root package name */
    public AppCompatActivity f7009c;

    public void a(AppCompatActivity appCompatActivity) {
        this.f7009c = appCompatActivity;
    }

    public void b() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
        p.c(this);
    }

    public void c(Intent intent) {
        p.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f7009c != null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(TTAdConstant.KEY_CLICK_AREA);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
            return;
        }
        a();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (b(this)) {
            a((Activity) this);
        }
        super.onCreate(bundle);
        setRequestedOrientation(1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Toast toast = this.f7007a;
        if (toast != null) {
            toast.cancel();
            this.f7007a = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f7007a;
        if (toast != null) {
            toast.cancel();
            this.f7007a = null;
        }
        o.f6074l = Boolean.FALSE;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        o.f6074l = Boolean.TRUE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        z1.b("Memory", "max:" + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + " total:" + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + " free:" + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + " ");
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i4) {
        if (b(this)) {
            return;
        }
        super.setRequestedOrientation(i4);
    }

    public void a() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
        p.c(this);
    }

    public void b(Intent intent) {
        p.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
    }

    public void a(Intent intent) {
        finish();
        p.c(this);
        c(intent);
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
    }

    public static boolean b(Activity activity) {
        Exception e4;
        boolean z3;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z3 = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e5) {
                e4 = e5;
                e4.printStackTrace();
                return z3;
            }
        } catch (Exception e6) {
            e4 = e6;
            z3 = false;
        }
        return z3;
    }

    public void a(Intent intent, int i4) {
        p.c(this);
        startActivityForResult(intent, i4);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    public void a(int i4) {
        Window window = getWindow();
        a(this, i4, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public void a(Activity activity, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        b4.b(activity, i4, i5);
    }

    public void a(boolean z3) {
        if (z3) {
            getWindow().getDecorView().setSystemUiVisibility(1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
        }
    }

    public static boolean a(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
