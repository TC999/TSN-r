package com.bxkj.base.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;

/* renamed from: com.bxkj.base.util.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MediaPlayerUtil {

    /* renamed from: b */
    private static volatile MediaPlayerUtil f14927b = null;

    /* renamed from: c */
    private static String f14928c = null;

    /* renamed from: d */
    private static String f14929d = "TAG.Util.MediaPlay";

    /* renamed from: a */
    private MediaPlayer f14930a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MediaPlayerUtil.java */
    /* renamed from: com.bxkj.base.util.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3909a implements MediaPlayer.OnPreparedListener {
        C3909a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            String str = MediaPlayerUtil.f14929d;
            Log.d(str, "onPrepared: 播放 " + mediaPlayer.getDuration());
            mediaPlayer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MediaPlayerUtil.java */
    /* renamed from: com.bxkj.base.util.p$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3910b implements MediaPlayer.OnCompletionListener {
        C3910b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            String unused = MediaPlayerUtil.f14928c = "";
            if (MediaPlayerUtil.this.f14930a != null) {
                MediaPlayerUtil.this.f14930a.release();
            }
            if (MediaPlayerUtil.this.f14930a != null) {
                MediaPlayerUtil.this.f14930a = null;
            }
        }
    }

    private MediaPlayerUtil() {
    }

    /* renamed from: e */
    public static MediaPlayerUtil m44062e() {
        if (f14927b == null) {
            synchronized (MediaPlayerUtil.class) {
                if (f14927b == null) {
                    f14927b = new MediaPlayerUtil();
                }
            }
        }
        return f14927b;
    }

    /* renamed from: f */
    public void m44061f(Context context, String str) {
        if (this.f14930a != null) {
            m44059h();
        } else {
            m44060g(context, str);
        }
    }

    /* renamed from: g */
    public void m44060g(Context context, String str) {
        if (TextUtils.equals(str, f14928c)) {
            Log.d(f14929d, "player: 重复的url");
            return;
        }
        m44059h();
        f14928c = str;
        if (this.f14930a == null) {
            this.f14930a = MediaPlayer.create(context, Uri.parse(str));
        }
        try {
            String str2 = f14929d;
            Log.d(str2, "player: 当前要播放的歌曲Url === " + str);
            this.f14930a.reset();
            this.f14930a.setDataSource(str);
            this.f14930a.prepareAsync();
            this.f14930a.setOnPreparedListener(new C3909a());
            this.f14930a.setOnCompletionListener(new C3910b());
        } catch (IOException e) {
            String str3 = f14929d;
            Log.d(str3, " 播放音乐异常" + e.getMessage());
        }
    }

    /* renamed from: h */
    public void m44059h() {
        f14928c = "";
        try {
            MediaPlayer mediaPlayer = this.f14930a;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.f14930a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            if (this.f14930a != null) {
                this.f14930a = null;
            }
        } catch (Exception e) {
            String str = f14929d;
            Log.e(str, "stopPlay: " + e.toString());
        }
    }
}
