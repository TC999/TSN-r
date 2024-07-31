package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* renamed from: cn.bluemobi.dylan.base.utils.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ImmersionUtil {

    /* renamed from: a */
    private Activity f1811a;

    public ImmersionUtil(Activity activity) {
        this.f1811a = activity;
    }

    /* renamed from: a */
    public void m57734a() {
        Window window = this.f1811a.getWindow();
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            window.addFlags(67108864);
            window.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
            if (i >= 21) {
                window.getDecorView().setSystemUiVisibility(1024);
                window.clearFlags(67108864);
                window.setStatusBarColor(0);
            }
        }
    }
}
