package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class bg implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f12471a = new AtomicInteger(1);

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
            }
            return null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.mobads.sdk.internal.bj, java.lang.Runnable] */
        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bg.a(new bj(this, iOAdEvent));
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "TaskScheduler #" + this.f12471a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bh(this));
        return thread;
    }
}
