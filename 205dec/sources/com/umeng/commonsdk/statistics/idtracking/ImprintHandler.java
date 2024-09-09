package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ImprintHandler implements FileLockCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53593a = "ImprintHandler";

    /* renamed from: k  reason: collision with root package name */
    private static Context f53600k = null;

    /* renamed from: l  reason: collision with root package name */
    private static FileLockUtil f53601l = null;

    /* renamed from: m  reason: collision with root package name */
    private static final int f53602m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f53603n = 1;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f53606e;

    /* renamed from: h  reason: collision with root package name */
    private a f53607h = new a();

    /* renamed from: i  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f53608i = null;

    /* renamed from: b  reason: collision with root package name */
    private static Object f53594b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final String f53595c = au.b().b("imp");

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f53596d = "pbl0".getBytes();

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f53597f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private static Object f53598g = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static ImprintHandler f53599j = null;

    /* renamed from: o  reason: collision with root package name */
    private static Map<String, UMImprintPreProcessCallback> f53604o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private static Object f53605p = new Object();

    private ImprintHandler(Context context) {
        f53600k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f53598g) {
            int i4 = 0;
            if (f53597f.containsKey(str)) {
                ArrayList<UMImprintChangeCallback> arrayList = f53597f.get(str);
                int size = arrayList.size();
                ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                while (i4 < size) {
                    if (uMImprintChangeCallback == arrayList.get(i4)) {
                        ULog.i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i4++;
                }
                arrayList.add(uMImprintChangeCallback);
                ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
            } else {
                ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                int size2 = arrayList2.size();
                ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                while (i4 < size2) {
                    if (uMImprintChangeCallback == arrayList2.get(i4)) {
                        ULog.i("--->>> addCallback: callback has exist, just exit");
                        return;
                    }
                    i4++;
                }
                arrayList2.add(uMImprintChangeCallback);
                ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                f53597f.put(str, arrayList2);
            }
        }
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (f53598g) {
            try {
                if (f53597f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f53597f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                break;
                            } else if (uMImprintChangeCallback == arrayList.get(i4)) {
                                ULog.i("--->>> removeCallback: remove index " + i4);
                                arrayList.remove(i4);
                                break;
                            } else {
                                i4++;
                            }
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f53597f.remove(str);
                        }
                    }
                }
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (dVar.i().equals(a(dVar))) {
            for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
                String h4 = eVar.h();
                if (!TextUtils.isEmpty(h4)) {
                    byte[] reverseHexString = DataHelper.reverseHexString(h4);
                    byte[] a4 = a(eVar);
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (reverseHexString[i4] != a4[i4]) {
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

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c4 = dVar.c();
        if (c4.containsKey("umtt")) {
            c4.remove("umtt");
            this.f53607h.a("umtt");
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z3;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c4 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c4.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = c4.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (!next.getValue().d()) {
                arrayList3.add(next.getKey());
            } else {
                String key = next.getKey();
                String str = next.getValue().f53755a;
                synchronized (f53605p) {
                    z3 = !TextUtils.isEmpty(key) && f53604o.containsKey(key) && (uMImprintPreProcessCallback = f53604o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z3) {
                    arrayList3.add(key);
                }
                synchronized (f53598g) {
                    if (!TextUtils.isEmpty(key) && f53597f.containsKey(key) && (arrayList2 = f53597f.get(key)) != null) {
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            arrayList2.get(i4).onImprintValueChanged(key, str);
                        }
                    }
                }
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f53598g) {
                if (!TextUtils.isEmpty(str2) && f53597f.containsKey(str2) && (arrayList = f53597f.get(str2)) != null) {
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        arrayList.get(i5).onImprintValueChanged(str2, null);
                    }
                }
            }
            c4.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (f53599j == null) {
                f53599j = new ImprintHandler(context);
                f53601l = new FileLockUtil();
                f53601l.doFileOperateion(new File(f53600k.getFilesDir(), f53595c), f53599j, 0);
            }
            imprintHandler = f53599j;
        }
        return imprintHandler;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i4) {
        if (i4 == 0) {
            f53599j.e();
        } else if (i4 == 1) {
            f53599j.a(file);
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
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f53605p) {
            try {
                if (!f53604o.containsKey(str)) {
                    f53604o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i("MobclickRT", "--->>> registPreProcessCallback: key : " + str + " regist success.");
                } else {
                    UMRTLog.i("MobclickRT", "--->>> key : " + str + " PreProcesser has registed!");
                }
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f53609a = new HashMap();

        a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> c4 = dVar.c();
                    for (String str : c4.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = c4.get(str)) != null) {
                            String b4 = eVar.b();
                            if (!TextUtils.isEmpty(b4)) {
                                this.f53609a.put(str, b4);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    Log.i("ImprintHandler", "imKey is " + str + ", imValue is " + b4);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.f53609a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f53609a.containsKey(str)) {
                this.f53609a.remove(str);
            }
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f53609a.size() > 0) {
                String str3 = this.f53609a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    public void d() {
        if (this.f53608i == null || f53601l == null) {
            return;
        }
        File file = new File(f53600k.getFilesDir(), f53595c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException unused) {
                    file.createNewFile();
                }
            } catch (IOException e4) {
                UMCrashManager.reportCrash(f53600k, e4);
            }
        }
        f53601l.doFileOperateion(file, f53599j, 1);
    }

    public a c() {
        return this.f53607h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d a4;
        boolean z3;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d("MobclickRT", "Imprint is null");
            }
        } else if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e("MobclickRT", "Imprint is not valid");
            }
        } else {
            boolean z4 = AnalyticsConstants.UM_DEBUG;
            HashMap hashMap = new HashMap();
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.f53608i;
                com.umeng.commonsdk.statistics.proto.d d4 = d(dVar);
                String str = null;
                String i4 = dVar2 == null ? null : dVar2.i();
                if (dVar2 == null) {
                    a4 = e(d4);
                } else {
                    a4 = a(dVar2, d4, hashMap);
                }
                this.f53608i = a4;
                if (a4 != null) {
                    str = a4.i();
                }
                z3 = !a(i4, str);
            }
            com.umeng.commonsdk.statistics.proto.d dVar3 = this.f53608i;
            if (dVar3 != null && z3) {
                this.f53607h.a(dVar3);
                com.umeng.commonsdk.statistics.internal.d dVar4 = this.f53606e;
                if (dVar4 != null) {
                    dVar4.onImprintChanged(this.f53607h);
                }
            }
            if (hashMap.size() > 0) {
                synchronized (f53598g) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f53597f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f53597f.get(key);
                            if (arrayList != null) {
                                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                                    arrayList.get(i5).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f53605p) {
            try {
                if (f53604o.containsKey(str)) {
                    UMRTLog.i("MobclickRT", "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f53597f.remove(str);
                } else {
                    UMRTLog.i("MobclickRT", "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f53600k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f53595c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f53594b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L5e
            if (r0 != 0) goto L18
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L5e
            return
        L18:
            r0 = 0
            android.content.Context r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f53600k     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
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
            r3.a(r2, r0)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r5.f53608i = r2     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r5.f53607h     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r0.a(r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.commonsdk.statistics.proto.d r0 = r5.f53608i     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            com.umeng.commonsdk.statistics.proto.d r0 = r5.d(r0)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
            r5.f53608i = r0     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5e
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
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f53606e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.f53737b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = f53596d;
        byte[] bArr2 = new byte[4];
        for (int i4 = 0; i4 < 4; i4++) {
            bArr2[i4] = (byte) (array[i4] ^ bArr[i4]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar = this.f53608i;
                if (dVar == null) {
                    return null;
                }
                if (dVar.b() <= 0) {
                    return null;
                }
                return new ca().a(this.f53608i);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f53600k, th);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f53608i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c4 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i4 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f53755a;
                synchronized (f53605p) {
                    if (!TextUtils.isEmpty(key) && f53604o.containsKey(key) && (uMImprintPreProcessCallback = f53604o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i4 = 1;
                    }
                }
                if (i4 == 0) {
                    c4.put(entry.getKey(), entry.getValue());
                    synchronized (f53598g) {
                        if (!TextUtils.isEmpty(key) && f53597f.containsKey(key) && f53597f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i("MobclickRT", "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f53598g) {
                    if (!TextUtils.isEmpty(key2) && f53597f.containsKey(key2) && (arrayList = f53597f.get(key2)) != null) {
                        while (i4 < arrayList.size()) {
                            arrayList.get(i4).onImprintValueChanged(key2, null);
                            i4++;
                        }
                    }
                }
                c4.remove(key2);
                this.f53607h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f53608i == null) {
            return;
        }
        try {
            synchronized (f53594b) {
                byte[] a4 = new ca().a(this.f53608i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(a4);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
