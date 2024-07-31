package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMConstant;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.umeng.analytics.pro.y */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SessionIdManager {

    /* renamed from: c */
    private static volatile SessionIdManager f38474c;

    /* renamed from: a */
    private SessionIdGenerateService f38475a = new SessionIdGenerateServiceImpl();

    /* renamed from: b */
    private String f38476b;

    /* renamed from: d */
    private List<InterfaceC13178a> f38477d;

    /* renamed from: e */
    private String f38478e;

    /* compiled from: SessionIdManager.java */
    /* renamed from: com.umeng.analytics.pro.y$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13178a {
        /* renamed from: a */
        void mo14141a(String str, long j, long j2, long j3);

        /* renamed from: a */
        void mo14140a(String str, String str2, long j, long j2, long j3);
    }

    private SessionIdManager() {
    }

    /* renamed from: a */
    public static SessionIdManager m14159a() {
        if (f38474c == null) {
            synchronized (SessionIdManager.class) {
                if (f38474c == null) {
                    f38474c = new SessionIdManager();
                }
            }
        }
        return f38474c;
    }

    /* renamed from: f */
    private String m14146f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(SessionTracker.f38456d, m14148d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long m14144h = m14144h(context);
        long m14143i = m14143i(context);
        String str = this.f38476b;
        long m14187a = SessionTracker.m14187a(context);
        long j = m14187a * 5000;
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + m14187a);
        if (FieldManager.allow(UMConstant.f39159E)) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
            }
        } else {
            UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        }
        m14157a(m14143i, m14144h, j, str, false);
        this.f38476b = this.f38475a.mo14161a(context);
        m14157a(m14143i, m14144h, j, str, true);
        this.f38475a.mo14160a(context, this.f38476b);
        return this.f38476b;
    }

    /* renamed from: g */
    private boolean m14145g(Context context) {
        return !TextUtils.isEmpty(this.f38476b) && UMStoreManager.m14345a(context).m14344a(this.f38476b) > 0;
    }

    /* renamed from: h */
    private long m14144h(Context context) {
        return m14154a(context, SessionTracker.f38458f);
    }

    /* renamed from: i */
    private long m14143i(Context context) {
        return m14154a(context, SessionTracker.f38453a);
    }

    /* renamed from: j */
    private boolean m14142j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(SessionTracker.f38457e, 0L);
            long j2 = sharedPreferences.getLong(SessionTracker.f38458f, 0L);
            if (FieldManager.allow(UMConstant.f39159E) && j > 0 && j2 == 0) {
                long m14187a = SessionTracker.m14187a(appContext);
                if (m14187a > 0) {
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (m14187a * 5000);
                }
            }
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.f38475a.mo14162a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public long m14152b() {
        return this.f38475a.mo14164a();
    }

    /* renamed from: c */
    public String m14149c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f38476b = m14146f(appContext);
        } catch (Exception unused) {
        }
        return this.f38476b;
    }

    /* renamed from: d */
    public String m14148d(Context context) {
        if (TextUtils.isEmpty(this.f38476b)) {
            try {
                this.f38476b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f38476b;
    }

    /* renamed from: e */
    public boolean m14147e(Context context) {
        if (TextUtils.isEmpty(this.f38476b)) {
            this.f38476b = m14148d(context);
        }
        return TextUtils.isEmpty(this.f38476b) || m14142j(context) || m14145g(context);
    }

    /* renamed from: b */
    public synchronized String m14151b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f38476b = m14148d(appContext);
        if (m14147e(appContext)) {
            try {
                this.f38476b = m14146f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f38476b;
    }

    /* renamed from: a */
    public void m14158a(long j) {
        this.f38475a.mo14163a(j);
    }

    /* renamed from: a */
    public String m14156a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (SessionIdManager.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(SessionTracker.f38456d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: b */
    public void m14150b(InterfaceC13178a interfaceC13178a) {
        List<InterfaceC13178a> list;
        if (interfaceC13178a == null || (list = this.f38477d) == null || list.size() == 0) {
            return;
        }
        this.f38477d.remove(interfaceC13178a);
    }

    /* renamed from: a */
    public String m14155a(Context context, long j) {
        if (TextUtils.isEmpty(this.f38478e)) {
            String str = "SUB" + j;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f38478e = sb.toString();
        }
        return this.f38478e;
    }

    /* renamed from: a */
    private long m14154a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    /* renamed from: a */
    private void m14157a(long j, long j2, long j3, String str, boolean z) {
        List<InterfaceC13178a> list = this.f38477d;
        if (list != null) {
            for (InterfaceC13178a interfaceC13178a : list) {
                if (z) {
                    try {
                        interfaceC13178a.mo14140a(str, this.f38476b, j, j2, j3);
                    } catch (Exception unused) {
                    }
                } else {
                    interfaceC13178a.mo14141a(this.f38476b, j, j2, j3);
                }
            }
        }
    }

    /* renamed from: a */
    public void m14153a(InterfaceC13178a interfaceC13178a) {
        if (interfaceC13178a == null) {
            return;
        }
        if (this.f38477d == null) {
            this.f38477d = new ArrayList();
        }
        if (this.f38477d.contains(interfaceC13178a)) {
            return;
        }
        this.f38477d.add(interfaceC13178a);
    }
}
