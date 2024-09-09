package com.tencent.turingfd.sdk.ams.au;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.finally  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cfinally {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f52315a = new ThreadPoolExecutor(5, 15, 1, TimeUnit.MINUTES, new LinkedBlockingQueue());
}
