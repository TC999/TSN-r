package com.p521ss.android.socialbase.downloader.impls;

import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12496h;
import com.p521ss.android.socialbase.downloader.network.EnumC12621j;

/* renamed from: com.ss.android.socialbase.downloader.impls.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12536a implements InterfaceC12496h {
    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12496h
    /* renamed from: ok */
    public int mo17586ok(int i, EnumC12621j enumC12621j) {
        if (enumC12621j.ordinal() <= EnumC12621j.MODERATE.ordinal()) {
            return 1;
        }
        return enumC12621j == EnumC12621j.GOOD ? i - 1 : i;
    }
}
