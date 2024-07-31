package com.jmolsmobile.landscapevideocapture;

import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.jmolsmobile.landscapevideocapture.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoFile {

    /* renamed from: c */
    private static final String f24350c = "/";

    /* renamed from: d */
    private static final String f24351d = "yyyyMMdd_HHmmss";

    /* renamed from: e */
    private static final String f24352e = "video_";

    /* renamed from: f */
    private static final String f24353f = ".mp4";

    /* renamed from: a */
    private final String f24354a;

    /* renamed from: b */
    private Date f24355b;

    public VideoFile(String str) {
        this.f24354a = str;
    }

    /* renamed from: a */
    private String m34551a() {
        if (m34547e()) {
            return this.f24354a;
        }
        String format = new SimpleDateFormat(f24351d, Locale.getDefault()).format(m34550b());
        return f24352e + format + f24353f;
    }

    /* renamed from: b */
    private Date m34550b() {
        if (this.f24355b == null) {
            this.f24355b = new Date();
        }
        return this.f24355b;
    }

    /* renamed from: e */
    private boolean m34547e() {
        String str = this.f24354a;
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* renamed from: c */
    public File m34549c() {
        String m34551a = m34551a();
        if (m34551a.contains(f24350c)) {
            return new File(m34551a);
        }
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        externalStoragePublicDirectory.mkdirs();
        return new File(externalStoragePublicDirectory, m34551a());
    }

    /* renamed from: d */
    public String m34548d() {
        return m34549c().getAbsolutePath();
    }

    public VideoFile(String str, Date date) {
        this(str);
        this.f24355b = date;
    }
}
