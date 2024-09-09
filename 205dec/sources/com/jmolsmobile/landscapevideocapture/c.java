package com.jmolsmobile.landscapevideocapture;

import android.os.Environment;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: VideoFile.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f37898c = "/";

    /* renamed from: d  reason: collision with root package name */
    private static final String f37899d = "yyyyMMdd_HHmmss";

    /* renamed from: e  reason: collision with root package name */
    private static final String f37900e = "video_";

    /* renamed from: f  reason: collision with root package name */
    private static final String f37901f = ".mp4";

    /* renamed from: a  reason: collision with root package name */
    private final String f37902a;

    /* renamed from: b  reason: collision with root package name */
    private Date f37903b;

    public c(String str) {
        this.f37902a = str;
    }

    private String a() {
        if (e()) {
            return this.f37902a;
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(b());
        return "video_" + format + ".mp4";
    }

    private Date b() {
        if (this.f37903b == null) {
            this.f37903b = new Date();
        }
        return this.f37903b;
    }

    private boolean e() {
        String str = this.f37902a;
        return (str == null || str.isEmpty()) ? false : true;
    }

    public File c() {
        String a4 = a();
        if (a4.contains(TTPathConst.sSeparator)) {
            return new File(a4);
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        externalStoragePublicDirectory.mkdirs();
        return new File(externalStoragePublicDirectory, a());
    }

    public String d() {
        return c().getAbsolutePath();
    }

    public c(String str, Date date) {
        this(str);
        this.f37903b = date;
    }
}
