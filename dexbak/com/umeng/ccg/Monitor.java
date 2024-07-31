package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.Action;
import com.umeng.analytics.pro.ActionCondition;
import com.umeng.analytics.pro.AplAction;
import com.umeng.analytics.pro.DelayedStartCondition;
import com.umeng.analytics.pro.HourOnCondition;
import com.umeng.analytics.pro.HttpPostDataThread;
import com.umeng.analytics.pro.HttpPostThread;
import com.umeng.analytics.pro.IntervalPeriodCondition;
import com.umeng.analytics.pro.LaunchTimesCondition;
import com.umeng.analytics.pro.Misc;
import com.umeng.analytics.pro.ModelHelper;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.SpWrapper;
import com.umeng.analytics.pro.TimePeriodChain;
import com.umeng.analytics.pro.UMExecutor;
import com.umeng.analytics.pro.WeekOnCondition;
import com.umeng.analytics.pro.ZipUtils;
import com.umeng.ccg.Dispatch;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.ccg.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Monitor implements Dispatch.InterfaceC13189a {

    /* renamed from: a */
    private static final String f38576a = "iucc";

    /* renamed from: b */
    private static final String f38577b = PathCenter.m14695b().m14694b(PathCenter.f37679C);

    /* renamed from: c */
    private static JSONObject f38578c = null;

    /* renamed from: d */
    private static final String[] f38579d = {CcgConstant.f38535f, CcgConstant.f38536g, CcgConstant.f38537h};

    /* renamed from: e */
    private static ArrayList<ActionCondition> f38580e = null;

    /* renamed from: f */
    private static ArrayList<ActionCondition> f38581f = null;

    /* renamed from: g */
    private static ArrayList<ActionCondition> f38582g = null;

    /* renamed from: j */
    private static C13193c f38583j = new C13193c();

    /* renamed from: h */
    private volatile String f38584h = "";

    /* renamed from: i */
    private Map<String, C13191a> f38585i = new HashMap();

    /* compiled from: Monitor.java */
    /* renamed from: com.umeng.ccg.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13191a {

        /* renamed from: b */
        private JSONArray f38588b;

        /* renamed from: c */
        private String f38589c;

        public C13191a(JSONArray jSONArray, String str) {
            this.f38588b = jSONArray;
            this.f38589c = str;
        }

        /* renamed from: a */
        public JSONArray m14071a() {
            return this.f38588b;
        }

        /* renamed from: b */
        public String m14070b() {
            return this.f38589c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Monitor.java */
    /* renamed from: com.umeng.ccg.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13192b {

        /* renamed from: a */
        private static final Monitor f38590a = new Monitor();

        private C13192b() {
        }
    }

    /* compiled from: Monitor.java */
    /* renamed from: com.umeng.ccg.d$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13193c extends BroadcastReceiver {
        /* renamed from: a */
        public long m14068a(ArrayList<ActionCondition> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    ActionCondition actionCondition = arrayList.get(i);
                    if (actionCondition instanceof DelayedStartCondition) {
                        return ((DelayedStartCondition) actionCondition).mo14748c();
                    }
                }
            }
            return 0L;
        }

        /* renamed from: b */
        public boolean m14067b(ArrayList<ActionCondition> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).mo14749b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (m14067b(Monitor.f38580e)) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        Dispatch.m14098a(UMGlobalContext.getAppContext(), 301, Monitor.m14095a(), null, m14068a(Monitor.f38580e) * 1000);
                    } else {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (m14067b(Monitor.f38581f)) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        Dispatch.m14098a(UMGlobalContext.getAppContext(), 302, Monitor.m14095a(), null, m14068a(Monitor.f38581f) * 1000);
                    } else {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (m14067b(Monitor.f38582g)) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                        Dispatch.m14098a(UMGlobalContext.getAppContext(), 303, Monitor.m14095a(), null, m14068a(Monitor.f38582g) * 1000);
                        return;
                    }
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m14093a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f38583j, intentFilter);
    }

    /* renamed from: e */
    private String m14074e(Context context) {
        try {
            SharedPreferences m14703a = SpWrapper.m14703a(context);
            return m14703a != null ? m14703a.getString(SpWrapper.f37669e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    private void m14073f() {
        try {
            SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
            if (m14703a != null) {
                m14703a.edit().putString(SpWrapper.f37670f, new JSONObject(Misc.m14714a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private boolean m14072g() {
        try {
            SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
            if (m14703a != null) {
                return !TextUtils.isEmpty(m14703a.getString(SpWrapper.f37671g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    private long m14081b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* renamed from: c */
    private void m14079c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f38576a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                Dispatch.m14099a(UMGlobalContext.getAppContext(), 107, Monitor.m14095a(), str2);
            }
        });
    }

    /* renamed from: d */
    private Long m14076d(Context context) {
        try {
            SharedPreferences m14703a = SpWrapper.m14703a(context);
            if (m14703a == null) {
                return 0L;
            }
            return Long.valueOf(m14703a.getLong(SpWrapper.f37668d, 0L));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: c */
    private void m14078c(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(CcgConstant.f38530a)) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(CcgConstant.f38530a);
            Action m14087a = optJSONObject.has(CcgConstant.f38531b) ? m14087a(CcgConstant.f38531b, optJSONObject.optJSONObject(CcgConstant.f38531b)) : null;
            Action m14087a2 = optJSONObject.has(CcgConstant.f38532c) ? m14087a(CcgConstant.f38532c, optJSONObject.optJSONObject(CcgConstant.f38532c)) : null;
            Action m14087a3 = optJSONObject.has(CcgConstant.f38533d) ? m14087a(CcgConstant.f38533d, optJSONObject.optJSONObject(CcgConstant.f38533d)) : null;
            Action m14087a4 = optJSONObject.has(CcgConstant.f38534e) ? m14087a(CcgConstant.f38534e, optJSONObject.optJSONObject(CcgConstant.f38534e)) : null;
            Action m14087a5 = optJSONObject.has(CcgConstant.f38535f) ? m14087a(CcgConstant.f38535f, optJSONObject.optJSONObject(CcgConstant.f38535f)) : null;
            Action m14087a6 = optJSONObject.has(CcgConstant.f38536g) ? m14087a(CcgConstant.f38536g, optJSONObject.optJSONObject(CcgConstant.f38536g)) : null;
            Action m14087a7 = optJSONObject.has(CcgConstant.f38537h) ? m14087a(CcgConstant.f38537h, optJSONObject.optJSONObject(CcgConstant.f38537h)) : null;
            ArrayList arrayList = new ArrayList();
            if (m14087a != null) {
                arrayList.add(m14087a);
            }
            if (m14087a2 != null) {
                arrayList.add(m14087a2);
            }
            if (m14087a3 != null) {
                arrayList.add(m14087a3);
            }
            if (m14087a4 != null) {
                arrayList.add(m14087a4);
            }
            if (m14087a5 != null) {
                arrayList.add(m14087a5);
            }
            if (m14087a6 != null) {
                arrayList.add(m14087a6);
            }
            if (m14087a7 != null) {
                arrayList.add(m14087a7);
            }
            Dispatch.m14099a(UMGlobalContext.getAppContext(), 202, m14095a(), arrayList);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private boolean m14075e() {
        SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
        if (m14703a != null) {
            String string = m14703a.getString(SpWrapper.f37670f, "");
            if (TextUtils.isEmpty(string)) {
                m14073f();
                return false;
            }
            try {
                if (!Misc.m14714a().keySet().equals(Misc.m14710a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Monitor m14095a() {
        return C13192b.f38590a;
    }

    /* renamed from: b */
    private JSONObject m14083b(Context context) {
        FileInputStream fileInputStream;
        try {
            File filesDir = context.getFilesDir();
            String str = f38577b;
            if (!new File(filesDir, str).exists()) {
                return null;
            }
            try {
                fileInputStream = context.openFileInput(str);
                try {
                    JSONObject jSONObject = new JSONObject(new String(ZipUtils.m14699a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                    try {
                        Misc.m14711a(fileInputStream);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    Misc.m14711a(fileInputStream);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    /* renamed from: a */
    public void m14094a(Context context) {
        Dispatch.m14099a(context, 105, m14095a(), null);
    }

    /* renamed from: a */
    private boolean m14086a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has(CcgConstant.f38530a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m14091a(Context context, JSONObject jSONObject, String str) {
        try {
            long m14081b = m14081b(jSONObject);
            byte[] m14699a = ZipUtils.m14699a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (m14699a != null && m14699a.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f38577b));
                fileOutputStream.write(m14699a);
                fileOutputStream.flush();
                Misc.m14711a(fileOutputStream);
                m14092a(context, str, m14081b);
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m14082b(String str) {
        String str2 = SpWrapper.f37666b + str;
        SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
        if (m14703a != null) {
            m14703a.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    /* renamed from: a */
    private void m14088a(String str, ActionCondition actionCondition) {
        if (CcgConstant.f38535f.equalsIgnoreCase(str)) {
            if (f38580e == null) {
                f38580e = new ArrayList<>();
            }
            f38580e.add(actionCondition);
        }
        if (CcgConstant.f38536g.equalsIgnoreCase(str)) {
            if (f38581f == null) {
                f38581f = new ArrayList<>();
            }
            f38581f.add(actionCondition);
        }
        if (CcgConstant.f38537h.equalsIgnoreCase(str)) {
            if (f38582g == null) {
                f38582g = new ArrayList<>();
            }
            f38582g.add(actionCondition);
        }
    }

    /* renamed from: a */
    private Action m14087a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        String str3;
        Action action;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(CcgConstant.f38538i) && (optJSONArray = jSONObject.optJSONArray(CcgConstant.f38538i)) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has(CcgConstant.f38539j);
                    boolean has2 = jSONObject2.has(CcgConstant.f38542m);
                    boolean has3 = jSONObject2.has(CcgConstant.f38543n);
                    if (has && has2 && has3) {
                        try {
                            int optInt = jSONObject2.optInt(CcgConstant.f38539j);
                            long optLong = jSONObject2.optLong(CcgConstant.f38542m);
                            long optLong2 = jSONObject2.optLong(CcgConstant.f38543n);
                            String optString = jSONObject2.optString(CcgConstant.f38544o);
                            ArrayList arrayList = new ArrayList();
                            if (jSONObject2.has(CcgConstant.f38540k)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(CcgConstant.f38540k);
                                str2 = CcgConstant.f38549t;
                                HashSet hashSet = new HashSet();
                                if (optJSONArray3 != null) {
                                    str3 = "sdk";
                                    int i = 0;
                                    for (int length = optJSONArray3.length(); i < length; length = length) {
                                        hashSet.add(Integer.valueOf(optJSONArray3.getInt(i)));
                                        i++;
                                    }
                                } else {
                                    str3 = "sdk";
                                }
                                if (hashSet.size() > 0) {
                                    WeekOnCondition weekOnCondition = new WeekOnCondition(hashSet);
                                    if (Arrays.asList(f38579d).contains(str)) {
                                        m14088a(str, weekOnCondition);
                                    } else {
                                        arrayList.add(weekOnCondition);
                                    }
                                }
                            } else {
                                str2 = CcgConstant.f38549t;
                                str3 = "sdk";
                            }
                            if (jSONObject2.has(CcgConstant.f38541l)) {
                                String optString2 = jSONObject2.optString(CcgConstant.f38541l);
                                if (!TextUtils.isEmpty(optString2)) {
                                    TimePeriodChain timePeriodChain = new TimePeriodChain(optString2);
                                    HashSet hashSet2 = new HashSet();
                                    for (int i2 = 1; i2 <= 24; i2++) {
                                        if (timePeriodChain.m14753a(i2)) {
                                            hashSet2.add(Integer.valueOf(i2));
                                        }
                                    }
                                    if (hashSet2.size() > 0) {
                                        HourOnCondition hourOnCondition = new HourOnCondition(hashSet2);
                                        if (Arrays.asList(f38579d).contains(str)) {
                                            m14088a(str, hourOnCondition);
                                        } else {
                                            arrayList.add(hourOnCondition);
                                        }
                                    }
                                }
                            }
                            arrayList.add(new LaunchTimesCondition(optInt));
                            IntervalPeriodCondition intervalPeriodCondition = new IntervalPeriodCondition(str, optLong);
                            String[] strArr = f38579d;
                            if (Arrays.asList(strArr).contains(str)) {
                                m14088a(str, intervalPeriodCondition);
                            } else {
                                arrayList.add(intervalPeriodCondition);
                            }
                            DelayedStartCondition delayedStartCondition = new DelayedStartCondition(optLong2);
                            if (Arrays.asList(strArr).contains(str)) {
                                m14088a(str, delayedStartCondition);
                                arrayList.add(delayedStartCondition);
                            } else {
                                arrayList.add(delayedStartCondition);
                            }
                            if (CcgConstant.f38534e.equals(str)) {
                                action = new AplAction(str, arrayList);
                            } else {
                                action = new Action(str, arrayList);
                            }
                            try {
                                action.m14138a(optString);
                                String str4 = "";
                                String str5 = str3;
                                if (jSONObject.has(str5) && (optJSONArray2 = jSONObject.optJSONArray(str5)) != null) {
                                    Map<String, C13191a> map = this.f38585i;
                                    if (map != null && !map.containsKey(str)) {
                                        this.f38585i.put(str, new C13191a(new JSONArray(optJSONArray2.toString()), optString));
                                    }
                                    int length2 = optJSONArray2.length();
                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                        str4 = str4 + optJSONArray2.getString(i3);
                                        if (i3 < length2 - 1) {
                                            str4 = str4 + ",";
                                        }
                                    }
                                }
                                action.m14135b(str4);
                                if (CcgConstant.f38534e.equals(str) && (action instanceof AplAction)) {
                                    String str6 = str2;
                                    if (jSONObject2.has(str6)) {
                                        ((AplAction) action).m14756d(jSONObject2.optString(str6));
                                    }
                                    if (jSONObject2.has(CcgConstant.f38548s)) {
                                        ((AplAction) action).m14758c(jSONObject2.optString(CcgConstant.f38548s));
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            return action;
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m14092a(Context context, String str, long j) {
        SharedPreferences m14703a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (m14703a = SpWrapper.m14703a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = m14703a.edit();
            edit.putLong(SpWrapper.f37667c, j);
            edit.putLong(SpWrapper.f37668d, parseLong);
            edit.putString(SpWrapper.f37669e, str2).commit();
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m14089a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f38584h)) {
                String[] split2 = this.f38584h.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
            if (m14703a != null) {
                if (m14703a.getLong(SpWrapper.f37667c, 0L) != parseLong) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f38584h = String.valueOf(parseLong) + "@" + str2;
                    Dispatch.m14099a(UMGlobalContext.getAppContext(), 101, m14095a(), str);
                    return;
                }
                m14076d(UMGlobalContext.getAppContext());
                if (m14074e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f38584h = String.valueOf(parseLong) + "@" + str2;
                Dispatch.m14099a(UMGlobalContext.getAppContext(), 101, m14095a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m14085a(boolean z) {
        try {
            SharedPreferences m14703a = SpWrapper.m14703a(UMGlobalContext.getAppContext());
            if (m14703a != null) {
                SharedPreferences.Editor edit = m14703a.edit();
                if (z) {
                    edit.putString(SpWrapper.f37671g, "1").commit();
                } else {
                    edit.putString(SpWrapper.f37671g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v54 */
    @Override // com.umeng.ccg.Dispatch.InterfaceC13189a
    /* renamed from: a */
    public void mo14090a(Object obj, int i) {
        Integer valueOf;
        ArrayList arrayList;
        int size;
        C13191a c13191a;
        C13191a c13191a2;
        C13191a c13191a3;
        boolean z = true;
        int i2 = 0;
        try {
            switch (i) {
                case 101:
                    if (obj == null || !(obj instanceof String)) {
                        return;
                    }
                    String str = (String) obj;
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                    JSONObject m14720a = ModelHelper.m14720a(UMGlobalContext.getAppContext(), str);
                    if (m14720a != null) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + m14720a.toString());
                        UMExecutor.m14701a(new HttpPostThread(HttpPostThread.f37650a, m14720a, str), 0L, TimeUnit.SECONDS);
                    }
                    if (m14072g()) {
                        m14079c(UMGlobalContext.getAppContext());
                        String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f38576a, "");
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty);
                        m14089a(imprintProperty);
                        return;
                    }
                    return;
                case 102:
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.f38584h = "";
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (m14086a(jSONObject.optJSONObject("config"))) {
                            Dispatch.m14099a(UMGlobalContext.getAppContext(), 103, m14095a(), jSONObject);
                            return;
                        } else {
                            Dispatch.m14099a(UMGlobalContext.getAppContext(), 104, m14095a(), null);
                            return;
                        }
                    }
                    Dispatch.m14099a(UMGlobalContext.getAppContext(), 104, m14095a(), null);
                    return;
                case 103:
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                    Context appContext = UMGlobalContext.getAppContext();
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject2 = (JSONObject) obj;
                    JSONObject optJSONObject = jSONObject2.optJSONObject("config");
                    String optString = jSONObject2.optString("sourceIucc");
                    if (optJSONObject != null) {
                        if (m14072g()) {
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值");
                            m14073f();
                            m14085a(false);
                        }
                        m14091a(appContext, optJSONObject, optString);
                        return;
                    }
                    return;
                case 104:
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                    return;
                case 105:
                    String[] collectItemList = CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    ?? r3 = 0;
                    while (r3 < length) {
                        String str2 = collectItemList[r3];
                        ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(str2);
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[forbid_sdk] 采集项: " + str2 + "; 值: " + forbidSdkArray.toString());
                        r3++;
                    }
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                    Integer num = 0;
                    try {
                        JSONObject m14083b = m14083b(UMGlobalContext.getAppContext());
                        if (m14083b != null) {
                            if (m14086a(m14083b)) {
                                valueOf = Integer.valueOf(num.intValue() | 1);
                            } else {
                                valueOf = Integer.valueOf(num.intValue() | 0);
                            }
                        } else {
                            valueOf = Integer.valueOf(num.intValue() | 0);
                        }
                        r3 = new JSONObject();
                        r3.put(CommonNetImpl.RESULT, valueOf);
                        if (m14083b != null) {
                            r3.put("config", m14083b);
                        }
                    } catch (Throwable unused) {
                    }
                    Dispatch.m14099a(UMGlobalContext.getAppContext(), 106, m14095a(), r3);
                    return;
                case 106:
                    if (obj == null || !(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject3 = (JSONObject) obj;
                    if (jSONObject3.has(CommonNetImpl.RESULT)) {
                        if ((jSONObject3.optInt(CommonNetImpl.RESULT) & 1) != 0 && jSONObject3.has("config")) {
                            JSONObject optJSONObject2 = jSONObject3.optJSONObject("config");
                            f38578c = optJSONObject2;
                            if (optJSONObject2 != null) {
                                CcgAgent.notifyConfigReady(optJSONObject2);
                                i2 = 1;
                            }
                        }
                        if (i2 == 0) {
                            CcgAgent.notifyConfigReady(null);
                        }
                    }
                    if (m14075e()) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志).");
                        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f38576a, "");
                        m14085a(true);
                        Dispatch.m14099a(UMGlobalContext.getAppContext(), 101, m14095a(), imprintProperty2);
                        return;
                    }
                    m14079c(UMGlobalContext.getAppContext());
                    String imprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f38576a, "");
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty3);
                    m14089a(imprintProperty3);
                    return;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str3 = (String) obj;
                                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                m14089a(str3);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    return;
                default:
                    switch (i) {
                        case 201:
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                            if (obj == null || !(obj instanceof JSONObject)) {
                                return;
                            }
                            m14078c((JSONObject) obj);
                            return;
                        case 202:
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                            if (obj == null || !(obj instanceof ArrayList) || (size = (arrayList = (ArrayList) obj).size()) <= 0) {
                                return;
                            }
                            while (i2 < size) {
                                Action action = (Action) arrayList.get(i2);
                                JSONObject mo14137a = action.mo14137a(action.m14139a(), null);
                                if (mo14137a != null) {
                                    long optLong = !Arrays.asList(f38579d).contains(action.m14139a()) ? mo14137a.optLong("delay") * 1000 : 0L;
                                    mo14137a.remove("delay");
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "send START_COLLECT msg, delayTs = " + optLong);
                                    Dispatch.m14098a(UMGlobalContext.getAppContext(), 203, m14095a(), mo14137a, optLong);
                                }
                                i2++;
                            }
                            return;
                        case 203:
                            if (obj == null || !(obj instanceof JSONObject)) {
                                return;
                            }
                            JSONObject jSONObject4 = (JSONObject) obj;
                            String optString2 = jSONObject4.optString("actionName");
                            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + optString2);
                            if (!CcgSwitch.m14106a(optString2)) {
                                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "Local switch of [" + optString2 + "] is off, ignore this command.");
                                return;
                            }
                            String jSONObject5 = jSONObject4.toString();
                            if (Arrays.asList(f38579d).contains(optString2)) {
                                if (CcgConstant.f38535f.equalsIgnoreCase(optString2)) {
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                    m14093a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON");
                                }
                                if (CcgConstant.f38536g.equalsIgnoreCase(optString2)) {
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                    m14093a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF");
                                }
                                if (CcgConstant.f38537h.equalsIgnoreCase(optString2)) {
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                    m14093a(UMGlobalContext.getAppContext(), "android.intent.action.USER_PRESENT");
                                    return;
                                }
                                return;
                            }
                            m14082b(optString2);
                            if (CcgAgent.hasRegistedActionInfo()) {
                                if (CcgAgent.getActionInfo("anti") == null) {
                                    z = false;
                                }
                                String optString3 = jSONObject4.optString(CcgConstant.f38545p);
                                if (!TextUtils.isEmpty(optString3)) {
                                    ActionInfo actionInfo = CcgAgent.getActionInfo(optString3);
                                    if (actionInfo != null) {
                                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "调用[" + optString3 + "] onCommand接口方法, 参数: " + jSONObject4.toString());
                                        actionInfo.onCommand(UMGlobalContext.getAppContext(), optString2, jSONObject4);
                                    }
                                } else {
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "忽略 本次采集项[" + optString2 + "]采集请求.");
                                }
                                if (z) {
                                    return;
                                }
                                Misc.m14713a(UMGlobalContext.getAppContext(), jSONObject5);
                                return;
                            }
                            Misc.m14713a(UMGlobalContext.getAppContext(), jSONObject5);
                            return;
                        default:
                            switch (i) {
                                case 301:
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                    m14082b(CcgConstant.f38535f);
                                    if (!this.f38585i.containsKey(CcgConstant.f38535f) || (c13191a = this.f38585i.get(CcgConstant.f38535f)) == null) {
                                        return;
                                    }
                                    JSONObject m14721a = ModelHelper.m14721a(UMGlobalContext.getAppContext(), 1, c13191a.m14071a(), c13191a.m14070b());
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "screen_on event param: " + m14721a.toString());
                                    UMExecutor.m14701a(new HttpPostDataThread(HttpPostDataThread.f37647a, m14721a), 0L, TimeUnit.SECONDS);
                                    return;
                                case 302:
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                    m14082b(CcgConstant.f38536g);
                                    if (!this.f38585i.containsKey(CcgConstant.f38536g) || (c13191a2 = this.f38585i.get(CcgConstant.f38536g)) == null) {
                                        return;
                                    }
                                    JSONObject m14721a2 = ModelHelper.m14721a(UMGlobalContext.getAppContext(), 3, c13191a2.m14071a(), c13191a2.m14070b());
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "screen_off event param: " + m14721a2.toString());
                                    UMExecutor.m14701a(new HttpPostDataThread(HttpPostDataThread.f37647a, m14721a2), 0L, TimeUnit.SECONDS);
                                    return;
                                case 303:
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                    m14082b(CcgConstant.f38537h);
                                    if (!this.f38585i.containsKey(CcgConstant.f38537h) || (c13191a3 = this.f38585i.get(CcgConstant.f38537h)) == null) {
                                        return;
                                    }
                                    JSONObject m14721a3 = ModelHelper.m14721a(UMGlobalContext.getAppContext(), 2, c13191a3.m14071a(), c13191a3.m14070b());
                                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "screen_unlock event param: " + m14721a3.toString());
                                    UMExecutor.m14701a(new HttpPostDataThread(HttpPostDataThread.f37647a, m14721a3), 0L, TimeUnit.SECONDS);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        } catch (Throwable unused2) {
        }
    }
}
