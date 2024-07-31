package io.netty.util.concurrent;

import java.lang.Thread;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ThreadProperties {
    /* renamed from: id */
    long mo12680id();

    boolean isAlive();

    boolean isDaemon();

    boolean isInterrupted();

    String name();

    int priority();

    StackTraceElement[] stackTrace();

    Thread.State state();
}
