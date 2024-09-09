package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    @WorkerThread
    public static void a(Context context, AppStatusRules appStatusRules) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        long obtainUploadConfigFileMaxSize = appStatusRules.obtainUploadConfigFileMaxSize();
        List<com.kwad.sdk.collector.model.d> uploadTargets = appStatusRules.getUploadTargets();
        if (uploadTargets == null) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
        List<com.kwad.sdk.collector.model.e> a4 = b.Av().a(uploadTargets, obtainUploadConfigFileMaxSize, file.getAbsolutePath() + TTPathConst.sSeparator);
        List<UploadEntryNative> aM = aM(context);
        if (aM != null) {
            a4.addAll(aM);
            HashSet hashSet = new HashSet(a4);
            a4.clear();
            a4.addAll(hashSet);
        }
        b(context, a4);
    }

    private static List<UploadEntryNative> aM(Context context) {
        File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
        if (file.exists()) {
            try {
                return t.gx(com.kwad.sdk.crash.utils.h.I(file));
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }

    public static void aN(Context context) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, "LOCAL_TEMP_UPLOAD_FAILURE_JSON");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 19)
    private static void b(final Context context, final List<com.kwad.sdk.collector.model.e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        new l<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: AA */
            public com.kwad.sdk.collector.a.b createRequest() {
                return new com.kwad.sdk.collector.a.b(list);
            }

            @NonNull
            private static CollectResponse ct(String str) {
                CollectResponse collectResponse = new CollectResponse();
                collectResponse.parseJson(new JSONObject(str));
                return collectResponse;
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ CollectResponse parseData(String str) {
                return ct(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.b, CollectResponse>() { // from class: com.kwad.sdk.collector.j.2
            private synchronized void AB() {
                j.aN(context);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.b bVar) {
                super.onStartRequest(bVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.sdk.collector.a.b bVar, @NonNull CollectResponse collectResponse) {
                super.onSuccess(bVar, collectResponse);
                AB();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.a.b bVar, int i4, String str) {
                super.onError(bVar, i4, str);
            }
        });
    }
}
