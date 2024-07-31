package com.mbridge.msdk.foundation.same.p476c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p474a.LruMemoryCache;
import com.mbridge.msdk.foundation.same.p474a.MemoryCacheAware;
import com.mbridge.msdk.foundation.same.p476c.CommonImageTask;
import com.mbridge.msdk.foundation.same.p478e.CommonTaskLoader;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDKTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.same.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonImageLoader {

    /* renamed from: a */
    private static CommonImageLoader f30648a;

    /* renamed from: b */
    private CommonTaskLoader f30649b;

    /* renamed from: c */
    private MemoryCacheAware<String, Bitmap> f30650c;

    /* renamed from: d */
    private LinkedHashMap<String, List<CommonImageLoaderListener>> f30651d = new LinkedHashMap<>();

    /* renamed from: e */
    private Handler f30652e = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.foundation.same.c.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 1) {
                    String string = message.getData().getString("message_key");
                    Bitmap m22345a = CommonBitmapUtil.m22345a(message.getData().getString("message_bitmap"));
                    CommonImageLoader.this.m22340a(string, m22345a);
                    LinkedList linkedList = (LinkedList) CommonImageLoader.this.f30651d.get(string);
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            CommonImageLoaderListener commonImageLoaderListener = (CommonImageLoaderListener) it.next();
                            if (commonImageLoaderListener != null) {
                                commonImageLoaderListener.onSuccessLoad(m22345a, string);
                            }
                        }
                    }
                    CommonImageLoader.this.f30651d.remove(string);
                } else if (i == 2) {
                    String string2 = message.getData().getString("message_key");
                    String string3 = message.getData().getString("message_message");
                    LinkedList linkedList2 = (LinkedList) CommonImageLoader.this.f30651d.get(string2);
                    if (linkedList2 != null) {
                        Iterator it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            CommonImageLoaderListener commonImageLoaderListener2 = (CommonImageLoaderListener) it2.next();
                            if (commonImageLoaderListener2 != null) {
                                commonImageLoaderListener2.onFailedLoad(string3, string2);
                            }
                        }
                    }
                    CommonImageLoader.this.f30651d.remove(string2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    private CommonImageLoader(Context context) {
        this.f30649b = new CommonTaskLoader(context);
        Setting m23241g = SettingManager.m23261a().m23241g(MBSDKContext.m22865f().m22860k());
        int m23279w = m23241g != null ? m23241g.m23279w() : 10;
        this.f30650c = new LruMemoryCache(((int) Runtime.getRuntime().maxMemory()) / (m23279w > 0 ? m23279w : 10));
    }

    /* renamed from: d */
    private Bitmap m22331d(String str) {
        return this.f30650c.mo22377b(str);
    }

    /* renamed from: c */
    public final void m22333c() {
        MemoryCacheAware<String, Bitmap> memoryCacheAware = this.f30650c;
        if (memoryCacheAware != null) {
            memoryCacheAware.mo22378b();
        }
    }

    /* renamed from: b */
    public static void m22336b() {
        f30648a.m22333c();
    }

    /* renamed from: a */
    public final void m22340a(String str, Bitmap bitmap) {
        if (m22331d(str) != null || bitmap == null) {
            return;
        }
        this.f30650c.mo22379a(str, bitmap);
    }

    /* renamed from: b */
    public final boolean m22334b(String str) {
        if (SameTool.m22012a(str)) {
            return false;
        }
        return m22331d(str) != null || new File(SameSDKTool.m22030a(str)).exists();
    }

    /* renamed from: c */
    public final void m22332c(String str) {
        try {
            MemoryCacheAware<String, Bitmap> memoryCacheAware = this.f30650c;
            if (memoryCacheAware == null || !memoryCacheAware.mo22381a().contains(str)) {
                return;
            }
            this.f30650c.mo22380a(str);
        } catch (Throwable th) {
            SameLogTool.m21733d(ImageLoader.TAG, th.getMessage());
        }
    }

    /* renamed from: a */
    public static CommonImageLoader m22343a(Context context) {
        if (f30648a == null) {
            f30648a = new CommonImageLoader(context);
        }
        return f30648a;
    }

    /* renamed from: a */
    public final void m22344a() {
        this.f30650c.mo22378b();
        LinkedHashMap<String, List<CommonImageLoaderListener>> linkedHashMap = this.f30651d;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    /* renamed from: a */
    public final void m22339a(String str, CommonImageLoaderListener commonImageLoaderListener) {
        String m22030a = SameSDKTool.m22030a(str);
        if (SameTool.m22012a(str) || SameTool.m22012a(str) || SameTool.m22012a(m22030a)) {
            return;
        }
        File file = new File(m22030a);
        Bitmap m22331d = m22331d(str);
        if (m22331d != null && !m22331d.isRecycled()) {
            commonImageLoaderListener.onSuccessLoad(m22331d, str);
        } else if (file.exists()) {
            Bitmap m22345a = CommonBitmapUtil.m22345a(m22030a);
            if (m22345a != null && !m22345a.isRecycled()) {
                SameLogTool.m21738a(ImageLoader.TAG, "url image [" + str + "] is downloaded, save by file [" + m22030a + "]");
                m22340a(str, m22345a);
                commonImageLoaderListener.onSuccessLoad(m22345a, str);
                return;
            }
            m22337a(str, str, m22030a, true, false, commonImageLoaderListener);
        } else {
            m22337a(str, str, m22030a, false, false, commonImageLoaderListener);
        }
    }

    /* renamed from: a */
    public final Bitmap m22341a(String str) {
        Bitmap m22345a;
        if (SameTool.m22012a(str)) {
            return null;
        }
        String m22030a = SameSDKTool.m22030a(str);
        File file = new File(m22030a);
        if (m22331d(str) != null) {
            return m22331d(str);
        }
        if (!file.exists() || (m22345a = CommonBitmapUtil.m22345a(m22030a)) == null) {
            return null;
        }
        m22340a(str, m22345a);
        return m22345a;
    }

    /* renamed from: a */
    private void m22337a(String str, String str2, String str3, boolean z, boolean z2, CommonImageLoaderListener commonImageLoaderListener) {
        if (!this.f30651d.containsKey(str2)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(commonImageLoaderListener);
            this.f30651d.put(str2, linkedList);
            this.f30649b.m22313b(m22338a(str, str2, str3, z, z2));
            return;
        }
        LinkedList linkedList2 = (LinkedList) this.f30651d.get(str2);
        if (linkedList2 != null && !linkedList2.contains(commonImageLoaderListener)) {
            linkedList2.add(commonImageLoaderListener);
        }
        SameLogTool.m21738a(ImageLoader.TAG, "loading:" + str2);
    }

    /* renamed from: a */
    private CommonImageTask m22338a(String str, String str2, String str3, boolean z, boolean z2) {
        CommonImageTask.InterfaceC11323a interfaceC11323a = new CommonImageTask.InterfaceC11323a() { // from class: com.mbridge.msdk.foundation.same.c.b.2
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageTask.InterfaceC11323a
            /* renamed from: a */
            public final void mo22322a(String str4, String str5) {
                Message obtainMessage = CommonImageLoader.this.f30652e.obtainMessage();
                obtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str4);
                bundle.putString("message_bitmap", str5);
                obtainMessage.setData(bundle);
                CommonImageLoader.this.f30652e.sendMessage(obtainMessage);
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageTask.InterfaceC11323a
            /* renamed from: b */
            public final void mo22321b(String str4, String str5) {
                Message obtainMessage = CommonImageLoader.this.f30652e.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str4);
                bundle.putString("message_message", str5);
                obtainMessage.setData(bundle);
                CommonImageLoader.this.f30652e.sendMessage(obtainMessage);
            }
        };
        CommonImageTask commonImageTask = new CommonImageTask(str, str2, str3);
        commonImageTask.m22325a(z);
        commonImageTask.m22329a(interfaceC11323a);
        return commonImageTask;
    }
}
