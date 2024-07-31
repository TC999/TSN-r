package com.amap.api.col.p0463l;

import androidx.annotation.NonNull;
import com.amap.api.col.p0463l.FpsCollector;
import java.util.List;

/* renamed from: com.amap.api.col.3l.e9 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class OpenSdkCollectionManagerProxy {
    public OpenSdkCollectionManagerProxy(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull INetwork iNetwork) {
        HeaderConfig.m54621e();
        HeaderConfig.m54616j(str4);
        HeaderConfig.m54612n("74");
        HeaderConfig.m54614l("v74");
        HeaderConfig.m54622d(str);
        HeaderConfig.m54618h(str2);
        HeaderConfig.m54620f(str3);
        AmapContext.m54897b(iNetwork);
    }

    /* renamed from: a */
    public static CollectionData m55211a(FpsCollector.C1836a c1836a) {
        return FpsCollector.m54743a().m54742b(c1836a);
    }

    /* renamed from: e */
    public static void m55207e(List<AmapCell> list) {
        RssiManager.m55270c(list);
    }

    /* renamed from: f */
    public static boolean m55206f(byte[] bArr) {
        return CollectionUploader.m54633a(bArr);
    }

    /* renamed from: g */
    public static byte[] m55205g() {
        return UploadBufferBuilder.m55019d().m55018e();
    }

    /* renamed from: h */
    public static byte[] m55204h(byte[] bArr, byte[] bArr2, List<CollectionData> list) {
        return UploadBufferBuilder.m55019d().m55020c(bArr, bArr2, list);
    }

    /* renamed from: j */
    public static void m55202j() {
        AmapContext.m54898a();
    }

    /* renamed from: k */
    public static void m55201k(List<AmapWifi> list) {
        RssiManager.m55268e(list);
    }

    /* renamed from: b */
    public final OpenSdkCollectionManagerProxy m55210b(int i) {
        HeaderConfig.m54624b(i);
        return this;
    }

    /* renamed from: c */
    public final OpenSdkCollectionManagerProxy m55209c(long j) {
        HeaderConfig.m54623c(j);
        return this;
    }

    /* renamed from: d */
    public final OpenSdkCollectionManagerProxy m55208d(String str) {
        HeaderConfig.m54610p(str);
        return this;
    }

    /* renamed from: i */
    public final OpenSdkCollectionManagerProxy m55203i(String str) {
        HeaderConfig.m54608r(str);
        return this;
    }

    /* renamed from: l */
    public final OpenSdkCollectionManagerProxy m55200l(String str) {
        HeaderConfig.m54606t(str);
        return this;
    }

    /* renamed from: m */
    public final OpenSdkCollectionManagerProxy m55199m(String str) {
        HeaderConfig.m54604v(str);
        return this;
    }

    /* renamed from: n */
    public final OpenSdkCollectionManagerProxy m55198n(String str) {
        HeaderConfig.m54602x(str);
        return this;
    }

    /* renamed from: o */
    public final OpenSdkCollectionManagerProxy m55197o(String str) {
        HeaderConfig.m54600z(str);
        return this;
    }

    /* renamed from: p */
    public final OpenSdkCollectionManagerProxy m55196p(String str) {
        HeaderConfig.m54631B(str);
        return this;
    }

    /* renamed from: q */
    public final OpenSdkCollectionManagerProxy m55195q(String str) {
        HeaderConfig.m54629D(str);
        return this;
    }

    /* renamed from: r */
    public final OpenSdkCollectionManagerProxy m55194r(String str) {
        HeaderConfig.m54628E(str);
        return this;
    }

    /* renamed from: s */
    public final OpenSdkCollectionManagerProxy m55193s(String str) {
        HeaderConfig.m54627F(str);
        return this;
    }

    /* renamed from: t */
    public final OpenSdkCollectionManagerProxy m55192t(String str) {
        HeaderConfig.m54626G(str);
        return this;
    }
}
