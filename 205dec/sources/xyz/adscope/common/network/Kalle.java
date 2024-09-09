package xyz.adscope.common.network;

import xyz.adscope.common.network.download.BodyDownload;
import xyz.adscope.common.network.download.DownloadManager;
import xyz.adscope.common.network.download.UrlDownload;
import xyz.adscope.common.network.simple.RequestManager;
import xyz.adscope.common.network.simple.SimpleBodyRequest;
import xyz.adscope.common.network.simple.SimpleUrlRequest;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class Kalle {

    /* renamed from: a  reason: collision with root package name */
    public static KalleConfig f64781a;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Download {
        public static void cancel(Object obj) {
            DownloadManager.getInstance().cancel(obj);
        }

        public static BodyDownload.Api delete(String str) {
            return BodyDownload.newApi(Url.newBuilder(str).build(), RequestMethod.DELETE);
        }

        public static BodyDownload.Api delete(Url url) {
            return BodyDownload.newApi(url, RequestMethod.DELETE);
        }

        public static UrlDownload.Api get(String str) {
            return UrlDownload.newApi(Url.newBuilder(str).build(), RequestMethod.GET);
        }

        public static UrlDownload.Api get(Url url) {
            return UrlDownload.newApi(url, RequestMethod.GET);
        }

        public static UrlDownload.Api head(String str) {
            return UrlDownload.newApi(Url.newBuilder(str).build(), RequestMethod.HEAD);
        }

        public static UrlDownload.Api head(Url url) {
            return UrlDownload.newApi(url, RequestMethod.HEAD);
        }

        public static UrlDownload.Api options(String str) {
            return UrlDownload.newApi(Url.newBuilder(str).build(), RequestMethod.OPTIONS);
        }

        public static UrlDownload.Api options(Url url) {
            return UrlDownload.newApi(url, RequestMethod.OPTIONS);
        }

        public static BodyDownload.Api patch(String str) {
            return BodyDownload.newApi(Url.newBuilder(str).build(), RequestMethod.PATCH);
        }

        public static BodyDownload.Api patch(Url url) {
            return BodyDownload.newApi(url, RequestMethod.PATCH);
        }

        public static BodyDownload.Api post(String str) {
            return BodyDownload.newApi(Url.newBuilder(str).build(), RequestMethod.POST);
        }

        public static BodyDownload.Api post(Url url) {
            return BodyDownload.newApi(url, RequestMethod.POST);
        }

        public static BodyDownload.Api put(String str) {
            return BodyDownload.newApi(Url.newBuilder(str).build(), RequestMethod.PUT);
        }

        public static BodyDownload.Api put(Url url) {
            return BodyDownload.newApi(url, RequestMethod.PUT);
        }

        public static UrlDownload.Api trace(String str) {
            return UrlDownload.newApi(Url.newBuilder(str).build(), RequestMethod.TRACE);
        }

        public static UrlDownload.Api trace(Url url) {
            return UrlDownload.newApi(url, RequestMethod.TRACE);
        }
    }

    public static void cancel(Object obj) {
        RequestManager.getInstance().cancel(obj);
    }

    public static SimpleBodyRequest.Api delete(String str) {
        return SimpleBodyRequest.newApi(Url.newBuilder(str).build(), RequestMethod.DELETE);
    }

    public static SimpleBodyRequest.Api delete(Url url) {
        return SimpleBodyRequest.newApi(url, RequestMethod.DELETE);
    }

    public static SimpleUrlRequest.Api get(String str) {
        return SimpleUrlRequest.newApi(Url.newBuilder(str).build(), RequestMethod.GET);
    }

    public static SimpleUrlRequest.Api get(Url url) {
        return SimpleUrlRequest.newApi(url, RequestMethod.GET);
    }

    public static KalleConfig getConfig() {
        return f64781a;
    }

    public static SimpleUrlRequest.Api head(String str) {
        return SimpleUrlRequest.newApi(Url.newBuilder(str).build(), RequestMethod.HEAD);
    }

    public static SimpleUrlRequest.Api head(Url url) {
        return SimpleUrlRequest.newApi(url, RequestMethod.HEAD);
    }

    public static SimpleUrlRequest.Api options(String str) {
        return SimpleUrlRequest.newApi(Url.newBuilder(str).build(), RequestMethod.OPTIONS);
    }

    public static SimpleUrlRequest.Api options(Url url) {
        return SimpleUrlRequest.newApi(url, RequestMethod.OPTIONS);
    }

    public static SimpleBodyRequest.Api patch(String str) {
        return SimpleBodyRequest.newApi(Url.newBuilder(str).build(), RequestMethod.PATCH);
    }

    public static SimpleBodyRequest.Api patch(Url url) {
        return SimpleBodyRequest.newApi(url, RequestMethod.PATCH);
    }

    public static SimpleBodyRequest.Api post(String str) {
        return SimpleBodyRequest.newApi(Url.newBuilder(str).build(), RequestMethod.POST);
    }

    public static SimpleBodyRequest.Api post(Url url) {
        return SimpleBodyRequest.newApi(url, RequestMethod.POST);
    }

    public static SimpleBodyRequest.Api put(String str) {
        return SimpleBodyRequest.newApi(Url.newBuilder(str).build(), RequestMethod.PUT);
    }

    public static SimpleBodyRequest.Api put(Url url) {
        return SimpleBodyRequest.newApi(url, RequestMethod.PUT);
    }

    public static void setConfig(KalleConfig kalleConfig) {
        if (f64781a == null) {
            synchronized (KalleConfig.class) {
                if (f64781a == null) {
                    if (kalleConfig == null) {
                        kalleConfig = KalleConfig.newBuilder().build();
                    }
                    f64781a = kalleConfig;
                } else {
                    LogUtil.d("Kalle", "Only allowed to configure once.");
                }
            }
        }
    }

    public static SimpleUrlRequest.Api trace(String str) {
        return SimpleUrlRequest.newApi(Url.newBuilder(str).build(), RequestMethod.TRACE);
    }

    public static SimpleUrlRequest.Api trace(Url url) {
        return SimpleUrlRequest.newApi(url, RequestMethod.TRACE);
    }
}
