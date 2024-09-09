package com.bxkj.base.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MediaPlayerUtil.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class p {

    /* renamed from: b  reason: collision with root package name */
    private static volatile p f18411b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f18412c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f18413d = "TAG.Util.MediaPlay";

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f18414a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MediaPlayerUtil.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            String str = p.f18413d;
            Log.d(str, "onPrepared: \u64ad\u653e " + mediaPlayer.getDuration());
            mediaPlayer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MediaPlayerUtil.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            String unused = p.f18412c = "";
            if (p.this.f18414a != null) {
                p.this.f18414a.release();
            }
            if (p.this.f18414a != null) {
                p.this.f18414a = null;
            }
        }
    }

    private p() {
    }

    public static p e() {
        if (f18411b == null) {
            synchronized (p.class) {
                if (f18411b == null) {
                    f18411b = new p();
                }
            }
        }
        return f18411b;
    }

    public void f(Context context, String str) {
        if (this.f18414a != null) {
            h();
        } else {
            g(context, str);
        }
    }

    public void g(Context context, String str) {
        if (TextUtils.equals(str, f18412c)) {
            Log.d(f18413d, "player: \u91cd\u590d\u7684url");
            return;
        }
        h();
        f18412c = str;
        if (this.f18414a == null) {
            this.f18414a = MediaPlayer.create(context, Uri.parse(str));
        }
        try {
            String str2 = f18413d;
            Log.d(str2, "player: \u5f53\u524d\u8981\u64ad\u653e\u7684\u6b4c\u66f2Url === " + str);
            this.f18414a.reset();
            this.f18414a.setDataSource(str);
            this.f18414a.prepareAsync();
            this.f18414a.setOnPreparedListener(new a());
            this.f18414a.setOnCompletionListener(new b());
        } catch (IOException e4) {
            String str3 = f18413d;
            Log.d(str3, " \u64ad\u653e\u97f3\u4e50\u5f02\u5e38" + e4.getMessage());
        }
    }

    public void h() {
        f18412c = "";
        try {
            MediaPlayer mediaPlayer = this.f18414a;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.f18414a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            if (this.f18414a != null) {
                this.f18414a = null;
            }
        } catch (Exception e4) {
            String str = f18413d;
            Log.e(str, "stopPlay: " + e4.toString());
        }
    }
}
