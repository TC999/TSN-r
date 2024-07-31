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
import com.acse.ottn.C1239R;
import com.acse.ottn.p045e.C1551a;
import com.acse.ottn.p045e.C1552b;
import com.acse.ottn.util.C1636Ja;
import com.acse.ottn.util.C1694ra;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.acse.ottn.activity.w */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ActivityC1305w extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    /* renamed from: a */
    private Toast f2206a;

    /* renamed from: b */
    private long f2207b = 0;

    /* renamed from: c */
    private AppCompatActivity f2208c;

    /* renamed from: a */
    public static boolean m57259a(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m57252b(Activity activity) {
        Exception e;
        boolean z = false;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            boolean booleanValue = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return booleanValue;
            } catch (Exception e2) {
                e = e2;
                z = booleanValue;
                e.printStackTrace();
                return z;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* renamed from: a */
    public void m57261a() {
        finish();
        overridePendingTransition(C1239R.anim.slide_in_from_left, C1239R.anim.slide_out_from_right);
        C1552b.m56440c(this);
    }

    /* renamed from: a */
    public void mo57260a(int i) {
        Window window = getWindow();
        m57258a(this, i, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(PredefinedCaptureConfigurations.f24405o);
    }

    /* renamed from: a */
    public void m57258a(Activity activity, @ColorInt int i, @IntRange(from = 0, m60035to = 255) int i2) {
        C1636Ja.m56229a(activity, i, i2);
    }

    /* renamed from: a */
    public void m57257a(Intent intent) {
        finish();
        C1552b.m56440c(this);
        m57250c(intent);
        overridePendingTransition(C1239R.anim.slide_in_from_left, C1239R.anim.slide_out_from_right);
    }

    /* renamed from: a */
    public void m57256a(Intent intent, int i) {
        C1552b.m56440c(this);
        startActivityForResult(intent, i);
        overridePendingTransition(C1239R.anim.slide_in_from_right, C1239R.anim.slide_out_from_left);
    }

    /* renamed from: a */
    public void m57255a(AppCompatActivity appCompatActivity) {
        this.f2208c = appCompatActivity;
    }

    /* renamed from: a */
    public void m57254a(boolean z) {
        View decorView;
        int i;
        if (z) {
            decorView = getWindow().getDecorView();
            i = 1024;
        } else {
            decorView = getWindow().getDecorView();
            i = 9216;
        }
        decorView.setSystemUiVisibility(i);
    }

    /* renamed from: b */
    public void m57253b() {
        finish();
        overridePendingTransition(C1239R.anim.slide_in_from_bottom, C1239R.anim.slide_out_from_top);
        C1552b.m56440c(this);
    }

    /* renamed from: b */
    public void m57251b(Intent intent) {
        C1552b.m56440c(this);
        startActivity(intent);
        overridePendingTransition(C1239R.anim.slide_in_from_bottom, C1239R.anim.slide_out_from_top);
    }

    /* renamed from: c */
    public void m57250c(Intent intent) {
        C1552b.m56440c(this);
        startActivity(intent);
        overridePendingTransition(C1239R.anim.slide_in_from_right, C1239R.anim.slide_out_from_left);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f2208c == null) {
            m57261a();
            return;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(67108864);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (m57252b(this)) {
            m57259a((Activity) this);
        }
        super.onCreate(bundle);
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Toast toast = this.f2206a;
        if (toast != null) {
            toast.cancel();
            this.f2206a = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Toast toast = this.f2206a;
        if (toast != null) {
            toast.cancel();
            this.f2206a = null;
        }
        C1551a.f2895l = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C1551a.f2895l = Boolean.TRUE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        C1694ra.m55915b("Memory", "max:" + ((Runtime.getRuntime().maxMemory() / 1024) / 1024) + " total:" + ((Runtime.getRuntime().totalMemory() / 1024) / 1024) + " free:" + ((Runtime.getRuntime().freeMemory() / 1024) / 1024) + " ");
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (m57252b(this)) {
            return;
        }
        super.setRequestedOrientation(i);
    }
}
