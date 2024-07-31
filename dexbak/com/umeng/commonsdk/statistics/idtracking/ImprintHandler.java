package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.TSerializer;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.OnImprintChangedListener;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.statistics.proto.Imprint;
import com.umeng.commonsdk.statistics.proto.ImprintValue;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a */
    private static final String f38958a = "ImprintHandler";

    /* renamed from: k */
    private static Context f38965k = null;

    /* renamed from: l */
    private static FileLockUtil f38966l = null;

    /* renamed from: m */
    private static final int f38967m = 0;

    /* renamed from: n */
    private static final int f38968n = 1;

    /* renamed from: e */
    private OnImprintChangedListener f38971e;

    /* renamed from: h */
    private C13252a f38972h = new C13252a();

    /* renamed from: i */
    private Imprint f38973i = null;

    /* renamed from: b */
    private static Object f38959b = new Object();

    /* renamed from: c */
    private static final String f38960c = PathCenter.m14695b().m14694b(PathCenter.f37684c);

    /* renamed from: d */
    private static final byte[] f38961d = "pbl0".getBytes();

    /* renamed from: f */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f38962f = new HashMap();

    /* renamed from: g */
    private static Object f38963g = new Object();

    /* renamed from: j */
    private static ImprintHandler f38964j = null;

    /* renamed from: o */
    private static Map<String, UMImprintPreProcessCallback> f38969o = new HashMap();

    /* renamed from: p */
    private static Object f38970p = new Object();

    private ImprintHandler(Context context) {
        f38965k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: a */
    private static void m13734a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f38963g) {
            int i = 0;
            if (f38962f.containsKey(str)) {
                ArrayList<UMImprintChangeCallback> arrayList = f38962f.get(str);
                int size = arrayList.size();
                ULog.m13784i("--->>> addCallback: before add: callbacks size is: " + size);
                while (i < size) {
                    if (uMImprintChangeCallback == arrayList.get(i)) {
                        ULog.m13784i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i++;
                }
                arrayList.add(uMImprintChangeCallback);
                ULog.m13784i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
            } else {
                ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                int size2 = arrayList2.size();
                ULog.m13784i("--->>> addCallback: before add: callbacks size is: " + size2);
                while (i < size2) {
                    if (uMImprintChangeCallback == arrayList2.get(i)) {
                        ULog.m13784i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i++;
                }
                arrayList2.add(uMImprintChangeCallback);
                ULog.m13784i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                f38962f.put(str, arrayList2);
            }
        }
    }

    /* renamed from: b */
    private static void m13730b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f38963g) {
            try {
                if (f38962f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f38962f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.m13784i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (uMImprintChangeCallback == arrayList.get(i)) {
                                ULog.m13784i("--->>> removeCallback: remove index " + i);
                                arrayList.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                        ULog.m13784i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.m13784i("--->>> removeCallback: remove key from map: key = " + str);
                            f38962f.remove(str);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private boolean m13728c(Imprint imprint) {
        if (imprint.m13531i().equals(m13739a(imprint))) {
            for (ImprintValue imprintValue : imprint.m13538c().values()) {
                String m13498h = imprintValue.m13498h();
                if (!TextUtils.isEmpty(m13498h)) {
                    byte[] reverseHexString = DataHelper.reverseHexString(m13498h);
                    byte[] m13737a = m13737a(imprintValue);
                    for (int i = 0; i < 4; i++) {
                        if (reverseHexString[i] != m13737a[i]) {
                            return false;
                        }
                    }
                    continue;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private Imprint m13726d(Imprint imprint) {
        Map<String, ImprintValue> m13538c = imprint.m13538c();
        if (m13538c.containsKey(UMCommonContent.f37847f)) {
            m13538c.remove(UMCommonContent.f37847f);
            this.f38972h.m13722a(UMCommonContent.f37847f);
            imprint.m13548a(imprint.m13534f());
            imprint.m13545a(m13739a(imprint));
        }
        return imprint;
    }

    /* renamed from: e */
    private Imprint m13724e(Imprint imprint) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, ImprintValue> m13538c = imprint.m13538c();
        ArrayList<String> arrayList3 = new ArrayList(m13538c.size() / 2);
        Iterator<Map.Entry<String, ImprintValue>> it = m13538c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ImprintValue> next = it.next();
            if (!next.getValue().m13502d()) {
                arrayList3.add(next.getKey());
            } else {
                String key = next.getKey();
                String str = next.getValue().f39120a;
                synchronized (f38970p) {
                    z = !TextUtils.isEmpty(key) && f38969o.containsKey(key) && (uMImprintPreProcessCallback = f38969o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (f38963g) {
                    if (!TextUtils.isEmpty(key) && f38962f.containsKey(key) && (arrayList2 = f38962f.get(key)) != null) {
                        for (int i = 0; i < arrayList2.size(); i++) {
                            arrayList2.get(i).onImprintValueChanged(key, str);
                        }
                    }
                }
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f38963g) {
                if (!TextUtils.isEmpty(str2) && f38962f.containsKey(str2) && (arrayList = f38962f.get(str2)) != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList.get(i2).onImprintValueChanged(str2, null);
                    }
                }
            }
            m13538c.remove(str2);
        }
        return imprint;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (f38964j == null) {
                f38964j = new ImprintHandler(context);
                f38966l = new FileLockUtil();
                f38966l.doFileOperateion(new File(f38965k.getFilesDir(), f38960c), f38964j, 0);
            }
            imprintHandler = f38964j;
        }
        return imprintHandler;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            f38964j.m13725e();
        } else if (i == 1) {
            f38964j.m13736a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        m13734a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f38970p) {
            try {
                if (!f38969o.containsKey(str)) {
                    f38969o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                }
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        m13730b(str, uMImprintChangeCallback);
    }

    /* renamed from: com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13252a {

        /* renamed from: a */
        private Map<String, String> f38974a = new HashMap();

        C13252a() {
        }

        /* renamed from: b */
        private synchronized void m13720b(Imprint imprint) {
            ImprintValue imprintValue;
            if (imprint != null) {
                if (imprint.m13535e()) {
                    Map<String, ImprintValue> m13538c = imprint.m13538c();
                    for (String str : m13538c.keySet()) {
                        if (!TextUtils.isEmpty(str) && (imprintValue = m13538c.get(str)) != null) {
                            String m13507b = imprintValue.m13507b();
                            if (!TextUtils.isEmpty(m13507b)) {
                                this.f38974a.put(str, m13507b);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    Log.i(ImprintHandler.f38958a, "imKey is " + str + ", imValue is " + m13507b);
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public synchronized void m13722a(String str) {
            Map<String, String> map = this.f38974a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f38974a.containsKey(str)) {
                this.f38974a.remove(str);
            }
        }

        C13252a(Imprint imprint) {
            m13723a(imprint);
        }

        /* renamed from: a */
        public void m13723a(Imprint imprint) {
            if (imprint == null) {
                return;
            }
            m13720b(imprint);
        }

        /* renamed from: a */
        public synchronized String m13721a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f38974a.size() > 0) {
                String str3 = this.f38974a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    /* renamed from: d */
    public void m13727d() {
        if (this.f38973i == null || f38966l == null) {
            return;
        }
        File file = new File(f38965k.getFilesDir(), f38960c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                UMCrashManager.reportCrash(f38965k, e);
            }
        }
        f38966l.doFileOperateion(file, f38964j, 1);
    }

    /* renamed from: c */
    public C13252a m13729c() {
        return this.f38972h;
    }

    /* renamed from: b */
    public void m13731b(Imprint imprint) {
        Imprint m13738a;
        boolean z;
        if (imprint == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.m14010d(UMRTLog.RTLOG_TAG, "Imprint is null");
            }
        } else if (!m13728c(imprint)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
            }
        } else {
            boolean z2 = AnalyticsConstants.UM_DEBUG;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                Imprint imprint2 = this.f38973i;
                Imprint m13726d = m13726d(imprint);
                String str = null;
                String m13531i = imprint2 == null ? null : imprint2.m13531i();
                if (imprint2 == null) {
                    m13738a = m13724e(m13726d);
                } else {
                    m13738a = m13738a(imprint2, m13726d, hashMap);
                }
                this.f38973i = m13738a;
                if (m13738a != null) {
                    str = m13738a.m13531i();
                }
                z = !m13733a(m13531i, str);
            }
            Imprint imprint3 = this.f38973i;
            if (imprint3 != null && z) {
                this.f38972h.m13723a(imprint3);
                OnImprintChangedListener onImprintChangedListener = this.f38971e;
                if (onImprintChangedListener != null) {
                    onImprintChangedListener.onImprintChanged(this.f38972h);
                }
            }
            if (hashMap.size() > 0) {
                synchronized (f38963g) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f38962f.containsKey(key)) {
                            ULog.m13784i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f38962f.get(key);
                            if (arrayList != null) {
                                for (int i = 0; i < arrayList.size(); i++) {
                                    arrayList.get(i).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m13735a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f38970p) {
            try {
                if (f38969o.containsKey(str)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f38962f.remove(str);
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.content.Context] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m13725e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f38965k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f38960c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f38959b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L5e
            if (r0 != 0) goto L18
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5e
            return
        L18:
            r0 = 0
            android.content.Context r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f38965k     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            java.io.FileInputStream r2 = r3.openFileInput(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L59
        L23:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L5e
            goto L34
        L27:
            r3 = move-exception
            goto L30
        L29:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L5a
        L2e:
            r3 = move-exception
            r2 = r0
        L30:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L59
            goto L23
        L34:
            if (r0 == 0) goto L57
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r2.<init>()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.analytics.pro.bu r3 = new com.umeng.analytics.pro.bu     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r3.<init>()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r3.m14518a(r2, r0)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r5.f38973i = r2     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f38972h     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r0.m13723a(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f38973i     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.commonsdk.statistics.proto.d r0 = r5.m13726d(r0)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r5.f38973i = r0     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            goto L57
        L53:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5e
        L57:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5e
            return
        L59:
            r0 = move-exception
        L5a:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L5e
            throw r0     // Catch: java.lang.Throwable -> L5e
        L5e:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5e
            goto L62
        L61:
            throw r0
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.m13725e():void");
    }

    /* renamed from: a */
    public void m13740a(OnImprintChangedListener onImprintChangedListener) {
        this.f38971e = onImprintChangedListener;
    }

    /* renamed from: a */
    public String m13739a(Imprint imprint) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(imprint.m13538c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((ImprintValue) entry.getValue()).m13502d()) {
                sb.append(((ImprintValue) entry.getValue()).m13507b());
            }
        }
        sb.append(imprint.f39102b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    /* renamed from: a */
    public byte[] m13737a(ImprintValue imprintValue) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(imprintValue.m13501e());
        byte[] array = allocate.array();
        byte[] bArr = f38961d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: a */
    public byte[] m13741a() {
        try {
            synchronized (this) {
                Imprint imprint = this.f38973i;
                if (imprint == null) {
                    return null;
                }
                if (imprint.m13541b() <= 0) {
                    return null;
                }
                return new TSerializer().m14505a(this.f38973i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f38965k, th);
            return null;
        }
    }

    /* renamed from: b */
    public synchronized Imprint m13732b() {
        return this.f38973i;
    }

    /* renamed from: a */
    private boolean m13733a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* renamed from: a */
    private Imprint m13738a(Imprint imprint, Imprint imprint2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (imprint2 == null) {
            return imprint;
        }
        Map<String, ImprintValue> m13538c = imprint.m13538c();
        for (Map.Entry<String, ImprintValue> entry : imprint2.m13538c().entrySet()) {
            int i = 0;
            if (entry.getValue().m13502d()) {
                String key = entry.getKey();
                String str = entry.getValue().f39120a;
                synchronized (f38970p) {
                    if (!TextUtils.isEmpty(key) && f38969o.containsKey(key) && (uMImprintPreProcessCallback = f38969o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    m13538c.put(entry.getKey(), entry.getValue());
                    synchronized (f38963g) {
                        if (!TextUtils.isEmpty(key) && f38962f.containsKey(key) && f38962f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f38963g) {
                    if (!TextUtils.isEmpty(key2) && f38962f.containsKey(key2) && (arrayList = f38962f.get(key2)) != null) {
                        while (i < arrayList.size()) {
                            arrayList.get(i).onImprintValueChanged(key2, null);
                            i++;
                        }
                    }
                }
                m13538c.remove(key2);
                this.f38972h.m13722a(key2);
            }
        }
        imprint.m13548a(imprint2.m13534f());
        imprint.m13545a(m13739a(imprint));
        return imprint;
    }

    /* renamed from: a */
    private void m13736a(File file) {
        if (this.f38973i == null) {
            return;
        }
        try {
            synchronized (f38959b) {
                byte[] m14505a = new TSerializer().m14505a(this.f38973i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(m14505a);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
