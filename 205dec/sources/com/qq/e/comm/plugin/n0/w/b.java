package com.qq.e.comm.plugin.n0.w;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.n0.v;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, com.qq.e.comm.plugin.apkmanager.x.f> f44820a = new ConcurrentHashMap();

    private static int a(int i4) {
        if (i4 == 4 || i4 == 6) {
            return 302;
        }
        if (i4 != 14) {
            if (i4 != 11) {
                if (i4 != 12) {
                    return 999;
                }
                return MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END;
            }
            return 301;
        }
        return MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES;
    }

    public static com.qq.e.comm.plugin.apkmanager.x.f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.qq.e.comm.plugin.apkmanager.x.f();
        }
        com.qq.e.comm.plugin.apkmanager.x.f fVar = f44820a.get(str);
        if (fVar == null) {
            com.qq.e.comm.plugin.apkmanager.x.f fVar2 = new com.qq.e.comm.plugin.apkmanager.x.f();
            f44820a.put(str, fVar2);
            return fVar2;
        }
        return fVar;
    }

    public static void b(int i4, ApkDownloadTask apkDownloadTask, int i5, int i6) {
        a(i4, apkDownloadTask, i5, i6, null);
    }

    public static void b(int i4, ApkDownloadTask apkDownloadTask) {
        if (i4 == 0) {
            a(4001009, apkDownloadTask, 0, 0);
        } else if (i4 == 13 || i4 == 7 || i4 == 9) {
        } else {
            a(4001006, apkDownloadTask, 3, a(i4));
        }
    }

    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(i4, cVar);
    }

    public static void a(int i4, int i5, com.qq.e.comm.plugin.n0.c cVar) {
        a aVar = new a(cVar);
        aVar.f(i5);
        v.a(i4, aVar, Integer.valueOf(i5), null);
    }

    public static void a(int i4, int i5, int i6, com.qq.e.comm.plugin.n0.c cVar) {
        a aVar = new a(cVar);
        aVar.f(i5);
        aVar.e(i6);
        v.a(i4, aVar, Integer.valueOf(i5), Integer.valueOf(i6), null);
    }

    public static void a(int i4, ApkDownloadTask apkDownloadTask) {
        a(i4, apkDownloadTask, 0);
    }

    public static void a(int i4, ApkDownloadTask apkDownloadTask, int i5) {
        b(i4, apkDownloadTask, i5, 0);
    }

    public static void a(int i4, ApkDownloadTask apkDownloadTask, int i5, int i6, com.qq.e.comm.plugin.n0.d dVar) {
        a a4 = a(apkDownloadTask);
        if (i5 > 0) {
            a4.c(i5);
        }
        if (i6 > 0) {
            a4.d(i6);
        }
        v.a(i4, a4, Integer.valueOf(i5), Integer.valueOf(i6), dVar);
    }

    public static void a(int i4, ApkDownloadTask apkDownloadTask, int i5, int i6) {
        String r3 = apkDownloadTask.r();
        a a4 = a(apkDownloadTask);
        com.qq.e.comm.plugin.apkmanager.x.f a5 = a(r3);
        if (i4 == 4001011 && a5.f44823c > 0) {
            a4.a(System.currentTimeMillis() - a5.f44823c);
        }
        if (i5 > 0) {
            a4.c(i5);
        }
        if (i6 > 0) {
            a4.d(i6);
        }
        v.a(i4, a4, Integer.valueOf(i5), Integer.valueOf(i6), null);
    }

    public static void a(int i4, ApkDownloadTask apkDownloadTask, long j4) {
        d dVar = new d(com.qq.e.comm.plugin.n0.c.a(apkDownloadTask.v()));
        dVar.b(true);
        if (j4 > 0) {
            dVar.a(System.currentTimeMillis() - j4);
        }
        v.a(i4, dVar);
    }

    private static a a(ApkDownloadTask apkDownloadTask) {
        a aVar = new a(com.qq.e.comm.plugin.n0.c.a(apkDownloadTask.v()));
        com.qq.e.comm.plugin.apkmanager.x.f a4 = a(apkDownloadTask.r());
        aVar.b(a4.f44821a);
        aVar.f(a4.f44822b);
        return aVar;
    }
}
