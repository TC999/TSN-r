package com.tsn.chat.utils;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Global.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ChannelGroup f52403a = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    public static String f52404b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f52405c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f52406d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f52407e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f52408f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f52409g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f52410h = "";

    /* renamed from: i  reason: collision with root package name */
    public static ConcurrentHashMap<String, LinkedBlockingQueue<Object>> f52411i = new ConcurrentHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    public static Map<String, String> f52412j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public static int f52413k = 0;
}
