package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface ILoggerReporter {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(c cVar);
}
