package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.TDeserializer;
import com.umeng.analytics.pro.TSerializer;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.proto.IdJournal;
import com.umeng.commonsdk.statistics.proto.IdSnapshot;
import com.umeng.commonsdk.statistics.proto.IdTracking;
import com.umeng.commonsdk.utils.UMConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IdTracker {

    /* renamed from: a */
    public static final long f38986a = 86400000;

    /* renamed from: b */
    public static IdTracker f38987b;

    /* renamed from: c */
    private static final String f38988c = PathCenter.m14695b().m14694b("id");

    /* renamed from: j */
    private static Object f38989j = new Object();

    /* renamed from: d */
    private File f38990d;

    /* renamed from: f */
    private long f38992f;

    /* renamed from: i */
    private C13253a f38995i;

    /* renamed from: e */
    private IdTracking f38991e = null;

    /* renamed from: h */
    private Set<AbstractIdTracker> f38994h = new HashSet();

    /* renamed from: g */
    private long f38993g = 86400000;

    /* compiled from: IdTracker.java */
    /* renamed from: com.umeng.commonsdk.statistics.idtracking.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13253a {

        /* renamed from: a */
        private Context f38996a;

        /* renamed from: b */
        private Set<String> f38997b = new HashSet();

        public C13253a(Context context) {
            this.f38996a = context;
        }

        /* renamed from: a */
        public synchronized boolean m13694a(String str) {
            return !this.f38997b.contains(str);
        }

        /* renamed from: b */
        public synchronized void m13692b(String str) {
            this.f38997b.add(str);
        }

        /* renamed from: c */
        public void m13691c(String str) {
            this.f38997b.remove(str);
        }

        /* renamed from: a */
        public synchronized void m13695a() {
            if (!this.f38997b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f38997b) {
                    sb.append(str);
                    sb.append(StringUtil.COMMA);
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f38996a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        /* renamed from: b */
        public synchronized void m13693b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.f38996a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f38997b.add(str);
                    }
                }
            }
        }
    }

    IdTracker(Context context) {
        this.f38995i = null;
        this.f38990d = new File(context.getFilesDir(), f38988c);
        C13253a c13253a = new C13253a(context);
        this.f38995i = c13253a;
        c13253a.m13693b();
    }

    /* renamed from: a */
    public static synchronized void m13709a() {
        synchronized (IdTracker.class) {
            IdTracker idTracker = f38987b;
            if (idTracker != null) {
                idTracker.m13700e();
                f38987b = null;
            }
        }
    }

    /* renamed from: h */
    private synchronized void m13697h() {
        IdTracking idTracking = new IdTracking();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (AbstractIdTracker abstractIdTracker : this.f38994h) {
            if (abstractIdTracker.m13713c()) {
                if (abstractIdTracker.m13712d() != null) {
                    hashMap.put(abstractIdTracker.m13714b(), abstractIdTracker.m13712d());
                }
                if (abstractIdTracker.m13711e() != null && !abstractIdTracker.m13711e().isEmpty()) {
                    arrayList.addAll(abstractIdTracker.m13711e());
                }
            }
        }
        idTracking.m13580a(arrayList);
        idTracking.m13579a(hashMap);
        synchronized (this) {
            this.f38991e = idTracking;
        }
    }

    /* renamed from: i */
    private IdTracking m13696i() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (f38989j) {
            if (this.f38990d.exists()) {
                try {
                    fileInputStream = new FileInputStream(this.f38990d);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        IdTracking idTracking = new IdTracking();
                        new TDeserializer().m14518a(idTracking, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return idTracking;
                    } catch (Throwable th3) {
                        th = th3;
                        HelperUtils.safeClose(fileInputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    return null;
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public synchronized void m13704b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f38992f >= this.f38993g) {
            boolean z = false;
            for (AbstractIdTracker abstractIdTracker : this.f38994h) {
                if (abstractIdTracker.m13713c() && abstractIdTracker.m13719a()) {
                    z = true;
                    if (!abstractIdTracker.m13713c()) {
                        this.f38995i.m13692b(abstractIdTracker.m13714b());
                    }
                }
            }
            if (z) {
                m13697h();
                this.f38995i.m13695a();
                m13698g();
            }
            this.f38992f = currentTimeMillis;
        }
    }

    /* renamed from: c */
    public synchronized IdTracking m13702c() {
        return this.f38991e;
    }

    /* renamed from: d */
    public String m13701d() {
        return null;
    }

    /* renamed from: e */
    public synchronized void m13700e() {
        if (f38987b == null) {
            return;
        }
        boolean z = false;
        for (AbstractIdTracker abstractIdTracker : this.f38994h) {
            if (abstractIdTracker.m13713c() && abstractIdTracker.m13711e() != null && !abstractIdTracker.m13711e().isEmpty()) {
                abstractIdTracker.m13715a((List<IdJournal>) null);
                z = true;
            }
        }
        if (z) {
            this.f38991e.m13576b(false);
            m13698g();
        }
    }

    /* renamed from: f */
    public synchronized void m13699f() {
        IdTracking m13696i = m13696i();
        if (m13696i == null) {
            return;
        }
        m13705a(m13696i);
        ArrayList<AbstractIdTracker> arrayList = new ArrayList(this.f38994h.size());
        synchronized (this) {
            this.f38991e = m13696i;
            for (AbstractIdTracker abstractIdTracker : this.f38994h) {
                abstractIdTracker.m13717a(this.f38991e);
                if (!abstractIdTracker.m13713c()) {
                    arrayList.add(abstractIdTracker);
                }
            }
            for (AbstractIdTracker abstractIdTracker2 : arrayList) {
                this.f38994h.remove(abstractIdTracker2);
            }
            m13697h();
        }
    }

    /* renamed from: g */
    public synchronized void m13698g() {
        IdTracking idTracking = this.f38991e;
        if (idTracking != null) {
            m13703b(idTracking);
        }
    }

    /* renamed from: a */
    public static synchronized IdTracker m13707a(Context context) {
        IdTracker idTracker;
        synchronized (IdTracker.class) {
            if (f38987b == null) {
                IdTracker idTracker2 = new IdTracker(context);
                f38987b = idTracker2;
                idTracker2.m13706a(new ImeiTracker(context));
                f38987b.m13706a(new AndroidIdTracker(context));
                f38987b.m13706a(new UTDIdTracker(context));
                f38987b.m13706a(new IDMD5Tracker(context));
                f38987b.m13706a(new IDFATracker(context));
                f38987b.m13706a(new MacTracker(context));
                f38987b.m13706a(new SerialTracker());
                if (FieldManager.allow(UMConstant.f39161G)) {
                    f38987b.m13706a(new OaidTracking(context));
                }
                f38987b.m13699f();
            }
            idTracker = f38987b;
        }
        return idTracker;
    }

    /* renamed from: b */
    private void m13703b(IdTracking idTracking) {
        byte[] m14505a;
        synchronized (f38989j) {
            if (idTracking != null) {
                try {
                    synchronized (this) {
                        m13705a(idTracking);
                        m14505a = new TSerializer().m14505a(idTracking);
                    }
                    if (m14505a != null) {
                        HelperUtils.writeFile(this.f38990d, m14505a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m13706a(AbstractIdTracker abstractIdTracker) {
        if (this.f38995i.m13694a(abstractIdTracker.m13714b())) {
            return this.f38994h.add(abstractIdTracker);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            MLog.m13802w("invalid domain: " + abstractIdTracker.m13714b());
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public void m13708a(long j) {
        this.f38993g = j;
    }

    /* renamed from: a */
    private void m13705a(IdTracking idTracking) {
        Map<String, IdSnapshot> map;
        if (idTracking == null || (map = idTracking.f39082a) == null) {
            return;
        }
        if (map.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_MAC) && !FieldManager.allow(UMConstant.f39208h)) {
            idTracking.f39082a.remove(SocializeProtocolConstants.PROTOCOL_KEY_MAC);
        }
        if (idTracking.f39082a.containsKey("imei") && !FieldManager.allow(UMConstant.f39207g)) {
            idTracking.f39082a.remove("imei");
        }
        if (idTracking.f39082a.containsKey(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) && !FieldManager.allow(UMConstant.f39209i)) {
            idTracking.f39082a.remove(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        }
        if (idTracking.f39082a.containsKey("serial") && !FieldManager.allow(UMConstant.f39210j)) {
            idTracking.f39082a.remove("serial");
        }
        if (idTracking.f39082a.containsKey("idfa") && !FieldManager.allow(UMConstant.f39223w)) {
            idTracking.f39082a.remove("idfa");
        }
        if (!idTracking.f39082a.containsKey("oaid") || FieldManager.allow(UMConstant.f39161G)) {
            return;
        }
        idTracking.f39082a.remove("oaid");
    }
}
