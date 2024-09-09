package com.bykv.vk.openvk.component.video.c.c.w;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, w> f24990c = new ConcurrentHashMap<>();

    public static synchronized void c(Context context, sr srVar, c.InterfaceC0336c interfaceC0336c) {
        synchronized (xv.class) {
            if (srVar == null) {
                com.bykv.vk.openvk.component.video.api.f.xv.w(" url\u3001dir and hash is must property   in VideoInfoModel");
                return;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                ConcurrentHashMap<String, w> concurrentHashMap = f24990c;
                w wVar = concurrentHashMap.get(srVar.ia());
                if (wVar == null) {
                    wVar = new w(context, srVar);
                    concurrentHashMap.put(srVar.ia(), wVar);
                    com.bykv.vk.openvk.component.video.api.f.xv.w("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(srVar.f()), srVar.ia());
                }
                wVar.c(interfaceC0336c);
            }
            com.bykv.vk.openvk.component.video.api.f.xv.w("VideoFileManager", "preloadVideo:  cache size = ", Integer.valueOf(srVar.f()), srVar.ia());
        }
    }

    public static synchronized void c(sr srVar) {
        synchronized (xv.class) {
            if (Build.VERSION.SDK_INT >= 23) {
                w remove = f24990c.remove(srVar.ia());
                if (remove != null) {
                    remove.c(true);
                }
                com.bykv.vk.openvk.component.video.api.f.xv.w("VideoFileManager", "removePreload:  cache size = ", Integer.valueOf(srVar.f()), srVar.ia());
            }
        }
    }
}
