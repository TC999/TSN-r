package cn.jiguang.analytics.page;

import android.app.Application;
import android.app.TabActivity;
import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bq.d;
import cn.jiguang.bs.f;
import cn.jiguang.cm.b;
import cn.jiguang.f.g;
import com.stub.StubApp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PushSA {
    public static final String CACHE_PATH = "push_stat_cache.json";
    private static final String KEY_SESSION_ID = "session_id";
    public static final String REPORT_ACTIVE_LAUNCH = "active_launch";
    public static final String REPORT_ACTIVE_TERMINATE = "active_terminate";
    private static final String TAG = "PushSA";
    private static volatile PushSA instance;
    public static boolean isOnPauseInvoke;
    public static boolean isOnResumeInvoke;
    private String cur_activity = null;
    private String cur_session_id = null;
    private long interval = 30;
    private long latestResumeTime = 0;
    private long latestPauseTime = 0;
    private boolean firstResume = true;
    private boolean activitySwitch = false;
    private boolean stat_enable = true;
    private long tempTimelong = 0;
    private JSONObject flow_cache = null;
    private final Object cur_session_file_lock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        boolean f2324a;

        /* renamed from: b  reason: collision with root package name */
        Context f2325b;

        /* renamed from: c  reason: collision with root package name */
        PushSA f2326c;

        public a(boolean z3, Context context, PushSA pushSA) {
            this.f2324a = z3;
            this.f2325b = context;
            this.f2326c = pushSA;
            this.f3462h = PushSA.TAG;
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            try {
                if (this.f2324a) {
                    this.f2326c.sendLogRoutine(this.f2325b);
                } else {
                    this.f2326c.saveLogRoutine(this.f2325b);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private PushSA() {
    }

    private void clearCurrentLogFile(Context context) {
        f.a(context, CACHE_PATH, (JSONObject) null);
    }

    private JSONObject createNewSession(Context context, long j4) {
        this.cur_session_id = generateSessionID(context, j4);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.M().a((cn.jiguang.g.a<Long>) Long.valueOf(this.latestResumeTime)), cn.jiguang.g.a.P().a((cn.jiguang.g.a<String>) this.cur_session_id));
        JSONObject jSONObject = new JSONObject();
        try {
            wrapDate(jSONObject);
            cn.jiguang.d.a.a(context, jSONObject, REPORT_ACTIVE_LAUNCH);
            jSONObject.put("session_id", this.cur_session_id);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private String generateSessionID(Context context, long j4) {
        StringBuilder sb = new StringBuilder();
        String e4 = cn.jiguang.d.a.e(context);
        if (!TextUtils.isEmpty(e4)) {
            sb.append(e4);
        }
        sb.append(j4);
        return g.d(sb.toString());
    }

    private JSONObject getFlowCache(Context context) {
        if (this.flow_cache == null) {
            this.flow_cache = cn.jiguang.d.a.a(context, CACHE_PATH);
        }
        return this.flow_cache;
    }

    public static PushSA getInstance() {
        if (instance == null) {
            synchronized (PushSA.class) {
                instance = new PushSA();
            }
        }
        return instance;
    }

    private boolean invokeCheck(Context context, String str) {
        if (!this.stat_enable) {
            d.f(TAG, "stat function has been disabled");
            return false;
        } else if (context == null) {
            d.f(TAG, "context is null");
            return false;
        } else if (context instanceof Application) {
            d.m(TAG, "Context should be an Activity on this method : " + str);
            return false;
        } else {
            return true;
        }
    }

    private boolean isNewSession(Context context) {
        if (this.firstResume) {
            this.firstResume = false;
            d.c(TAG, "statistics start");
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.O())).longValue();
            d.c(TAG, "lastPause:" + longValue + ",latestResumeTime:" + this.latestResumeTime + ",interval:" + (this.interval * 1000) + ",a:" + (this.latestResumeTime - longValue));
            if (longValue > 0 && this.latestResumeTime - longValue <= this.interval * 1000) {
                return false;
            }
        } else if (this.latestResumeTime - this.latestPauseTime <= this.interval * 1000) {
            return false;
        }
        return true;
    }

    private void saveCurrentLog(Context context, JSONObject jSONObject) {
        f.a(context, CACHE_PATH, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLogRoutine(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.cur_session_file_lock) {
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.O().a((cn.jiguang.g.a<Long>) Long.valueOf(this.latestPauseTime)), cn.jiguang.g.a.N().a((cn.jiguang.g.a<Long>) Long.valueOf(this.latestPauseTime)));
            if (cn.jiguang.cn.a.d(context)) {
                JSONObject flowCache = getFlowCache(context);
                if (flowCache == null) {
                    flowCache = new JSONObject();
                }
                try {
                    updateFlowInfo(flowCache, context);
                } catch (Exception unused) {
                }
                updateFlowCache(flowCache);
                saveCurrentLog(context, flowCache);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLogRoutine(Context context) {
        JSONObject flowCache;
        if (!isNewSession(context)) {
            this.cur_session_id = (String) cn.jiguang.g.b.b(context, cn.jiguang.g.a.P());
            return;
        }
        d.f(TAG, "new statistics session");
        JSONArray jSONArray = new JSONArray();
        JSONObject createNewSession = createNewSession(context, this.latestResumeTime);
        if (createNewSession != null) {
            jSONArray.put(createNewSession);
        }
        synchronized (this.cur_session_file_lock) {
            flowCache = getFlowCache(context);
            if (flowCache != null && flowCache.length() > 0) {
                try {
                    cn.jiguang.d.a.a(context, flowCache, REPORT_ACTIVE_TERMINATE);
                } catch (Exception unused) {
                }
                clearCurrentLogFile(context);
                this.flow_cache = null;
            }
        }
        if (flowCache != null && flowCache.length() > 0 && cn.jiguang.cn.a.d(context)) {
            jSONArray.put(flowCache);
        }
        cn.jiguang.d.a.a(context, jSONArray);
    }

    private void updateFlowCache(JSONObject jSONObject) {
        this.flow_cache = jSONObject;
    }

    private void updateFlowInfo(JSONObject jSONObject, Context context) {
        long j4;
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.M())).longValue();
        if (longValue <= 0) {
            long j5 = this.latestPauseTime - this.tempTimelong;
            j4 = j5 > 0 ? j5 / 1000 : 10L;
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.M().a((cn.jiguang.g.a<Long>) Long.valueOf(this.tempTimelong)));
        } else {
            j4 = (this.latestPauseTime - longValue) / 1000;
        }
        jSONObject.put("duration", j4);
        jSONObject.put("itime", System.currentTimeMillis() / 1000);
        jSONObject.put("session_id", this.cur_session_id);
        wrapDate(jSONObject);
    }

    private void wrapDate(JSONObject jSONObject) {
        String b4 = cn.jiguang.f.b.b();
        String str = b4.split("_")[0];
        String str2 = b4.split("_")[1];
        jSONObject.put("date", str);
        jSONObject.put("time", str2);
    }

    public long getInterval() {
        return this.interval;
    }

    public boolean isStatEnable() {
        return this.stat_enable;
    }

    public void onFragmentPause(Context context, String str) {
        if (!this.activitySwitch) {
            d.c(TAG, "JCoreInterface.onPause() must be called after called JCoreInterface.onResume() in this Activity or Fragment");
            return;
        }
        this.activitySwitch = false;
        String str2 = this.cur_activity;
        if (str2 == null || !str2.equals(str)) {
            d.m(TAG, "page name didn't match the last one passed by onResume");
            return;
        }
        this.latestPauseTime = System.currentTimeMillis();
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            cn.jiguang.cm.d.a("SCHEDULE_TASK", new b("PushSA#onFragmentPause") { // from class: cn.jiguang.analytics.page.PushSA.2
                @Override // cn.jiguang.cm.b
                public void a() {
                    try {
                        PushSA.this.saveLogRoutine(origApplicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onFragmentResume(Context context, String str) {
        if (this.activitySwitch) {
            d.c(TAG, "JCoreInterface.onResume() must be called after called JCoreInterface.onPause() in last Activity or Fragment");
            return;
        }
        this.activitySwitch = true;
        this.cur_activity = str;
        this.latestResumeTime = System.currentTimeMillis();
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            cn.jiguang.cm.d.a("SCHEDULE_TASK", new b("PushSA#onFragmentResume") { // from class: cn.jiguang.analytics.page.PushSA.1
                @Override // cn.jiguang.cm.b
                public void a() {
                    try {
                        PushSA.this.sendLogRoutine(origApplicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onKillProcess(Context context) {
        try {
            if (this.cur_activity == null || !this.activitySwitch) {
                return;
            }
            this.latestPauseTime = System.currentTimeMillis();
            final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            cn.jiguang.cm.d.a("SCHEDULE_TASK", new b("PushSA#onKillProcess") { // from class: cn.jiguang.analytics.page.PushSA.3
                @Override // cn.jiguang.cm.b
                public void a() {
                    try {
                        PushSA.this.saveLogRoutine(origApplicationContext);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void onPause(Context context) {
        if (invokeCheck(context, "onPause")) {
            isOnPauseInvoke = true;
            try {
                TabActivity tabActivity = (TabActivity) context;
                this.activitySwitch = true;
            } catch (ClassCastException | Exception unused) {
            }
            if (this.activitySwitch) {
                this.activitySwitch = false;
                String str = this.cur_activity;
                if (str == null || !str.equals(context.getClass().getName())) {
                    d.f(TAG, "the activity pass by onPause didn't match last one passed by onResume");
                    return;
                }
                this.latestPauseTime = System.currentTimeMillis();
                this.tempTimelong = this.latestResumeTime;
                try {
                    cn.jiguang.cm.d.a("SCHEDULE_TASK", new a(false, StubApp.getOrigApplicationContext(context.getApplicationContext()), this));
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void onResume(Context context) {
        if (invokeCheck(context, "onResume")) {
            isOnResumeInvoke = true;
            try {
                TabActivity tabActivity = (TabActivity) context;
                this.activitySwitch = false;
            } catch (ClassCastException | Exception unused) {
            }
            if (this.activitySwitch) {
                return;
            }
            this.activitySwitch = true;
            this.latestResumeTime = System.currentTimeMillis();
            this.cur_activity = context.getClass().getName();
            try {
                cn.jiguang.cm.d.a("SCHEDULE_TASK", new a(true, StubApp.getOrigApplicationContext(context.getApplicationContext()), this));
            } catch (Throwable unused2) {
            }
        }
    }

    public void setInterval(long j4) {
        this.interval = j4;
    }

    public void setStatEnable(boolean z3) {
        this.stat_enable = z3;
    }
}
