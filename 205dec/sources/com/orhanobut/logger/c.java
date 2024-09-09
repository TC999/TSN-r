package com.orhanobut.logger;

import android.os.Environment;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.orhanobut.logger.e;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CsvFormatStrategy.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c implements f {

    /* renamed from: e  reason: collision with root package name */
    private static final String f41356e = System.getProperty("line.separator");

    /* renamed from: f  reason: collision with root package name */
    private static final String f41357f = " <br> ";

    /* renamed from: g  reason: collision with root package name */
    private static final String f41358g = ",";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Date f41359a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final SimpleDateFormat f41360b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final h f41361c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f41362d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: CsvFormatStrategy.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        private static final int f41363e = 512000;

        /* renamed from: a  reason: collision with root package name */
        Date f41364a;

        /* renamed from: b  reason: collision with root package name */
        SimpleDateFormat f41365b;

        /* renamed from: c  reason: collision with root package name */
        h f41366c;

        /* renamed from: d  reason: collision with root package name */
        String f41367d;

        @NonNull
        public c a() {
            if (this.f41364a == null) {
                this.f41364a = new Date();
            }
            if (this.f41365b == null) {
                this.f41365b = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.f41366c == null) {
                String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "logger";
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.f41366c = new e(new e.a(handlerThread.getLooper(), str, 512000));
            }
            return new c(this);
        }

        @NonNull
        public b b(@Nullable Date date) {
            this.f41364a = date;
            return this;
        }

        @NonNull
        public b c(@Nullable SimpleDateFormat simpleDateFormat) {
            this.f41365b = simpleDateFormat;
            return this;
        }

        @NonNull
        public b d(@Nullable h hVar) {
            this.f41366c = hVar;
            return this;
        }

        @NonNull
        public b e(@Nullable String str) {
            this.f41367d = str;
            return this;
        }

        private b() {
            this.f41367d = "PRETTY_LOGGER";
        }
    }

    @Nullable
    private String b(@Nullable String str) {
        if (!n.d(str) && !n.b(this.f41362d, str)) {
            return this.f41362d + "-" + str;
        }
        return this.f41362d;
    }

    @NonNull
    public static b c() {
        return new b();
    }

    @Override // com.orhanobut.logger.f
    public void a(int i4, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        String b4 = b(str);
        this.f41359a.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.f41359a.getTime()));
        sb.append(",");
        sb.append(this.f41360b.format(this.f41359a));
        sb.append(",");
        sb.append(n.e(i4));
        sb.append(",");
        sb.append(b4);
        String str3 = f41356e;
        if (str2.contains(str3)) {
            str2 = str2.replaceAll(str3, " <br> ");
        }
        sb.append(",");
        sb.append(str2);
        sb.append(str3);
        this.f41361c.a(i4, b4, sb.toString());
    }

    private c(@NonNull b bVar) {
        n.a(bVar);
        this.f41359a = bVar.f41364a;
        this.f41360b = bVar.f41365b;
        this.f41361c = bVar.f41366c;
        this.f41362d = bVar.f41367d;
    }
}
