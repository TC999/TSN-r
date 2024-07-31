package com.kwad.sdk.core.imageloader.core.download;

import java.io.InputStream;
import java.util.Locale;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface ImageDownloader {

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum Scheme {
        HTTP(IDataSource.f43971a),
        HTTPS("https"),
        FILE(IDataSource.f43973c),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        
        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            Scheme[] values;
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        public final String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }

        public final String wrap(String str) {
            return this.uriPrefix + str;
        }
    }

    InputStream getStream(String str, Object obj);
}
