package cn.jpush.android.x;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.SchedulerReceiver;
import cn.jpush.android.x.b;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f4537a;

    /* renamed from: b  reason: collision with root package name */
    private LinkedList<a> f4538b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<a> f4539c;

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<a> f4540d = new Comparator<a>() { // from class: cn.jpush.android.x.e.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.f4542a < aVar2.f4542a) {
                return -1;
            }
            return aVar.f4542a == aVar2.f4542a ? 0 : 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f4542a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4543b;

        /* renamed from: c  reason: collision with root package name */
        private cn.jpush.android.d.d f4544c;

        /* renamed from: d  reason: collision with root package name */
        private int f4545d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4546e;

        public a(long j4, int i4) {
            this.f4542a = j4;
            this.f4543b = false;
            this.f4545d = i4;
        }

        public a(long j4, cn.jpush.android.d.d dVar, boolean z3) {
            this.f4542a = j4;
            this.f4543b = true;
            this.f4544c = dVar;
            this.f4546e = z3;
        }

        public a(JSONObject jSONObject) {
            try {
                this.f4542a = jSONObject.getLong("operationTime");
                this.f4543b = jSONObject.optBoolean("showOrDismiss");
                String optString = jSONObject.optString("pushEntity");
                if (!TextUtils.isEmpty(optString)) {
                    this.f4544c = cn.jpush.android.d.d.b(optString);
                }
                this.f4545d = jSONObject.optInt("notifyId");
            } catch (Throwable unused) {
            }
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operationTime", this.f4542a);
                jSONObject.put("showOrDismiss", this.f4543b);
                if (this.f4543b) {
                    cn.jpush.android.d.d dVar = this.f4544c;
                    jSONObject.put("pushEntity", dVar != null ? dVar.c() : null);
                } else {
                    jSONObject.put("notifyId", this.f4545d);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "Item{operationTime=" + this.f4542a + ", showOrDismiss=" + this.f4543b + ", pushEntity=" + this.f4544c + ", notifyId=" + this.f4545d + ", isDelayByInapp=" + this.f4546e + '}';
        }
    }

    private e() {
    }

    public static e a() {
        if (f4537a == null) {
            synchronized (e.class) {
                if (f4537a == null) {
                    f4537a = new e();
                }
            }
        }
        return f4537a;
    }

    private static void a(Context context, LinkedList<a> linkedList, long j4, a aVar) {
        String str;
        if (aVar == null) {
            return;
        }
        if (aVar.f4544c != null && TextUtils.equals(aVar.f4544c.J, "ssp")) {
            str = "ssp notification message";
        } else if (aVar.f4542a > j4) {
            linkedList.add(aVar);
            return;
        } else if (!aVar.f4543b) {
            Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
            b.d(context, aVar.f4545d);
            return;
        } else if (aVar.f4544c == null || !d.a(context, aVar.f4544c.f4127d, aVar.f4544c.f4131h)) {
            long b4 = cn.jpush.android.ad.b.b(aVar.f4544c.av);
            int a4 = b.a(aVar.f4544c);
            if (b4 <= 0) {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                b.a.a(context, aVar.f4544c);
                return;
            } else if (b4 <= j4) {
                Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
                b.d(context, a4);
                return;
            } else {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                b.a.a(context, aVar.f4544c);
                linkedList.add(new a(b4, a4));
                return;
            }
        } else {
            str = "item: " + aVar + " already cancel";
        }
        Logger.d("NotificationScheduler", str);
    }

    private void b(Context context, a aVar) {
        try {
            Logger.d("NotificationScheduler", "schedule item=" + aVar);
            Intent intent = new Intent(context, SchedulerReceiver.class);
            intent.setAction(SchedulerReceiver.DELAY_NOTIFY);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1000, intent, TTAdConstant.KEY_CLICK_AREA);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setWindow(0, aVar.f4542a, 300L, broadcast);
                } else {
                    alarmManager.set(0, aVar.f4542a, broadcast);
                }
                Logger.d("NotificationScheduler", "setAlarm at=" + cn.jpush.android.ad.b.a("yyyy-MM-dd HH:mm:ss").format(new Date(aVar.f4542a)));
            }
        } catch (Throwable th) {
            Logger.ww("NotificationScheduler", "can't trigger alarm cause by exception:" + th);
        }
    }

    public void a(Context context) {
        this.f4538b = new LinkedList<>();
        if (this.f4539c == null) {
            this.f4539c = new LinkedList<>();
        }
        String str = (String) Sp.get(context, Key.NotiSchedule());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    this.f4538b.add(new a(jSONArray.getJSONObject(i4)));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f4539c.size() > 0) {
            this.f4538b.addAll(this.f4539c);
            this.f4539c.clear();
            Collections.sort(this.f4538b, this.f4540d);
        }
    }

    public synchronized void a(Context context, a aVar) {
        a(context);
        LinkedList<a> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z3 = aVar != null;
        Iterator<a> it = this.f4538b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (z3 && next.f4542a > aVar.f4542a) {
                a(context, linkedList, currentTimeMillis, aVar);
                z3 = false;
            }
            a(context, linkedList, currentTimeMillis, next);
        }
        if (z3) {
            a(context, linkedList, currentTimeMillis, aVar);
        }
        this.f4538b = linkedList;
        b(context);
        if (!linkedList.isEmpty()) {
            b(context, linkedList.getFirst());
        }
    }

    public void b(Context context) {
        if (this.f4538b != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = this.f4538b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f4546e) {
                    this.f4539c.add(next);
                } else {
                    jSONArray.put(next.a());
                }
            }
            String jSONArray2 = jSONArray.toString();
            Collections.sort(this.f4538b, this.f4540d);
            Sp.set(context, Key.NotiSchedule().set(jSONArray2));
        }
    }
}
