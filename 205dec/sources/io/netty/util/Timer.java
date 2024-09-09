package io.netty.util;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface Timer {
    Timeout newTimeout(TimerTask timerTask, long j4, TimeUnit timeUnit);

    Set<Timeout> stop();
}
