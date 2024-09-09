package cn.jpush.android.aa;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.f;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.c;
import com.stub.StubApp;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3898a;

    /* renamed from: b  reason: collision with root package name */
    private cn.jpush.android.aa.b f3899b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: cn.jpush.android.aa.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0066a extends f {

        /* renamed from: b  reason: collision with root package name */
        private String f3901b;

        public C0066a(String str) {
            this.f3901b = str;
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            if (!TextUtils.isEmpty(this.f3901b)) {
                a.this.f3899b.a(this.f3901b);
                return;
            }
            Map<String, Integer> a4 = a.this.f3899b.a();
            if (a4 == null || a4.size() <= 0) {
                return;
            }
            Sp.set(a.this.f3898a, Key.LastReportApiStatisticTime().set(Long.valueOf(System.currentTimeMillis())));
            if (c.a(a.this.f3898a, a4)) {
                a.this.f3899b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f3902a = new a();
    }

    private a() {
    }

    public static final a a() {
        return b.f3902a;
    }

    public void a(Context context) {
        if (this.f3898a == null || this.f3899b == null) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f3898a = origApplicationContext;
            this.f3899b = new cn.jpush.android.aa.b(origApplicationContext);
        }
    }

    public void a(Context context, String str) {
        String str2;
        a(context);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1589456679:
                if (str.equals("clear_all_notify")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1346339041:
                if (str.equals("set_mobile")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1258365551:
                if (str.equals("clear_by_id")) {
                    c4 = 2;
                    break;
                }
                break;
            case -834809288:
                if (str.equals("is_enable")) {
                    c4 = 3;
                    break;
                }
                break;
            case -653414577:
                if (str.equals("clear_local_notify")) {
                    c4 = 4;
                    break;
                }
                break;
            case -370069005:
                if (str.equals("geo_interval")) {
                    c4 = 5;
                    break;
                }
                break;
            case -98347653:
                if (str.equals("add_local_notify")) {
                    c4 = 6;
                    break;
                }
                break;
            case -63913041:
                if (str.equals("geo_fence_max_num")) {
                    c4 = 7;
                    break;
                }
                break;
            case 283445295:
                if (str.equals("delete_geo_fence")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 784590234:
                if (str.equals("go_settings")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1554655777:
                if (str.equals("rm_local_notify")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1833972392:
                if (str.equals("on_check")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                str2 = "JPushInterface#clearAllNotifications";
                break;
            case 1:
                str2 = "JPushInterface#setMobileNumber";
                break;
            case 2:
                str2 = "JPushInterface#clearNotificationById";
                break;
            case 3:
                str2 = "JPushInterface#isNotificationEnabled";
                break;
            case 4:
                str2 = "JPushInterface#clearLocalNotifications";
                break;
            case 5:
                str2 = "JPushInterface#setGeofenceInterval";
                break;
            case 6:
                str2 = "JPushInterface#addLocalNotification";
                break;
            case 7:
                str2 = "JPushInterface#setMaxGeofenceNumber";
                break;
            case '\b':
                str2 = "JPushInterface#deleteGeofence";
                break;
            case '\t':
                str2 = "JPushInterface#goToAppNotificationSettings";
                break;
            case '\n':
                str2 = "JPushInterface#removeLocalNotification";
                break;
            case 11:
                str2 = "JPushMessageReceiver#onNotificationSettingsCheck";
                break;
            default:
                str2 = "";
                break;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Logger.d("JPushApiStatistics", "  statistic api =" + str2);
        JCoreHelper.normalExecutor(this.f3898a, null, new C0066a(str2));
    }

    public void b() {
        long longValue = ((Long) Sp.get(this.f3898a, Key.LastReportApiStatisticTime())).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - longValue);
        if (longValue == 0 || abs >= 86400000) {
            JCoreHelper.normalExecutor(this.f3898a, null, new C0066a(""));
            return;
        }
        Logger.dd("JPushApiStatistics", "Less 24 hours since the last report so return. lastTime=" + longValue + " currentTime=" + currentTimeMillis + " diffTime=" + abs);
    }
}
