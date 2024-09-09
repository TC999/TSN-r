package com.qq.e.comm.plugin.l0;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.i0.j;
import com.qq.e.comm.plugin.util.b2;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f2;
import com.qq.e.comm.plugin.util.h0;
import com.qq.e.comm.plugin.util.t2;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f44592a = 10;

    /* renamed from: b  reason: collision with root package name */
    private static b2 f44593b = new b2(e());

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f44594c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicBoolean f44595d;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f44596c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f44597d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f44598e;

        a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, c cVar) {
            this.f44596c = dVar;
            this.f44597d = bVar;
            this.f44598e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d1.a("load ad in background thread", new Object[0]);
            com.qq.e.comm.plugin.b.d dVar = this.f44596c;
            d.a(dVar, this.f44597d, this.f44598e, d.a(dVar.K()));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(com.qq.e.comm.plugin.s.b bVar);

        void a(JSONObject jSONObject);
    }

    static {
        f44594c = com.qq.e.comm.plugin.d0.a.d().f().a("laibg", 1) == 1;
        f44595d = new AtomicBoolean(false);
    }

    private static com.qq.e.comm.plugin.s.b a(String str) {
        return (com.qq.e.comm.plugin.s.b) pro.getobjresult(496, 1, str);
    }

    static /* synthetic */ String a(boolean z3) {
        return (String) pro.getobjresult(497, 1, Boolean.valueOf(z3));
    }

    private static JSONArray a(JSONObject jSONObject, JSONObject jSONObject2, com.qq.e.comm.plugin.l0.b bVar) {
        return (JSONArray) pro.getobjresult(498, 1, jSONObject, jSONObject2, bVar);
    }

    static /* synthetic */ JSONObject a(com.qq.e.comm.plugin.b.d dVar, JSONObject jSONObject, com.qq.e.comm.plugin.l0.b bVar, String str) throws JSONException {
        return (JSONObject) pro.getobjresult(499, 1, dVar, jSONObject, bVar, str);
    }

    private static JSONObject a(boolean z3, JSONObject jSONObject, com.qq.e.comm.plugin.l0.b bVar) throws JSONException {
        return (JSONObject) pro.getobjresult(500, 1, Boolean.valueOf(z3), jSONObject, bVar);
    }

    static /* synthetic */ void a() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE, 1, new Object[0]);
    }

    public static void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, c cVar) {
        pro.getVresult(502, 1, dVar, bVar, cVar);
    }

    static /* synthetic */ void a(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, c cVar, String str) {
        pro.getVresult(503, 1, dVar, bVar, cVar, str);
    }

    static /* synthetic */ void a(com.qq.e.comm.plugin.l0.b bVar, long j4, boolean z3, int i4) {
        pro.getVresult(504, 1, bVar, Long.valueOf(j4), Boolean.valueOf(z3), Integer.valueOf(i4));
    }

    private static void a(JSONObject jSONObject, int i4, String str, String str2, JSONObject jSONObject2, boolean z3, double d4, boolean z4) throws JSONException {
        pro.getVresult(505, 1, jSONObject, Integer.valueOf(i4), str, str2, jSONObject2, Boolean.valueOf(z3), Double.valueOf(d4), Boolean.valueOf(z4));
    }

    private static void a(JSONObject jSONObject, com.qq.e.comm.plugin.l0.b bVar) {
        pro.getVresult(506, 1, jSONObject, bVar);
    }

    private static boolean a(com.qq.e.comm.plugin.b.g gVar) {
        return pro.getZresult(507, 1, gVar);
    }

    private static boolean a(JSONObject jSONObject) {
        return pro.getZresult(508, 1, jSONObject);
    }

    private static String b(boolean z3) {
        return (String) pro.getobjresult(509, 1, Boolean.valueOf(z3));
    }

    private static JSONObject b(com.qq.e.comm.plugin.b.d dVar, JSONObject jSONObject, com.qq.e.comm.plugin.l0.b bVar, String str) throws JSONException {
        return (JSONObject) pro.getobjresult(510, 1, dVar, jSONObject, bVar, str);
    }

    static /* synthetic */ void b() {
        pro.getVresult(511, 1, new Object[0]);
    }

    private static void b(com.qq.e.comm.plugin.b.d dVar, com.qq.e.comm.plugin.l0.b bVar, c cVar, String str) {
        pro.getVresult(512, 1, dVar, bVar, cVar, str);
    }

    public static void b(com.qq.e.comm.plugin.b.g gVar) {
        pro.getVresult(513, 1, gVar);
    }

    private static void b(com.qq.e.comm.plugin.l0.b bVar, long j4, boolean z3, int i4) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE, 1, bVar, Long.valueOf(j4), Boolean.valueOf(z3), Integer.valueOf(i4));
    }

    public static String c() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, 1, new Object[0]);
    }

    public static String d() {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 1, new Object[0]);
    }

    private static int e() {
        return pro.getIresult(MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 1, new Object[0]);
    }

    private static boolean f() {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 1, new Object[0]);
    }

    private static void g() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX, 1, new Object[0]);
    }

    private static void h() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 1, new Object[0]);
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class b extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.l0.b f44599a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.d f44600b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f44601c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f44602d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ AtomicLong f44603e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f44604f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f44605g;

        b(com.qq.e.comm.plugin.l0.b bVar, com.qq.e.comm.plugin.b.d dVar, AtomicBoolean atomicBoolean, int i4, AtomicLong atomicLong, c cVar, long j4) {
            this.f44599a = bVar;
            this.f44600b = dVar;
            this.f44601c = atomicBoolean;
            this.f44602d = i4;
            this.f44603e = atomicLong;
            this.f44604f = cVar;
            this.f44605g = j4;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            int statusCode = gVar.getStatusCode();
            if (statusCode == 200) {
                d.a();
                e.b(this.f44599a, this.f44600b, this.f44601c.get(), this.f44602d);
                String str = null;
                try {
                    str = gVar.b();
                    f2.a("#loadADRes#", str, new Object[0]);
                    d.a(this.f44599a, this.f44603e.get(), fVar.a(), this.f44602d);
                    JSONObject jSONObject = new JSONObject(str);
                    com.qq.e.comm.plugin.m0.a.l().a(jSONObject);
                    String i4 = fVar.i();
                    h0.a(this.f44600b, jSONObject);
                    this.f44604f.a(d.a(this.f44600b, jSONObject, this.f44599a, i4));
                    d.b();
                    com.qq.e.comm.plugin.util.c.a(jSONObject, com.qq.e.comm.plugin.d0.a.d().a());
                } catch (JSONException e4) {
                    e.a(this.f44599a, this.f44600b, str);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.putOpt("ej", t2.a(str));
                    } catch (JSONException unused) {
                    }
                    this.f44604f.a(new com.qq.e.comm.plugin.s.b(jSONObject2.toString(), e4, 5001));
                } catch (Throwable th) {
                    e.a(this.f44599a, this.f44600b, th);
                    this.f44604f.a(new com.qq.e.comm.plugin.s.b(th, 3000));
                }
                com.qq.e.comm.plugin.l0.h.b.i();
                return;
            }
            e.a(this.f44599a, this.f44600b, statusCode, this.f44601c.get(), this.f44602d);
            GDTLogger.e("\u7f51\u7edc\u5f02\u5e38\uff0cHttp\u72b6\u6001\u7801\u975e200\uff0c\u72b6\u6001\u7801\u4e3a:" + statusCode);
            this.f44604f.a(new com.qq.e.comm.plugin.s.b("HttpStatus error", 3001));
            f2.a("#loadADRes#", "\u7f51\u7edc\u5f02\u5e38\uff0cHttp\u72b6\u6001\u7801\u975e200\uff0c\u72b6\u6001\u7801\u4e3a:%s", Integer.valueOf(statusCode));
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, int i4, Exception exc) {
            System.currentTimeMillis();
            this.f44604f.a(new com.qq.e.comm.plugin.s.b(exc, i4));
            e.a(this.f44599a, this.f44600b, i4, this.f44601c.get(), this.f44602d);
            f2.a("#loadADRes#", exc, new Object[0]);
        }
    }
}
