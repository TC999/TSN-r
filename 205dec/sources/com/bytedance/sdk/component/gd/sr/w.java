package com.bytedance.sdk.component.gd.sr;

import android.os.AsyncTask;
import com.bytedance.sdk.component.gd.k;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    /* renamed from: c  reason: collision with root package name */
    public static Executor f29861c = new sr(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new k("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> c(Params... paramsArr) {
        return executeOnExecutor(f29861c, paramsArr);
    }
}
