package xyz.adscope.amps.tool.request;

import android.content.Context;
import xyz.adscope.common.network.JsonConverter;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.KalleConfig;
import xyz.adscope.common.network.cookie.DBCookieStore;
import xyz.adscope.common.network.simple.cache.DiskCacheStore;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSNetWorkInit {
    public static void init(Context context) {
        Kalle.setConfig(KalleConfig.newBuilder().cookieStore(DBCookieStore.newBuilder(context).build()).cacheStore(DiskCacheStore.newBuilder("filePath").build()).converter(new JsonConverter(context)).build());
        Kalle.setConfig(KalleConfig.newBuilder().build());
    }
}
