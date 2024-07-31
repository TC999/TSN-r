package kotlin.p613io;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* compiled from: Exceptions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u0006"}, m12616d2 = {"Ljava/io/File;", IDataSource.f43973c, AdnName.OTHER, "", MediationConstant.KEY_REASON, "b", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14310e {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static final String m8467b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "sb.toString()");
        return sb2;
    }
}
