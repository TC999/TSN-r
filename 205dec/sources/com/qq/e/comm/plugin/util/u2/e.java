package com.qq.e.comm.plugin.util.u2;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private c f46624a;

    /* renamed from: b  reason: collision with root package name */
    private f f46625b;

    /* renamed from: c  reason: collision with root package name */
    private d f46626c;

    /* renamed from: d  reason: collision with root package name */
    private g f46627d;

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<String> f46628e;

    /* renamed from: f  reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f46629f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46630g;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ StackTraceElement[] f46631c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f46632d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f46633e;

        a(StackTraceElement[] stackTraceElementArr, String str, int i4) {
            this.f46631c = stackTraceElementArr;
            this.f46632d = str;
            this.f46633e = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(this.f46631c, this.f46632d, this.f46633e);
            e.this.b(this.f46631c, this.f46632d, this.f46633e);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final e f46635a = new e(null);
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    private int b(String str) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 0, this, str);
    }

    public static e b() {
        return (e) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 1, new Object[0]);
    }

    public int a(String str) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 0, this, str);
    }

    public int a(String str, Context context) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, 0, this, str, context);
    }

    public void a() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 0, this);
    }

    public void a(int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE, 0, this, Integer.valueOf(i4));
    }

    public void a(String str, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 0, this, str, Integer.valueOf(i4));
    }

    boolean a(StackTraceElement[] stackTraceElementArr, String str, int i4) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET, 0, this, stackTraceElementArr, str, Integer.valueOf(i4));
    }

    boolean b(StackTraceElement[] stackTraceElementArr, String str, int i4) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, 0, this, stackTraceElementArr, str, Integer.valueOf(i4));
    }

    public int c(String str) {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP, 0, this, str);
    }

    public void c() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 0, this);
    }

    private e() {
        c();
    }
}
