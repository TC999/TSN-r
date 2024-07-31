package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9561s;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* renamed from: com.kwad.framework.filedownloader.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface InterfaceC9580x extends InterfaceC9561s.InterfaceC9562a {

    /* renamed from: com.kwad.framework.filedownloader.x$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9581a {
        /* renamed from: a */
        boolean mo28324a(MessageSnapshot messageSnapshot);

        /* renamed from: b */
        boolean mo28323b(MessageSnapshot messageSnapshot);

        /* renamed from: c */
        boolean mo28322c(MessageSnapshot messageSnapshot);

        /* renamed from: d */
        boolean mo28321d(MessageSnapshot messageSnapshot);

        /* renamed from: g */
        MessageSnapshot mo28320g(Throwable th);

        /* renamed from: ut */
        InterfaceC9576t mo28319ut();
    }

    /* renamed from: com.kwad.framework.filedownloader.x$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9582b {
        void start();
    }

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();

    /* renamed from: tV */
    byte mo28330tV();

    /* renamed from: tX */
    Throwable mo28329tX();

    /* renamed from: tZ */
    int mo28328tZ();

    /* renamed from: ub */
    boolean mo28327ub();

    /* renamed from: uu */
    void mo28326uu();

    /* renamed from: uv */
    long mo28325uv();
}
