package com.mbridge.msdk.foundation.same.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.foundation.same.c.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: CommonImageLoader.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f39443a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f39444b;

    /* renamed from: c  reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.a.c<String, Bitmap> f39445c;

    /* renamed from: d  reason: collision with root package name */
    private LinkedHashMap<String, List<c>> f39446d = new LinkedHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private Handler f39447e = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.foundation.same.c.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i4 = message.what;
                if (i4 == 1) {
                    String string = message.getData().getString("message_key");
                    Bitmap a4 = a.a(message.getData().getString("message_bitmap"));
                    b.this.a(string, a4);
                    LinkedList linkedList = (LinkedList) b.this.f39446d.get(string);
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar != null) {
                                cVar.onSuccessLoad(a4, string);
                            }
                        }
                    }
                    b.this.f39446d.remove(string);
                } else if (i4 == 2) {
                    String string2 = message.getData().getString("message_key");
                    String string3 = message.getData().getString("message_message");
                    LinkedList linkedList2 = (LinkedList) b.this.f39446d.get(string2);
                    if (linkedList2 != null) {
                        Iterator it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            c cVar2 = (c) it2.next();
                            if (cVar2 != null) {
                                cVar2.onFailedLoad(string3, string2);
                            }
                        }
                    }
                    b.this.f39446d.remove(string2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    private b(Context context) {
        this.f39444b = new com.mbridge.msdk.foundation.same.e.b(context);
        com.mbridge.msdk.c.a g4 = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
        int w3 = g4 != null ? g4.w() : 10;
        this.f39445c = new com.mbridge.msdk.foundation.same.a.a(((int) Runtime.getRuntime().maxMemory()) / (w3 > 0 ? w3 : 10));
    }

    private Bitmap d(String str) {
        return this.f39445c.b(str);
    }

    public final void c() {
        com.mbridge.msdk.foundation.same.a.c<String, Bitmap> cVar = this.f39445c;
        if (cVar != null) {
            cVar.b();
        }
    }

    public static void b() {
        f39443a.c();
    }

    public final void a(String str, Bitmap bitmap) {
        if (d(str) != null || bitmap == null) {
            return;
        }
        this.f39445c.a(str, bitmap);
    }

    public final boolean b(String str) {
        if (ac.a(str)) {
            return false;
        }
        return d(str) != null || new File(ab.a(str)).exists();
    }

    public final void c(String str) {
        try {
            com.mbridge.msdk.foundation.same.a.c<String, Bitmap> cVar = this.f39445c;
            if (cVar == null || !cVar.a().contains(str)) {
                return;
            }
            this.f39445c.a(str);
        } catch (Throwable th) {
            x.d("ImageLoader", th.getMessage());
        }
    }

    public static b a(Context context) {
        if (f39443a == null) {
            f39443a = new b(context);
        }
        return f39443a;
    }

    public final void a() {
        this.f39445c.b();
        LinkedHashMap<String, List<c>> linkedHashMap = this.f39446d;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    public final void a(String str, c cVar) {
        String a4 = ab.a(str);
        if (ac.a(str) || ac.a(str) || ac.a(a4)) {
            return;
        }
        File file = new File(a4);
        Bitmap d4 = d(str);
        if (d4 != null && !d4.isRecycled()) {
            cVar.onSuccessLoad(d4, str);
        } else if (file.exists()) {
            Bitmap a5 = a.a(a4);
            if (a5 != null && !a5.isRecycled()) {
                x.a("ImageLoader", "url image [" + str + "] is downloaded, save by file [" + a4 + "]");
                a(str, a5);
                cVar.onSuccessLoad(a5, str);
                return;
            }
            a(str, str, a4, true, false, cVar);
        } else {
            a(str, str, a4, false, false, cVar);
        }
    }

    public final Bitmap a(String str) {
        Bitmap a4;
        if (ac.a(str)) {
            return null;
        }
        String a5 = ab.a(str);
        File file = new File(a5);
        if (d(str) != null) {
            return d(str);
        }
        if (!file.exists() || (a4 = a.a(a5)) == null) {
            return null;
        }
        a(str, a4);
        return a4;
    }

    private void a(String str, String str2, String str3, boolean z3, boolean z4, c cVar) {
        if (!this.f39446d.containsKey(str2)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(cVar);
            this.f39446d.put(str2, linkedList);
            this.f39444b.b(a(str, str2, str3, z3, z4));
            return;
        }
        LinkedList linkedList2 = (LinkedList) this.f39446d.get(str2);
        if (linkedList2 != null && !linkedList2.contains(cVar)) {
            linkedList2.add(cVar);
        }
        x.a("ImageLoader", "loading:" + str2);
    }

    private d a(String str, String str2, String str3, boolean z3, boolean z4) {
        d.a aVar = new d.a() { // from class: com.mbridge.msdk.foundation.same.c.b.2
            @Override // com.mbridge.msdk.foundation.same.c.d.a
            public final void a(String str4, String str5) {
                Message obtainMessage = b.this.f39447e.obtainMessage();
                obtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str4);
                bundle.putString("message_bitmap", str5);
                obtainMessage.setData(bundle);
                b.this.f39447e.sendMessage(obtainMessage);
            }

            @Override // com.mbridge.msdk.foundation.same.c.d.a
            public final void b(String str4, String str5) {
                Message obtainMessage = b.this.f39447e.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str4);
                bundle.putString("message_message", str5);
                obtainMessage.setData(bundle);
                b.this.f39447e.sendMessage(obtainMessage);
            }
        };
        d dVar = new d(str, str2, str3);
        dVar.a(z3);
        dVar.a(aVar);
        return dVar;
    }
}
