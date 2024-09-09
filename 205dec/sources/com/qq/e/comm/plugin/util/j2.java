package com.qq.e.comm.plugin.util;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.security.PublicKey;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j2 {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f46497c = {82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};

    /* renamed from: a  reason: collision with root package name */
    private PublicKey f46498a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f46499b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final j2 f46500a = new j2();
    }

    public static j2 a() {
        return (j2) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, 1, new Object[0]);
    }

    private String a(String str) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, 0, this, str);
    }

    private PublicKey b() throws Exception {
        return (PublicKey) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 0, this);
    }

    public boolean a(String str, File file) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 0, this, str, file);
    }

    public boolean a(String str, String str2) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 0, this, str, str2);
    }

    public boolean b(String str, String str2) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME, 0, this, str, str2);
    }

    private j2() {
        boolean z3;
        try {
            this.f46498a = b();
            z3 = true;
        } catch (Throwable unused) {
            z3 = false;
        }
        this.f46499b = z3;
    }
}
