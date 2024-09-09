package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ImmersionUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1797a;

    public k(Activity activity) {
        this.f1797a = activity;
    }

    public void a() {
        Window window = this.f1797a.getWindow();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 19) {
            window.addFlags(TTAdConstant.KEY_CLICK_AREA);
            window.addFlags(134217728);
            if (i4 >= 21) {
                window.getDecorView().setSystemUiVisibility(1024);
                window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
                window.setStatusBarColor(0);
            }
        }
    }
}
