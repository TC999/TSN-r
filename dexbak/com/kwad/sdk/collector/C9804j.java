package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.InterfaceC9810d;
import com.kwad.sdk.collector.model.InterfaceC9811e;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.collector.p370a.C9784b;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.utils.C11126t;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.collector.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9804j {
    @WorkerThread
    /* renamed from: a */
    public static void m27744a(Context context, AppStatusRules appStatusRules) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<InterfaceC9810d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
        List<InterfaceC9811e> mo27775a = C9785b.m27780Av().mo27775a(uploadTargets, obtainUploadConfigFileMaxSize, file.getAbsolutePath() + "/");
        List<UploadEntryNative> m27743aM = m27743aM(context);
        if (m27743aM != null) {
            mo27775a.addAll(m27743aM);
            HashSet hashSet = new HashSet(mo27775a);
            mo27775a.clear();
            mo27775a.addAll(hashSet);
        }
        m27741b(context, mo27775a);
    }

    /* renamed from: aM */
    private static List<UploadEntryNative> m27743aM(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (file.exists()) {
            try {
                return C11126t.m23676gx(C10747h.m24957I(file));
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: aN */
    public static void m27742aN(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    /* renamed from: b */
    private static void m27741b(final Context context, final List<InterfaceC9811e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new AbstractC10436l<C9784b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: AA */
            public C9784b createRequest() {
                return new C9784b(list);
            }

            @NonNull
            /* renamed from: ct */
            private static CollectResponse m27739ct(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ CollectResponse parseData(String str) {
                return m27739ct(str);
            }
        }.request(new AbstractC10439o<C9784b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            /* renamed from: AB */
            private synchronized void m27738AB() {
                C9804j.m27742aN(context);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onStartRequest(@NonNull C9784b c9784b) {
                super.onStartRequest(c9784b);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onSuccess(@NonNull C9784b c9784b, @NonNull CollectResponse collectResponse) {
                super.onSuccess(c9784b, collectResponse);
                m27738AB();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C9784b c9784b, int i, String str) {
                super.onError(c9784b, i, str);
            }
        });
    }
}
