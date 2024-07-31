package com.clj.fastble.utils;

import com.clj.fastble.bluetooth.BleBluetooth;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleLruHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int MAX_SIZE;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BleLruHashMap(int r5) {
        /*
            r4 = this;
            double r0 = (double) r5
            r2 = 4604930618986332160(0x3fe8000000000000, double:0.75)
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r2
            double r0 = java.lang.Math.ceil(r0)
            int r0 = (int) r0
            r1 = 1
            int r0 = r0 + r1
            r2 = 1061158912(0x3f400000, float:0.75)
            r4.<init>(r0, r2, r1)
            r4.MAX_SIZE = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clj.fastble.utils.BleLruHashMap.<init>(int):void");
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry entry) {
        if (size() > this.MAX_SIZE && (entry.getValue() instanceof BleBluetooth)) {
            ((BleBluetooth) entry.getValue()).m36111G();
        }
        return size() > this.MAX_SIZE;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
