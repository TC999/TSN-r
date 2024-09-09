package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.embedapplog.collector.Collector;
import com.bytedance.embedapplog.util.UriConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys implements Handler.Callback, Comparator<up> {
    private static long bk;

    /* renamed from: w  reason: collision with root package name */
    private static ys f26853w;

    /* renamed from: a  reason: collision with root package name */
    private ia f26854a;

    /* renamed from: c  reason: collision with root package name */
    public Application f26855c;
    private Handler ev;

    /* renamed from: f  reason: collision with root package name */
    private mt f26856f;
    private s gd;

    /* renamed from: k  reason: collision with root package name */
    private Handler f26857k;

    /* renamed from: p  reason: collision with root package name */
    private UriConfig f26858p;

    /* renamed from: r  reason: collision with root package name */
    private ck f26859r;
    private n sr;
    private final ArrayList<up> ux = new ArrayList<>(32);
    private a xv;

    private ys() {
    }

    public static void c() {
        if (f26853w != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - bk) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                bk = currentTimeMillis;
                f26853w.c((String[]) null, true);
            }
        }
    }

    public static ys f() {
        if (f26853w == null) {
            synchronized (ys.class) {
                if (f26853w == null) {
                    f26853w = new ys();
                }
            }
        }
        return f26853w;
    }

    private void gd() {
        if (this.sr.i()) {
            if (this.xv == null) {
                a aVar = new a(this);
                this.xv = aVar;
                this.ev.obtainMessage(6, aVar).sendToTarget();
                return;
            }
            return;
        }
        a aVar2 = this.xv;
        if (aVar2 != null) {
            aVar2.ux();
            this.xv = null;
        }
    }

    private void p() {
        if (be.f26702w) {
            be.c("packAndSend once, " + this.gd.c() + ", hadUI:" + this.gd.w(), null);
        }
        ia iaVar = this.f26854a;
        if (iaVar != null) {
            iaVar.ev();
        }
        if (this.ev != null) {
            this.f26854a.c(g.c());
            this.ev.sendMessage(this.f26857k.obtainMessage(6, this.f26854a));
        }
    }

    public UriConfig ev() {
        if (this.f26858p == null) {
            UriConfig uriConfig = this.sr.up().getUriConfig();
            this.f26858p = uriConfig;
            if (uriConfig == null) {
                this.f26858p = com.bytedance.embedapplog.util.c.c(0);
            }
        }
        return this.f26858p;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i4 = message.what;
            if (i4 == 1) {
                be.f26701c = this.sr.q();
                if (this.f26859r.sr()) {
                    if (this.sr.ia()) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                        handlerThread.start();
                        Handler handler = new Handler(handlerThread.getLooper(), this);
                        this.ev = handler;
                        handler.sendEmptyMessage(2);
                        if (this.ux.size() > 0) {
                            this.f26857k.removeMessages(4);
                            this.f26857k.sendEmptyMessageDelayed(4, 1000L);
                        }
                        be.sr("net|worker start", null);
                    }
                } else {
                    this.f26857k.removeMessages(1);
                    this.f26857k.sendEmptyMessageDelayed(1, 1000L);
                }
                u.c();
            } else if (i4 == 2) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(new fp(this));
                arrayList.add(new t(this));
                ia iaVar = new ia(this);
                this.f26854a = iaVar;
                arrayList.add(iaVar);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    bk bkVar = (bk) it.next();
                    if (bkVar instanceof ia) {
                        this.f26854a.c(g.c());
                    }
                    long r3 = bkVar.r();
                    if (r3 < 864000000) {
                        this.ev.sendMessageDelayed(this.f26857k.obtainMessage(6, bkVar), r3);
                    }
                }
                this.f26854a.c(true);
                gd();
            } else if (i4 == 4) {
                c((String[]) null, false);
            } else if (i4 == 5) {
                c((String[]) message.obj, false);
            } else if (i4 == 6) {
                bk bkVar2 = (bk) message.obj;
                if (!bkVar2.f()) {
                    long r4 = bkVar2.r();
                    if (r4 < 864000000) {
                        this.ev.sendMessageDelayed(this.f26857k.obtainMessage(6, bkVar2), r4);
                    }
                    gd();
                }
                this.f26854a.c(true);
            } else if (i4 != 7) {
                be.w((Throwable) null);
            } else {
                synchronized (this.ux) {
                    this.ux.add(s.ux());
                }
                c((String[]) null, false);
            }
        } catch (Throwable th) {
            be.c("engine:" + th.getMessage());
        }
        return true;
    }

    public s r() {
        return this.gd;
    }

    public n sr() {
        return this.sr;
    }

    public ck ux() {
        return this.f26859r;
    }

    public Context w() {
        return this.f26855c;
    }

    public mt xv() {
        return this.f26856f;
    }

    public void c(Application application, n nVar, ck ckVar, k kVar) {
        this.f26855c = application;
        this.f26856f = new mt(this);
        this.sr = nVar;
        this.f26859r = ckVar;
        this.gd = new s(this.f26859r, this.sr);
        this.f26855c.registerActivityLifecycleCallbacks(kVar);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f26857k = handler;
        handler.sendEmptyMessage(1);
        ge.c(nVar.ev() != 0);
    }

    private void c(String[] strArr, boolean z3) {
        ArrayList<up> arrayList;
        synchronized (this.ux) {
            arrayList = (ArrayList) this.ux.clone();
            this.ux.clear();
        }
        int i4 = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(up.c(str));
            }
        }
        boolean c4 = this.sr.c(arrayList);
        if (arrayList.size() > 0) {
            if (this.sr.ia()) {
                if (!c4 && arrayList.size() <= 100) {
                    synchronized (this.ux) {
                        this.ux.addAll(arrayList);
                    }
                    return;
                }
                Collections.sort(arrayList, this);
                ArrayList<up> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator<up> it = arrayList.iterator();
                boolean z4 = false;
                boolean z5 = false;
                while (it.hasNext()) {
                    up next = it.next();
                    z4 |= this.gd.c(next, arrayList2);
                    if (next instanceof wo) {
                        z5 = s.c(next);
                        i4 = 1;
                    }
                }
                this.f26856f.c(arrayList2);
                if (i4 != 0) {
                    if (z5) {
                        this.f26857k.removeMessages(7);
                    } else if (!g.w() && g.c()) {
                        this.f26857k.sendEmptyMessageDelayed(7, this.sr.j());
                    }
                }
                if (z4 || z3) {
                    p();
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.f26855c, Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i5 = 0;
            while (i4 < size) {
                strArr2[i4] = arrayList.get(i4).ux().toString();
                i5 += strArr2[i4].length();
                i4++;
            }
            if (i5 >= 307200) {
                be.w((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.f26855c.sendBroadcast(intent);
            } catch (Exception e4) {
                be.w(e4);
            }
        }
    }

    public static void c(up upVar) {
        int size;
        Handler handler;
        ys ysVar = f26853w;
        if (ysVar == null) {
            be.w("Init comes First!", null);
            u.c(upVar);
            return;
        }
        if (upVar.f26814w == 0) {
            be.w((Throwable) null);
        }
        synchronized (ysVar.ux) {
            size = ysVar.ux.size();
            ysVar.ux.add(upVar);
        }
        if (size % 10 != 0 || (handler = ysVar.f26857k) == null) {
            return;
        }
        handler.removeMessages(4);
        ysVar.f26857k.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void c(String[] strArr) {
        ys ysVar = f26853w;
        if (ysVar == null) {
            be.w(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = ysVar.f26857k;
        if (handler != null) {
            handler.removeMessages(4);
            ysVar.f26857k.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* renamed from: c */
    public int compare(up upVar, up upVar2) {
        long j4 = upVar.f26814w - upVar2.f26814w;
        if (j4 < 0) {
            return -1;
        }
        return j4 > 0 ? 1 : 0;
    }
}
