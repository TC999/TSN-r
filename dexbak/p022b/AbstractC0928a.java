package p022b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: b.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC0928a {

    /* renamed from: a */
    public static final ThreadPoolExecutor f233a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
}
