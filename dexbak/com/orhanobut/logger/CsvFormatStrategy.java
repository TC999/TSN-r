package com.orhanobut.logger;

import android.os.Environment;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.orhanobut.logger.DiskLogStrategy;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.orhanobut.logger.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CsvFormatStrategy implements FormatStrategy {

    /* renamed from: e */
    private static final String f32669e = System.getProperty("line.separator");

    /* renamed from: f */
    private static final String f32670f = " <br> ";

    /* renamed from: g */
    private static final String f32671g = ",";
    @NonNull

    /* renamed from: a */
    private final Date f32672a;
    @NonNull

    /* renamed from: b */
    private final SimpleDateFormat f32673b;
    @NonNull

    /* renamed from: c */
    private final LogStrategy f32674c;
    @Nullable

    /* renamed from: d */
    private final String f32675d;

    /* compiled from: CsvFormatStrategy.java */
    /* renamed from: com.orhanobut.logger.c$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C11790b {

        /* renamed from: e */
        private static final int f32676e = 512000;

        /* renamed from: a */
        Date f32677a;

        /* renamed from: b */
        SimpleDateFormat f32678b;

        /* renamed from: c */
        LogStrategy f32679c;

        /* renamed from: d */
        String f32680d;

        @NonNull
        /* renamed from: a */
        public CsvFormatStrategy m20482a() {
            if (this.f32677a == null) {
                this.f32677a = new Date();
            }
            if (this.f32678b == null) {
                this.f32678b = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.f32679c == null) {
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + C2634bs.f8731a;
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.f32679c = new DiskLogStrategy(new DiskLogStrategy.HandlerC11791a(handlerThread.getLooper(), str, 512000));
            }
            return new CsvFormatStrategy(this);
        }

        @NonNull
        /* renamed from: b */
        public C11790b m20481b(@Nullable Date date) {
            this.f32677a = date;
            return this;
        }

        @NonNull
        /* renamed from: c */
        public C11790b m20480c(@Nullable SimpleDateFormat simpleDateFormat) {
            this.f32678b = simpleDateFormat;
            return this;
        }

        @NonNull
        /* renamed from: d */
        public C11790b m20479d(@Nullable LogStrategy logStrategy) {
            this.f32679c = logStrategy;
            return this;
        }

        @NonNull
        /* renamed from: e */
        public C11790b m20478e(@Nullable String str) {
            this.f32680d = str;
            return this;
        }

        private C11790b() {
            this.f32680d = "PRETTY_LOGGER";
        }
    }

    @Nullable
    /* renamed from: b */
    private String m20484b(@Nullable String str) {
        if (!C11795n.m20420d(str) && !C11795n.m20422b(this.f32675d, str)) {
            return this.f32675d + "-" + str;
        }
        return this.f32675d;
    }

    @NonNull
    /* renamed from: c */
    public static C11790b m20483c() {
        return new C11790b();
    }

    @Override // com.orhanobut.logger.FormatStrategy
    /* renamed from: a */
    public void mo20454a(int i, @Nullable String str, @NonNull String str2) {
        C11795n.m20423a(str2);
        String m20484b = m20484b(str);
        this.f32672a.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.f32672a.getTime()));
        sb.append(f32671g);
        sb.append(this.f32673b.format(this.f32672a));
        sb.append(f32671g);
        sb.append(C11795n.m20419e(i));
        sb.append(f32671g);
        sb.append(m20484b);
        String str3 = f32669e;
        if (str2.contains(str3)) {
            str2 = str2.replaceAll(str3, f32670f);
        }
        sb.append(f32671g);
        sb.append(str2);
        sb.append(str3);
        this.f32674c.mo20473a(i, m20484b, sb.toString());
    }

    private CsvFormatStrategy(@NonNull C11790b c11790b) {
        C11795n.m20423a(c11790b);
        this.f32672a = c11790b.f32677a;
        this.f32673b = c11790b.f32678b;
        this.f32674c = c11790b.f32679c;
        this.f32675d = c11790b.f32680d;
    }
}
