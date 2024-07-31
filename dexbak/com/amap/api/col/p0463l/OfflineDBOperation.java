package com.amap.api.col.p0463l;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3l.r0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OfflineDBOperation {

    /* renamed from: b */
    private static volatile OfflineDBOperation f5146b;

    /* renamed from: c */
    private static DBOperation f5147c;

    /* renamed from: a */
    private Context f5148a;

    private OfflineDBOperation(Context context) {
        this.f5148a = context;
        f5147c = m54078i(context);
    }

    /* renamed from: b */
    public static OfflineDBOperation m54085b(Context context) {
        if (f5146b == null) {
            synchronized (OfflineDBOperation.class) {
                if (f5146b == null) {
                    f5146b = new OfflineDBOperation(context);
                }
            }
        }
        return f5146b;
    }

    /* renamed from: d */
    private static List<String> m54083d(List<DTFileInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (DTFileInfo dTFileInfo : list) {
                arrayList.add(dTFileInfo.m54417a());
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    private synchronized void m54080g(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (m54075l()) {
            f5147c.m55459h(new DTDownloadInfo(str, j, i, jArr[0], jArr2[0]), DTDownloadInfo.m54452a(str));
        }
    }

    /* renamed from: h */
    private static void m54079h(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String m54416b = DTFileInfo.m54416b(str);
        if (f5147c.m55451p(m54416b, DTFileInfo.class).size() > 0) {
            f5147c.m55457j(m54416b, DTFileInfo.class);
        }
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            arrayList.add(new DTFileInfo(str, str3));
        }
        f5147c.m55455l(arrayList);
    }

    /* renamed from: i */
    private static DBOperation m54078i(Context context) {
        try {
            return new DBOperation(context, OfflineDBCreator.m54155a());
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: l */
    private boolean m54075l() {
        if (f5147c == null) {
            f5147c = m54078i(this.f5148a);
        }
        return f5147c != null;
    }

    /* renamed from: a */
    public final synchronized UpdateItem m54086a(String str) {
        if (m54075l()) {
            List m55451p = f5147c.m55451p(DTInfo.m54251f(str), UpdateItem.class);
            if (m55451p.size() > 0) {
                return (UpdateItem) m55451p.get(0);
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    public final ArrayList<UpdateItem> m54084c() {
        ArrayList<UpdateItem> arrayList = new ArrayList<>();
        if (m54075l()) {
            for (UpdateItem updateItem : f5147c.m55451p("", UpdateItem.class)) {
                arrayList.add(updateItem);
            }
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: e */
    public final synchronized void m54082e(UpdateItem updateItem) {
        if (m54075l()) {
            f5147c.m55459h(updateItem, DTInfo.m54249h(updateItem.m54247j()));
            m54079h(updateItem.m54252e(), updateItem.m54537k());
        }
    }

    /* renamed from: f */
    public final void m54081f(String str, int i, long j, long j2, long j3) {
        if (m54075l()) {
            m54080g(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    /* renamed from: j */
    public final synchronized List<String> m54077j(String str) {
        ArrayList arrayList = new ArrayList();
        if (m54075l()) {
            arrayList.addAll(m54083d(f5147c.m55451p(DTFileInfo.m54416b(str), DTFileInfo.class)));
            return arrayList;
        }
        return arrayList;
    }

    /* renamed from: k */
    public final synchronized void m54076k(UpdateItem updateItem) {
        if (m54075l()) {
            f5147c.m55457j(DTInfo.m54249h(updateItem.m54247j()), DTInfo.class);
            f5147c.m55457j(DTFileInfo.m54416b(updateItem.m54252e()), DTFileInfo.class);
            f5147c.m55457j(DTDownloadInfo.m54452a(updateItem.m54252e()), DTDownloadInfo.class);
        }
    }

    /* renamed from: m */
    public final synchronized void m54074m(String str) {
        if (m54075l()) {
            f5147c.m55457j(DTInfo.m54251f(str), DTInfo.class);
            f5147c.m55457j(DTFileInfo.m54416b(str), DTFileInfo.class);
            f5147c.m55457j(DTDownloadInfo.m54452a(str), DTDownloadInfo.class);
        }
    }

    /* renamed from: n */
    public final synchronized String m54073n(String str) {
        if (m54075l()) {
            List m55451p = f5147c.m55451p(DTInfo.m54249h(str), DTInfo.class);
            return m55451p.size() > 0 ? ((DTInfo) m55451p.get(0)).m54254c() : null;
        }
        return null;
    }
}
