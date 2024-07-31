package com.devlin_n.videoplayer.player;

import android.content.Context;
import com.danikula.videocache.C6556i;
import com.danikula.videocache.file.C6552f;
import com.stub.StubApp;
import java.io.File;
import p601i0.StorageUtil;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.devlin_n.videoplayer.player.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoCacheManager {

    /* renamed from: a */
    private static C6556i f23379a;

    private VideoCacheManager() {
    }

    /* renamed from: a */
    public static boolean m35679a(Context context) {
        return StorageUtil.m12714b(StorageUtil.m12711e(context));
    }

    /* renamed from: b */
    public static boolean m35678b(Context context, String str) {
        String generate = new C6552f().generate(str);
        StringBuilder sb = new StringBuilder();
        sb.append(StorageUtil.m12711e(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(generate);
        sb.append(".download");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(StorageUtil.m12711e(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath());
        sb3.append(str2);
        sb3.append(generate);
        return StorageUtil.m12715a(sb2) && StorageUtil.m12715a(sb3.toString());
    }

    /* renamed from: c */
    public static C6556i m35677c(Context context) {
        C6556i c6556i = f23379a;
        if (c6556i == null) {
            C6556i m35676d = m35676d(context);
            f23379a = m35676d;
            return m35676d;
        }
        return c6556i;
    }

    /* renamed from: d */
    private static C6556i m35676d(Context context) {
        return new C6556i.C6558b(context).m35884h(IjkMediaMeta.AV_CH_STEREO_RIGHT).m35890b();
    }
}
