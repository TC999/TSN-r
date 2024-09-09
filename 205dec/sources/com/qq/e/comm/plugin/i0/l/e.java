package com.qq.e.comm.plugin.i0.l;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: j  reason: collision with root package name */
    private static final String f44262j = f.class.getSimpleName();

    /* renamed from: k  reason: collision with root package name */
    private static volatile e f44263k;

    /* renamed from: b  reason: collision with root package name */
    private volatile List<String> f44265b;

    /* renamed from: c  reason: collision with root package name */
    private volatile List<String> f44266c;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f44267d;

    /* renamed from: e  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.i0.l.k.c f44268e;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f44269f;

    /* renamed from: g  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.i0.l.k.c f44270g;

    /* renamed from: h  reason: collision with root package name */
    private volatile Random f44271h;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f44264a = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f44272i = new a();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b();
        }
    }

    private e() {
    }

    private void a(String str, long j4, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 0, this, str, Long.valueOf(j4), Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 0, this);
    }

    public void a(List<String> list, boolean z3) {
        pro.getVresult(222, 0, this, list, Boolean.valueOf(z3));
    }

    public static e a() {
        if (f44263k == null) {
            synchronized (e.class) {
                if (f44263k == null) {
                    f44263k = new e();
                }
            }
        }
        return f44263k;
    }
}
