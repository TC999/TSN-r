package com.kwad.sdk.crash.online.monitor.block.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends c {
    private static String ayT = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(@Nullable Context context, int i4) {
        super(context, "ksadBlock.db", i4, ayT);
    }
}
