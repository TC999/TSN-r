package com.kwad.sdk.crash;

import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static final double aFD = Runtime.getRuntime().maxMemory();
    public static final Pattern aFE = Pattern.compile("/data/user");
    public static final Pattern aFF = Pattern.compile("/data");
    public static final Pattern aFG = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aFH = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aFI = 20;
    public static String aFJ = "sessionId";
}
