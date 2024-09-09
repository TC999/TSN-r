package com.kwad.sdk.api.loader;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d implements Thread.UncaughtExceptionHandler {
    private static d amc;
    private Thread.UncaughtExceptionHandler amd;
    private int ame;
    private long amg;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean amf = new AtomicBoolean();

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class a extends Application {
        private final Context anu;

        a(Context context) {
            this.anu = context;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final Context getApplicationContext() {
            return this.anu;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public final ApplicationInfo getApplicationInfo() {
            return this.anu.getApplicationInfo();
        }
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d ay(Context context) {
        if (amc == null) {
            synchronized (d.class) {
                if (amc == null) {
                    amc = new d(context);
                }
            }
        }
        return amc;
    }

    public final void bW(int i4) {
        this.amg = System.currentTimeMillis();
        this.ame = i4;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.amf.set(true);
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.amd = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.amg + ",mMaxDuration:" + this.ame + ",mIsCancel:" + this.amf.get());
            }
            if (!this.amf.get() && this.amg > 0 && System.currentTimeMillis() - this.amg <= this.ame) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.f("filterStack", th);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && booleanValue) {
                    t.a(context, g.amm, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.amd;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.amd;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            } catch (Throwable th3) {
                if (this.amd != null) {
                    this.amd.uncaughtException(thread, th);
                }
                throw th3;
            }
        }
    }
}
