package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.C9821c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(C9821c c9821c);
}
