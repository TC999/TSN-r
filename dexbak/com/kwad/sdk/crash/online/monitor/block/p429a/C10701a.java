package com.kwad.sdk.crash.online.monitor.block.p429a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.C10451c;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10701a extends C10451c {
    private static String ayT = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public C10701a(@Nullable Context context, int i) {
        super(context, "ksadBlock.db", i, ayT);
    }
}
