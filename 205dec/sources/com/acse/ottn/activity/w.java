package com.acse.ottn.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.R;
import com.acse.ottn.util.Ja;
import com.acse.ottn.util.ra;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class w extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    /* renamed from: a  reason: collision with root package name */
    private Toast f4757a;

    /* renamed from: b  reason: collision with root package name */
    private long f4758b = 0;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatActivity f4759c;

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

    public static boolean b(Activity activity) {
        Exception e4;
        boolean z3 = false;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e5) {
                e4 = e5;
                z3 = booleanValue;
                e4.printStackTrace();
                return z3;
            }
        } catch (Exception e6) {
            e4 = e6;
        }
    }

    public void a() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
        com.acse.ottn.e.b.c(this);
    }

    public void a(int i4) {
        Window window = getWindow();
        a(this, i4, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public void a(Activity activity, @ColorInt int i4, @IntRange(from = 0, to = 255) int i5) {
        Ja.a(activity, i4, i5);
    }

    public void a(Intent intent) {
        finish();
        com.acse.ottn.e.b.c(this);
        c(intent);
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_right);
    }

    public void a(Intent intent, int i4) {
        com.acse.ottn.e.b.c(this);
        startActivityForResult(intent, i4);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    public void a(AppCompatActivity appCompatActivity) {
        this.f4759c = appCompatActivity;
    }

    public void a(boolean z3) {
        View decorView;
        int i4;
        if (z3) {
            decorView = getWindow().getDecorView();
            i4 = 1024;
        } else {
            decorView = getWindow().getDecorView();
            i4 = AVMDLDataLoader.KeyIsLoaderCacheSize;
        }
        decorView.setSystemUiVisibility(i4);
    }

    public void b() {
        finish();
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
        com.acse.ottn.e.b.c(this);
    }

    public void b(Intent intent) {
        com.acse.ottn.e.b.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_bottom, R.anim.slide_out_from_top);
    }

    public void c(Intent intent) {
        com.acse.ottn.e.b.c(this);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_from_left);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f4759c == null) {
            a();
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(TTAdConstant.KEY_CLICK_AREA);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (b(this)) {
            a((Activity) this);
        }
        super.onCreate(bundle);
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Toast toast = this.f4757a;
        if (toast != null) {
            toast.cancel();
            this.f4757a = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f4757a;
        if (toast != null) {
            toast.cancel();
            this.f4757a = null;
        }
        com.acse.ottn.e.a.f5624l = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.acse.ottn.e.a.f5624l = Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ra.b("Memory", "max:" + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + " total:" + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + " free:" + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + " ");
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i4) {
        if (b(this)) {
            return;
        }
        super.setRequestedOrientation(i4);
    }
}
