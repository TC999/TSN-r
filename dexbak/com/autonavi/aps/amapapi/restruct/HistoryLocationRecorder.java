package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0463l.ALLog;
import com.amap.api.col.p0463l.AmapWifi;
import com.amap.api.col.p0463l.Encrypt;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.security.C2422a;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.autonavi.aps.amapapi.restruct.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HistoryLocationRecorder {

    /* renamed from: b */
    private File f8175b;

    /* renamed from: d */
    private Handler f8177d;

    /* renamed from: e */
    private String f8178e;

    /* renamed from: f */
    private boolean f8179f;

    /* renamed from: a */
    private LinkedList<HistoryLocation> f8174a = new LinkedList<>();

    /* renamed from: c */
    private boolean f8176c = false;

    /* renamed from: g */
    private Runnable f8180g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (HistoryLocationRecorder.this.f8176c) {
                return;
            }
            if (HistoryLocationRecorder.this.f8179f) {
                HistoryLocationRecorder.this.m51519b();
                HistoryLocationRecorder.m51514d(HistoryLocationRecorder.this);
            }
            if (HistoryLocationRecorder.this.f8177d != null) {
                HistoryLocationRecorder.this.f8177d.postDelayed(HistoryLocationRecorder.this.f8180g, 60000L);
            }
        }
    };

    public HistoryLocationRecorder(Context context, Handler handler) {
        this.f8178e = null;
        this.f8177d = handler;
        String path = context.getFilesDir().getPath();
        if (this.f8178e == null) {
            this.f8178e = C2432j.m51155l(context);
        }
        try {
            this.f8175b = new File(path, "hisloc");
        } catch (Throwable th) {
            ALLog.m54456a(th);
        }
        m51524a();
        Handler handler2 = this.f8177d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.f8180g);
            this.f8177d.postDelayed(this.f8180g, 60000L);
        }
    }

    /* renamed from: d */
    static /* synthetic */ boolean m51514d(HistoryLocationRecorder historyLocationRecorder) {
        historyLocationRecorder.f8179f = false;
        return false;
    }

    /* renamed from: a */
    public final void m51520a(boolean z) {
        if (!z) {
            this.f8180g.run();
        }
        Handler handler = this.f8177d;
        if (handler != null) {
            handler.removeCallbacks(this.f8180g);
        }
        this.f8176c = true;
    }

    /* renamed from: b */
    public final void m51518b(HistoryLocation historyLocation) {
        if (this.f8174a.size() > 0) {
            int i = historyLocation.f8166a;
            if (i != 6 && i != 5) {
                if (this.f8174a.contains(historyLocation)) {
                    return;
                }
                if (this.f8174a.size() >= 10) {
                    this.f8174a.removeFirst();
                }
                this.f8174a.add(historyLocation);
                this.f8179f = true;
                return;
            }
            HistoryLocation last = this.f8174a.getLast();
            if (last.f8168c == historyLocation.f8168c && last.f8167b == historyLocation.f8167b && last.f8170e == historyLocation.f8170e) {
                return;
            }
            if (this.f8174a.size() >= 10) {
                this.f8174a.removeFirst();
            }
            this.f8174a.add(historyLocation);
            this.f8179f = true;
        }
    }

    /* renamed from: a */
    public final void m51523a(HistoryLocation historyLocation) {
        Iterator<HistoryLocation> it = this.f8174a.iterator();
        HistoryLocation historyLocation2 = null;
        HistoryLocation historyLocation3 = null;
        int i = 0;
        while (it.hasNext()) {
            HistoryLocation next = it.next();
            if (next.f8166a == 1) {
                if (historyLocation3 == null) {
                    historyLocation3 = next;
                }
                i++;
                historyLocation2 = next;
            }
        }
        if (historyLocation2 != null) {
            new Location(GeocodeSearch.GPS);
            if (historyLocation.f8169d - historyLocation2.f8169d < 20000 && C2432j.m51187a(new double[]{historyLocation.f8167b, historyLocation.f8168c, historyLocation2.f8167b, historyLocation2.f8168c}) < 20.0f) {
                return;
            }
        }
        if (i >= 5) {
            this.f8174a.remove(historyLocation3);
        }
        if (this.f8174a.size() >= 10) {
            this.f8174a.removeFirst();
        }
        this.f8174a.add(historyLocation);
        this.f8179f = true;
    }

    /* renamed from: b */
    private static boolean m51516b(ArrayList<Cgi> arrayList, ArrayList<AmapWifi> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    /* renamed from: a */
    public final List<HistoryLocation> m51521a(ArrayList<Cgi> arrayList, ArrayList<AmapWifi> arrayList2) {
        if (m51516b(arrayList, arrayList2)) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            Iterator<HistoryLocation> it = this.f8174a.iterator();
            while (it.hasNext()) {
                HistoryLocation next = it.next();
                if (currentTimeMillis - next.f8169d < 21600000000L) {
                    arrayList3.add(next);
                    i++;
                }
                if (i == 10) {
                    break;
                }
            }
            return arrayList3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m51519b() {
        StringBuilder sb = new StringBuilder();
        Iterator<HistoryLocation> it = this.f8174a.iterator();
        while (it.hasNext()) {
            try {
                String m51526a = it.next().m51526a();
                sb.append(Encrypt.m54719f(C2422a.m51453a(m51526a.getBytes("UTF-8"), this.f8178e)) + ShellAdbUtils.f33810d);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        C2432j.m51192a(this.f8175b, sb2);
    }

    /* renamed from: a */
    private void m51524a() {
        LinkedList<HistoryLocation> linkedList = this.f8174a;
        if (linkedList == null || linkedList.size() <= 0) {
            for (String str : C2432j.m51193a(this.f8175b)) {
                try {
                    String str2 = new String(C2422a.m51450b(Encrypt.m54718g(str), this.f8178e), "UTF-8");
                    HistoryLocation historyLocation = new HistoryLocation();
                    historyLocation.m51525a(new JSONObject(str2));
                    this.f8174a.add(historyLocation);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
