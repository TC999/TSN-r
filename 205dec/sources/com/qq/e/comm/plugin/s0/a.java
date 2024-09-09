package com.qq.e.comm.plugin.s0;

import android.database.Cursor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.g0.k0;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.p.d;
import com.qq.e.comm.plugin.p.h;
import com.qq.e.comm.plugin.util.s0;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, JSONArray> f46007a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f46008b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f46009c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f46010d;

    /* renamed from: e  reason: collision with root package name */
    private final int f46011e;

    /* renamed from: f  reason: collision with root package name */
    private long f46012f;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONObject f46020c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f46021d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g f46022e;

        b(JSONObject jSONObject, String str, g gVar) {
            this.f46020c = jSONObject;
            this.f46021d = str;
            this.f46022e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k0 a4 = e.a(this.f46020c);
            com.qq.e.comm.plugin.n0.c a5 = new com.qq.e.comm.plugin.n0.c().c(this.f46021d).a(this.f46022e).a(this.f46020c.optInt("producttype")).a(this.f46020c.optString("cl")).a(this.f46020c);
            if (a.a(a.this, a4.f43591c, a4.f43592d)) {
                a.a(a.this, 0L);
                v.a(5000024, a5);
                return;
            }
            JSONObject a6 = com.qq.e.comm.plugin.s0.b.a(a4);
            long currentTimeMillis = System.currentTimeMillis();
            v.a(5000015, a5);
            int b4 = com.qq.e.comm.plugin.s0.b.b(a6, 2);
            a.b(a.this, a4.f43591c, a4.f43592d);
            a.a(a.this, currentTimeMillis, b4, a5);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final a f46024a = new a(null);
    }

    /* synthetic */ a(C0889a c0889a) {
        this();
    }

    static /* synthetic */ long a(a aVar, long j4) {
        return pro.getJresult(167, 1, aVar, Long.valueOf(j4));
    }

    public static a a() {
        return (a) pro.getobjresult(168, 1, new Object[0]);
    }

    private File a(String str) {
        return (File) pro.getobjresult(169, 0, this, str);
    }

    private String a(String str, String str2) {
        return (String) pro.getobjresult(170, 0, this, str, str2);
    }

    private JSONObject a(File file, String str, String str2, Cursor cursor) {
        return (JSONObject) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 0, this, file, str, str2, cursor);
    }

    private void a(long j4, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 0, this, Long.valueOf(j4), Integer.valueOf(i4), cVar);
    }

    static /* synthetic */ void a(a aVar, long j4, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 1, aVar, Long.valueOf(j4), Integer.valueOf(i4), cVar);
    }

    static /* synthetic */ void a(a aVar, String str, JSONArray jSONArray) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 1, aVar, str, jSONArray);
    }

    static /* synthetic */ void a(a aVar, boolean z3, long j4, int i4, int i5) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 1, aVar, Boolean.valueOf(z3), Long.valueOf(j4), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private void a(String str, JSONArray jSONArray) {
        pro.getVresult(176, 0, this, str, jSONArray);
    }

    private void a(boolean z3, long j4, int i4, int i5) {
        pro.getVresult(177, 0, this, Boolean.valueOf(z3), Long.valueOf(j4), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    static /* synthetic */ boolean a(a aVar, String str, String str2) {
        return pro.getZresult(178, 1, aVar, str, str2);
    }

    private JSONArray b(String str) {
        return (JSONArray) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 0, this, str);
    }

    static /* synthetic */ void b(a aVar, String str, String str2) {
        pro.getVresult(180, 1, aVar, str, str2);
    }

    private void b(String str, JSONArray jSONArray) {
        pro.getVresult(181, 0, this, str, jSONArray);
    }

    private boolean c(String str, String str2) {
        return pro.getZresult(182, 0, this, str, str2);
    }

    private void d(String str, String str2) {
        pro.getVresult(183, 0, this, str, str2);
    }

    public void a(String str, String str2, Cursor cursor) {
        pro.getVresult(184, 0, this, str, str2, cursor);
    }

    public void a(JSONObject jSONObject, String str, g gVar) {
        pro.getVresult(185, 0, this, jSONObject, str, gVar);
    }

    public JSONArray b(String str, String str2) {
        return (JSONArray) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 0, this, str, str2);
    }

    public boolean b() {
        return pro.getZresult(187, 0, this);
    }

    private a() {
        this.f46007a = new HashMap();
        this.f46008b = new HashSet();
        this.f46009c = new HashSet();
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("wgpde", 1);
        a4 = a4 > 2 ? com.qq.e.comm.plugin.t.a.b().a(String.valueOf(a4), 1) : a4;
        this.f46011e = a4;
        this.f46010d = a4 > 0;
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.s0.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0889a extends h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46013a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f46014b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f46015c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f46016d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f46017e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONArray f46018f;

        C0889a(String str, long j4, int i4, AtomicInteger atomicInteger, String str2, JSONArray jSONArray) {
            this.f46013a = str;
            this.f46014b = j4;
            this.f46015c = i4;
            this.f46016d = atomicInteger;
            this.f46017e = str2;
            this.f46018f = jSONArray;
        }

        @Override // com.qq.e.comm.plugin.p.b
        public void a(File file, long j4) {
            if (!this.f46013a.equals(s0.a(file))) {
                file.delete();
                a.a(a.this, false, this.f46014b, this.f46015c, 8);
            } else if (this.f46016d.incrementAndGet() == this.f46015c) {
                a.a(a.this, this.f46017e, this.f46018f);
                a.a(a.this, true, this.f46014b, this.f46015c, 0);
            }
        }

        @Override // com.qq.e.comm.plugin.p.h, com.qq.e.comm.plugin.p.b
        public void a(d dVar) {
            a.a(a.this, false, this.f46014b, this.f46015c, dVar.a());
        }
    }
}
