package com.acse.ottn.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.C1239R;
import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.HelpShopAppUtil;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TransparentGreenActivity extends ActivityC1305w {

    /* renamed from: d */
    private RelativeLayout f2170d;

    /* renamed from: e */
    private RelativeLayout f2171e;

    /* renamed from: f */
    private Handler f2172f = new Handler();

    /* renamed from: g */
    private SwitchOnAnimView f2173g;

    /* renamed from: h */
    private SwitchOnAnimView f2174h;

    /* renamed from: i */
    private ImageView f2175i;

    /* renamed from: j */
    private TextView f2176j;

    /* renamed from: k */
    private TextView f2177k;

    /* renamed from: l */
    private TextView f2178l;

    /* renamed from: m */
    private String f2179m;

    /* renamed from: n */
    private TextView f2180n;

    /* renamed from: o */
    TextView f2181o;

    /* renamed from: p */
    AnimatorSet f2182p;

    static {
        StubApp.interface11(4176);
    }

    /* renamed from: a */
    public static Bitmap m57273a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: d */
    public static Bitmap m57266d() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = HelpShopAppUtil.getContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(HelpShopAppUtil.getContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return m57273a(packageManager.getApplicationIcon(applicationInfo));
    }

    /* renamed from: f */
    private void m57264f() {
        C1633I.m56254a().m56248a(this, this.f2180n);
        this.f2179m = C1633I.m56254a().m56238e(this);
    }

    /* renamed from: g */
    private void m57263g() {
        ((TextView) findViewById(C1239R.C1242id.tv_step)).setText(Html.fromHtml("滑动列表找到“<font color=" + this.f2179m + ">" + CommonUtil.appName + "</font>”"));
        Spanned fromHtml = Html.fromHtml("👉【<font color=" + this.f2179m + ">" + CommonUtil.appName + "</font>】—请启用🏃");
        TextView textView = (TextView) findViewById(C1239R.C1242id.tv_permission_name);
        this.f2181o = textView;
        textView.setText(fromHtml);
        this.f2178l = (TextView) findViewById(C1239R.C1242id.tv_permission);
        ((TextView) findViewById(C1239R.C1242id.tv_step_two)).setText(Html.fromHtml("第二步：滑动列表，找到“<font color=" + this.f2179m + ">" + CommonUtil.appName + "</font>”"));
        this.f2176j = (TextView) findViewById(C1239R.C1242id.tv_step_one);
        StringBuilder sb = new StringBuilder();
        sb.append("第一步：滑动列表，打开“<font color=");
        sb.append(this.f2179m);
        sb.append(">已安装的服务</font>”");
        this.f2176j.setText(Html.fromHtml(sb.toString()));
    }

    /* renamed from: a */
    public void m57272a(ImageView imageView) {
        C1633I.m56254a().m56251a(this, imageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationY", -20.0f, 20.0f, -20.0f);
        ofFloat.setDuration(500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setStartDelay(10000L);
        animatorSet.start();
    }

    /* renamed from: c */
    public String m57267c() {
        return C1663ca.m56080c().m56081b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
        if (r0.equals("oppo") == false) goto L5;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m57265e() {
        /*
            Method dump skipped, instructions count: 822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.activity.TransparentGreenActivity.m57265e():void");
    }

    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.acse.ottn.activity.ActivityC1305w, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnimatorSet animatorSet = this.f2182p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SwitchOnAnimView switchOnAnimView = this.f2173g;
        if (switchOnAnimView != null) {
            switchOnAnimView.m57202b();
            this.f2173g = null;
        }
        SwitchOnAnimView switchOnAnimView2 = this.f2174h;
        if (switchOnAnimView2 != null) {
            switchOnAnimView2.m57202b();
            this.f2174h = null;
        }
        super.onDestroy();
    }
}
