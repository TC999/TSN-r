package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import com.kwad.sdk.api.C9702c;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.api.loader.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9718d implements Thread.UncaughtExceptionHandler {
    private static C9718d amc;
    private Thread.UncaughtExceptionHandler amd;
    private int ame;
    private long amg;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean amf = new AtomicBoolean();

    private C9718d(Context context) {
        this.mContext = context;
    }

    /* renamed from: ay */
    public static C9718d m27947ay(Context context) {
        if (amc == null) {
            synchronized (C9718d.class) {
                if (amc == null) {
                    amc = new C9718d(context);
                }
            }
        }
        return amc;
    }

    /* renamed from: bW */
    public final void m27946bW(int i) {
        this.amg = System.currentTimeMillis();
        this.ame = i;
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
                Boolean bool = (Boolean) C9702c.m28017f("filterStack", th);
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && booleanValue) {
                    C9757t.m27845a(context, C9723g.amm, true);
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
