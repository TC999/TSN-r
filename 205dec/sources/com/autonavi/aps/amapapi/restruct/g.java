package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.j4;
import com.amap.api.col.p0003l.k9;
import com.amap.api.col.p0003l.n9;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HistoryLocationRecorder.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {

    /* renamed from: b  reason: collision with root package name */
    private File f11852b;

    /* renamed from: d  reason: collision with root package name */
    private Handler f11854d;

    /* renamed from: e  reason: collision with root package name */
    private String f11855e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11856f;

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<f> f11851a = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f11853c = false;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f11857g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (g.this.f11853c) {
                return;
            }
            if (g.this.f11856f) {
                g.this.b();
                g.d(g.this);
            }
            if (g.this.f11854d != null) {
                g.this.f11854d.postDelayed(g.this.f11857g, 60000L);
            }
        }
    };

    public g(Context context, Handler handler) {
        this.f11855e = null;
        this.f11854d = handler;
        String path = context.getFilesDir().getPath();
        if (this.f11855e == null) {
            this.f11855e = com.autonavi.aps.amapapi.utils.j.l(context);
        }
        try {
            this.f11852b = new File(path, "hisloc");
        } catch (Throwable th) {
            n9.a(th);
        }
        a();
        Handler handler2 = this.f11854d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.f11857g);
            this.f11854d.postDelayed(this.f11857g, 60000L);
        }
    }

    static /* synthetic */ boolean d(g gVar) {
        gVar.f11856f = false;
        return false;
    }

    public final void a(boolean z3) {
        if (!z3) {
            this.f11857g.run();
        }
        Handler handler = this.f11854d;
        if (handler != null) {
            handler.removeCallbacks(this.f11857g);
        }
        this.f11853c = true;
    }

    public final void b(f fVar) {
        if (this.f11851a.size() > 0) {
            int i4 = fVar.f11843a;
            if (i4 != 6 && i4 != 5) {
                if (this.f11851a.contains(fVar)) {
                    return;
                }
                if (this.f11851a.size() >= 10) {
                    this.f11851a.removeFirst();
                }
                this.f11851a.add(fVar);
                this.f11856f = true;
                return;
            }
            f last = this.f11851a.getLast();
            if (last.f11845c == fVar.f11845c && last.f11844b == fVar.f11844b && last.f11847e == fVar.f11847e) {
                return;
            }
            if (this.f11851a.size() >= 10) {
                this.f11851a.removeFirst();
            }
            this.f11851a.add(fVar);
            this.f11856f = true;
        }
    }

    public final void a(f fVar) {
        Iterator<f> it = this.f11851a.iterator();
        f fVar2 = null;
        f fVar3 = null;
        int i4 = 0;
        while (it.hasNext()) {
            f next = it.next();
            if (next.f11843a == 1) {
                if (fVar3 == null) {
                    fVar3 = next;
                }
                i4++;
                fVar2 = next;
            }
        }
        if (fVar2 != null) {
            new Location("gps");
            if (fVar.f11846d - fVar2.f11846d < 20000 && com.autonavi.aps.amapapi.utils.j.a(new double[]{fVar.f11844b, fVar.f11845c, fVar2.f11844b, fVar2.f11845c}) < 20.0f) {
                return;
            }
        }
        if (i4 >= 5) {
            this.f11851a.remove(fVar3);
        }
        if (this.f11851a.size() >= 10) {
            this.f11851a.removeFirst();
        }
        this.f11851a.add(fVar);
        this.f11856f = true;
    }

    private static boolean b(ArrayList<d> arrayList, ArrayList<k9> arrayList2) {
        return arrayList == null || arrayList.size() <= 0 || arrayList2 == null || arrayList2.size() <= 0 || (((long) arrayList.size()) < 4 && ((long) arrayList2.size()) < 20);
    }

    public final List<f> a(ArrayList<d> arrayList, ArrayList<k9> arrayList2) {
        if (b(arrayList, arrayList2)) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList3 = new ArrayList();
            int i4 = 0;
            Iterator<f> it = this.f11851a.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (currentTimeMillis - next.f11846d < 21600000000L) {
                    arrayList3.add(next);
                    i4++;
                }
                if (i4 == 10) {
                    break;
                }
            }
            return arrayList3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.f11851a.iterator();
        while (it.hasNext()) {
            try {
                String a4 = it.next().a();
                sb.append(j4.f(com.autonavi.aps.amapapi.security.a.a(a4.getBytes("UTF-8"), this.f11855e)) + "\n");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.j.a(this.f11852b, sb2);
    }

    private void a() {
        LinkedList<f> linkedList = this.f11851a;
        if (linkedList == null || linkedList.size() <= 0) {
            for (String str : com.autonavi.aps.amapapi.utils.j.a(this.f11852b)) {
                try {
                    String str2 = new String(com.autonavi.aps.amapapi.security.a.b(j4.g(str), this.f11855e), "UTF-8");
                    f fVar = new f();
                    fVar.a(new JSONObject(str2));
                    this.f11851a.add(fVar);
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }
}
