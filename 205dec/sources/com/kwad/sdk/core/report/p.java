package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class p extends c {
    public static int IP = 1;
    private static String ayT = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(@Nullable Context context, int i4) {
        super(context, "ksadrep.db", i4, ayT);
    }
}
