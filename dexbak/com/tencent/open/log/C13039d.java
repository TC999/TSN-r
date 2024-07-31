package com.tencent.open.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13039d {

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C13040a {
        /* renamed from: a */
        public static final boolean m15083a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C13041b {
        /* renamed from: a */
        public static boolean m15082a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        /* renamed from: b */
        public static C13042c m15081b() {
            if (m15082a()) {
                return C13042c.m15075b(Environment.getExternalStorageDirectory());
            }
            return null;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13042c {

        /* renamed from: a */
        private File f37393a;

        /* renamed from: b */
        private long f37394b;

        /* renamed from: c */
        private long f37395c;

        /* renamed from: a */
        public File m15080a() {
            return this.f37393a;
        }

        /* renamed from: b */
        public long m15077b() {
            return this.f37394b;
        }

        /* renamed from: c */
        public long m15074c() {
            return this.f37395c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", m15080a().getAbsolutePath(), Long.valueOf(m15074c()), Long.valueOf(m15077b()));
        }

        /* renamed from: a */
        public void m15078a(File file) {
            this.f37393a = file;
        }

        /* renamed from: b */
        public void m15076b(long j) {
            this.f37395c = j;
        }

        /* renamed from: b */
        public static C13042c m15075b(File file) {
            StatFs statFs;
            C13042c c13042c = new C13042c();
            c13042c.m15078a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            c13042c.m15079a(statFs.getBlockCount() * blockSize);
            c13042c.m15076b(statFs.getAvailableBlocks() * blockSize);
            return c13042c;
        }

        /* renamed from: a */
        public void m15079a(long j) {
            this.f37394b = j;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.log.d$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C13043d {
        @SuppressLint({"SimpleDateFormat"})
        /* renamed from: a */
        public static SimpleDateFormat m15073a(String str) {
            return new SimpleDateFormat(str);
        }
    }

    /* renamed from: a */
    public static boolean m15085a(String str) {
        return str.contains("access_token") || str.contains("pay_token") || str.contains("pfkey") || str.contains("expires_in") || str.contains("openid") || str.contains("proxy_code") || str.contains("proxy_expires_in");
    }

    /* renamed from: b */
    public static Bundle m15084b(Bundle bundle) {
        if (m15086a(bundle)) {
            Bundle bundle2 = new Bundle(bundle);
            bundle2.remove("access_token");
            bundle2.remove("pay_token");
            bundle2.remove("pfkey");
            bundle2.remove("expires_in");
            bundle2.remove("openid");
            bundle2.remove("proxy_code");
            bundle2.remove("proxy_expires_in");
            return bundle2;
        }
        return bundle;
    }

    /* renamed from: a */
    public static boolean m15086a(Bundle bundle) {
        return bundle.containsKey("access_token") || bundle.containsKey("pay_token") || bundle.containsKey("pfkey") || bundle.containsKey("expires_in") || bundle.containsKey("openid") || bundle.containsKey("proxy_code") || bundle.containsKey("proxy_expires_in");
    }
}
