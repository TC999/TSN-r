package com.bytedance.pangle.util;

import android.text.TextUtils;
import com.bytedance.pangle.util.p126a.C6234a;
import com.bytedance.pangle.util.p126a.C6235b;
import java.io.File;

/* renamed from: com.bytedance.pangle.util.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6247c {
    /* renamed from: a */
    public static String[] m36907a(File file) {
        String[] m36937a = C6235b.m36937a(file);
        return TextUtils.isEmpty(m36937a[0]) ? C6234a.m36938a(file) : m36937a;
    }
}
