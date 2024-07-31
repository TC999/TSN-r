package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.C9799e;
import com.kwad.sdk.collector.model.InterfaceC9811e;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class UploadEntryNative extends NativeObject implements InterfaceC9811e {
    public UploadEntryNative(long j) {
        this.mPtr = j;
    }

    /* renamed from: AE */
    private String m27720AE() {
        try {
            String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            return uploadEntryGetOriginFilePath.substring(uploadEntryGetOriginFilePath.indexOf(uploadEntryGetPackageName)).replaceFirst(uploadEntryGetPackageName, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m27719a(UploadEntryNative uploadEntryNative) {
        return AppStatusNative.uploadEntryGetPackageName(uploadEntryNative);
    }

    @Override // com.kwad.sdk.collector.model.InterfaceC9811e
    @Nullable
    @WorkerThread
    /* renamed from: AC */
    public final JSONObject mo27721AC() {
        try {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, AppStatusNative.uploadEntryGetPackageName(this));
            C11126t.putValue(jSONObject, "content", C9799e.m27755cs(AppStatusNative.uploadEntryGetOriginFilePath(this)));
            C11126t.putValue(jSONObject, TTDownloadField.TT_FILE_NAME, m27720AE());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteUploadEntry(j);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UploadEntryNative uploadEntryNative = (UploadEntryNative) obj;
            String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
            String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
            if (uploadEntryGetPackageName == null ? m27719a(uploadEntryNative) != null : !uploadEntryGetPackageName.equals(m27719a(uploadEntryNative))) {
                return false;
            }
            if (uploadEntryGetOriginFilePath != null) {
                return uploadEntryGetOriginFilePath.equals(AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative));
            }
            if (AppStatusNative.uploadEntryGetOriginFilePath(uploadEntryNative) == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String uploadEntryGetPackageName = AppStatusNative.uploadEntryGetPackageName(this);
        String uploadEntryGetOriginFilePath = AppStatusNative.uploadEntryGetOriginFilePath(this);
        return ((uploadEntryGetPackageName != null ? uploadEntryGetPackageName.hashCode() : 0) * 31) + (uploadEntryGetOriginFilePath != null ? uploadEntryGetOriginFilePath.hashCode() : 0);
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME);
        String optString2 = jSONObject.optString("originFilePath");
        AppStatusNative.uploadEntrySetPackageName(this, optString);
        AppStatusNative.uploadEntrySetOriginFilePath(this, optString2);
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, AppStatusNative.uploadEntryGetPackageName(this));
        C11126t.putValue(jSONObject, "originFilePath", AppStatusNative.uploadEntryGetOriginFilePath(this));
        return jSONObject;
    }

    public String toString() {
        return "UploadEntry{packageName='" + AppStatusNative.uploadEntryGetPackageName(this) + "', originFile=" + AppStatusNative.uploadEntryGetOriginFilePath(this) + '}';
    }

    public UploadEntryNative() {
        this.mPtr = AppStatusNative.nativeCreateUploadEntry();
    }
}
