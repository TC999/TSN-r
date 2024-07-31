package com.tsn.chat.utils;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.tsn.chat.utils.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Global {

    /* renamed from: a */
    public static ChannelGroup f37505a = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /* renamed from: b */
    public static String f37506b = "";

    /* renamed from: c */
    public static String f37507c = "";

    /* renamed from: d */
    public static String f37508d = "";

    /* renamed from: e */
    public static String f37509e = "";

    /* renamed from: f */
    public static String f37510f = "";

    /* renamed from: g */
    public static String f37511g = "";

    /* renamed from: h */
    public static String f37512h = "";

    /* renamed from: i */
    public static ConcurrentHashMap<String, LinkedBlockingQueue<Object>> f37513i = new ConcurrentHashMap<>();

    /* renamed from: j */
    public static Map<String, String> f37514j = new HashMap();

    /* renamed from: k */
    public static int f37515k = 0;
}
