package com.kwad.components.offline.api.tk.model.report;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface TKDownloadReason {
    public static final String KSAD_TK_JS_MD5 = "jsMD5";
    public static final String KSAD_TK_MD5 = "md5";
    public static final String KSAD_TK_NET = "net";
    public static final String KSAD_TK_UNZIP = "unzip";
}
