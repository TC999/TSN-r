package com.mbridge.msdk.e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.r;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.reward.adapter.d;
import java.util.LinkedList;
import java.util.List;

/* compiled from: LoopTimer.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private long f39003a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f39004b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<k> f39005c;

    /* renamed from: d  reason: collision with root package name */
    private LinkedList<k> f39006d;

    /* renamed from: e  reason: collision with root package name */
    private int f39007e;

    /* renamed from: f  reason: collision with root package name */
    private int f39008f;

    /* renamed from: g  reason: collision with root package name */
    private f f39009g;

    /* renamed from: h  reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f39010h;

    /* renamed from: i  reason: collision with root package name */
    private r f39011i;

    /* renamed from: j  reason: collision with root package name */
    private i f39012j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f39013k;

    /* compiled from: LoopTimer.java */
    /* renamed from: com.mbridge.msdk.e.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class C0733a {

        /* renamed from: a  reason: collision with root package name */
        static a f39017a = new a();
    }

    static /* synthetic */ void c(a aVar) {
        try {
            LinkedList<k> linkedList = aVar.f39005c;
            if (linkedList != null && linkedList.size() > 0 && aVar.f39007e < aVar.f39005c.size()) {
                k kVar = aVar.f39005c.get(aVar.f39007e);
                aVar.f39007e++;
                if (aVar.a(kVar)) {
                    aVar.a(kVar.b(), kVar.a(), false);
                }
            } else {
                LinkedList<k> linkedList2 = aVar.f39006d;
                if (linkedList2 != null && linkedList2.size() > 0 && aVar.f39008f < aVar.f39006d.size()) {
                    k kVar2 = aVar.f39006d.get(aVar.f39008f);
                    aVar.f39008f++;
                    if (aVar.a(kVar2)) {
                        aVar.a(kVar2.b(), kVar2.a(), true);
                    }
                }
            }
        } catch (Throwable th) {
            x.b("LoopTimer", th.getMessage(), th);
        }
    }

    private a() {
        this.f39004b = false;
        this.f39005c = new LinkedList<>();
        this.f39006d = new LinkedList<>();
        this.f39007e = 0;
        this.f39008f = 0;
        this.f39013k = new Handler() { // from class: com.mbridge.msdk.e.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (a.this) {
                    int i4 = message.what;
                    if (i4 != 1) {
                        if (i4 == 2) {
                            a.c(a.this);
                        }
                    } else if (a.this.f39004b) {
                    } else {
                        a aVar = a.this;
                        a.a(aVar, aVar.f39003a);
                        sendMessageDelayed(obtainMessage(1), a.this.f39003a);
                    }
                }
            }
        };
    }

    private boolean a(k kVar) {
        boolean z3 = false;
        if (kVar == null || TextUtils.isEmpty(kVar.a())) {
            return false;
        }
        String a4 = kVar.a();
        try {
            if (this.f39009g != null) {
                com.mbridge.msdk.videocommon.d.a aVar = this.f39010h;
                int a5 = this.f39009g.a(a4, aVar != null ? aVar.e() : 0L);
                if (a5 != -1) {
                    if (a5 != 1) {
                    }
                } else if (!TextUtils.isEmpty(a4)) {
                    LinkedList<k> linkedList = this.f39005c;
                    if (linkedList != null && linkedList.contains(a4)) {
                        this.f39005c.remove(a4);
                    } else {
                        LinkedList<k> linkedList2 = this.f39006d;
                        if (linkedList2 != null && linkedList2.contains(a4)) {
                            this.f39006d.remove(a4);
                        }
                    }
                    r rVar = this.f39011i;
                    if (rVar != null) {
                        rVar.a(a4);
                    }
                }
                try {
                    Handler handler = this.f39013k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    x.b("LoopTimer", th.getMessage(), th);
                    return z3;
                }
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            z3 = true;
        }
    }

    public final void b(String str, String str2) {
        if (this.f39006d.contains(str2)) {
            return;
        }
        this.f39006d.add(new k(str, str2, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA));
        r rVar = this.f39011i;
        if (rVar != null) {
            rVar.a(str, str2, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA);
        }
    }

    private void a(String str, String str2, boolean z3) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                return;
            }
            final d dVar = new d(j4, str, str2);
            dVar.a(z3);
            dVar.a(new com.mbridge.msdk.reward.adapter.b() { // from class: com.mbridge.msdk.e.a.2
                public final void a() {
                }

                public final void a(String str3) {
                    a.this.f39013k.sendMessage(a.this.f39013k.obtainMessage(2));
                    dVar.a((com.mbridge.msdk.reward.adapter.b) null);
                }

                public final void b(String str3) {
                    a.this.f39013k.sendMessage(a.this.f39013k.obtainMessage(2));
                    dVar.a((com.mbridge.msdk.reward.adapter.b) null);
                }
            });
            dVar.a(1, (int) AVMDLDataLoader.KeyIsLiveSetLoaderType, false);
        } catch (Exception e4) {
            x.b("LoopTimer", e4.getMessage(), e4);
        }
    }

    public final void a(String str, String str2) {
        if (this.f39005c.contains(str2)) {
            return;
        }
        this.f39005c.add(new k(str, str2, 94));
        r rVar = this.f39011i;
        if (rVar != null) {
            rVar.a(str, str2, 94);
        }
    }

    public final void a(long j4) {
        if (this.f39012j == null) {
            this.f39012j = i.a(com.mbridge.msdk.foundation.controller.a.f().j());
        }
        if (this.f39011i == null) {
            this.f39011i = r.a(this.f39012j);
        }
        List<k> a4 = this.f39011i.a(MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA);
        if (a4 != null) {
            this.f39006d.addAll(a4);
            for (k kVar : a4) {
                b(kVar.b(), kVar.a());
            }
        }
        List<k> a5 = this.f39011i.a(94);
        if (a5 != null) {
            this.f39005c.addAll(a5);
            for (k kVar2 : a5) {
                a(kVar2.b(), kVar2.a());
            }
        }
        if (this.f39009g == null) {
            this.f39009g = f.a(this.f39012j);
        }
        if (this.f39010h == null) {
            this.f39010h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.f39003a = j4;
        this.f39004b = false;
        Handler handler = this.f39013k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f39003a);
    }

    static /* synthetic */ void a(a aVar, long j4) {
        LinkedList<k> linkedList = aVar.f39005c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.f39007e == 0 || aVar.f39005c.size() <= aVar.f39007e) {
            LinkedList<k> linkedList2 = aVar.f39006d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f39008f == 0 || aVar.f39006d.size() == aVar.f39008f) {
                aVar.f39008f = 0;
                aVar.f39007e = 0;
                Handler handler = aVar.f39013k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }
}
