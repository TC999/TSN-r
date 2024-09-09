package cn.jiguang.bx;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.JConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f3151a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3152b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Map<Long, String> f3153c = new HashMap();

    public static k a() {
        if (f3151a == null) {
            synchronized (f3152b) {
                if (f3151a == null) {
                    f3151a = new k();
                }
            }
        }
        return f3151a;
    }

    private String a(Context context, String str, String str2) {
        String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(str));
        if (TextUtils.isEmpty(str2) || str2.equals(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("need not ");
            sb.append(str);
            sb.append(" userctrl,newest version:");
            if (TextUtils.isEmpty(str2)) {
                str2 = "null";
            }
            sb.append(str2);
            cn.jiguang.bq.d.a("UserCtrlHelper", sb.toString());
            return "";
        }
        return str2;
    }

    private void a(Context context, short s3, String str, String str2) {
        cn.jiguang.bq.d.c("UserCtrlHelper", "sendUserCtrlInfo sdkType:" + str2 + ",property:" + ((int) s3) + ",verInfo:" + str);
        long b4 = j.b();
        cn.jiguang.bt.b.a(context, JConstants.SDK_TYPE, 26, 0, b4, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, cn.jiguang.bz.b.a(s3, (short) 1, str));
        this.f3153c.put(Long.valueOf(b4), str2);
    }

    public void a(Context context) {
        if (context == null) {
            cn.jiguang.bq.d.i("UserCtrlHelper", "handleUserCtrl failed,context is null");
            return;
        }
        HashMap<String, JDispatchAction> hashMap = b.f3080a;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                String a4 = a(context, entry.getKey(), value.getSdkVersion(entry.getKey()));
                if (!TextUtils.isEmpty(a4)) {
                    a(context, value.getUserCtrlProperty(entry.getKey()), a4, entry.getKey());
                }
            }
        }
    }

    public void a(Context context, long j4) {
        String str;
        Map<Long, String> map;
        String remove = this.f3153c.remove(Long.valueOf(j4));
        if (TextUtils.isEmpty(remove)) {
            str = "userCtrlSuccess but not found rid:" + j4;
        } else {
            cn.jiguang.bq.d.c("UserCtrlHelper", "userCtrlSuccess rid:" + j4 + ",sdkType:" + remove);
            String b4 = b.a().b(remove, "");
            if (!TextUtils.isEmpty(b4)) {
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(remove).a((cn.jiguang.g.a<String>) b4));
                map = this.f3153c;
                if (map == null && map.isEmpty() && !cn.jiguang.bk.c.a().a(context)) {
                    h.a().a(context, "tcp_a21", null);
                    return;
                }
                return;
            }
            str = "userCtrlSuccess but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.bq.d.c("UserCtrlHelper", str);
        map = this.f3153c;
        if (map == null) {
        }
    }

    public void a(Context context, long j4, int i4) {
        String str;
        String remove = this.f3153c.remove(Long.valueOf(j4));
        if (TextUtils.isEmpty(remove)) {
            str = "onUserCtrlFailed but not found rid:" + j4;
        } else {
            cn.jiguang.bq.d.c("UserCtrlHelper", "onUserCtrlFailed rid:" + j4 + ",sdkType:" + remove + ",errorCode:" + i4);
            if (!TextUtils.isEmpty(b.a().b(remove, ""))) {
                return;
            }
            str = "onUserCtrlFailed but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.bq.d.c("UserCtrlHelper", str);
    }

    public void b(Context context, long j4) {
        cn.jiguang.bq.d.c("UserCtrlHelper", "onUserCtrlTimeout rid:" + j4);
        this.f3153c.remove(Long.valueOf(j4));
    }

    public boolean b(Context context) {
        if (context == null) {
            cn.jiguang.bq.d.j("UserCtrlHelper", "get isNeedUserCtrl failed,context is null");
            return false;
        }
        HashMap<String, JDispatchAction> hashMap = b.f3080a;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(a(context, entry.getKey(), value.getSdkVersion(entry.getKey())))) {
                    return true;
                }
            }
        }
        return false;
    }
}
