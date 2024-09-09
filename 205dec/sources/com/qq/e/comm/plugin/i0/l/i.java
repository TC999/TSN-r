package com.qq.e.comm.plugin.i0.l;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: h  reason: collision with root package name */
    private static final String f44293h = f.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private static volatile i f44294i;

    /* renamed from: b  reason: collision with root package name */
    private volatile List<String> f44296b;

    /* renamed from: c  reason: collision with root package name */
    private volatile List<String> f44297c;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f44298d;

    /* renamed from: e  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.i0.l.k.c f44299e;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f44300f;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f44295a = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f44301g = new a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.b();
        }
    }

    private i() {
    }

    public static i a() {
        if (f44294i == null) {
            synchronized (i.class) {
                if (f44294i == null) {
                    f44294i = new i();
                }
            }
        }
        return f44294i;
    }

    private void a(String str, long j4, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 0, this, str, Long.valueOf(j4), Integer.valueOf(i4));
    }

    public void a(List<String> list, boolean z3) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, 0, this, list, Boolean.valueOf(z3));
    }

    public void b() {
        pro.getVresult(217, 0, this);
    }
}
