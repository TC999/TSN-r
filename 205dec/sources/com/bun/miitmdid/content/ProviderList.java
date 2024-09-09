package com.bun.miitmdid.content;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ProviderList {

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum DEVICE_PROVIDER {
        UNSUPPORT(-1, "unsupport"),
        HUA_WEI(0, "HUAWEI"),
        XIAOMI(1, "Xiaomi"),
        VIVO(2, "vivo"),
        OPPO(3, "oppo"),
        MOTO(4, "motorola"),
        LENOVO(5, "lenovo"),
        ASUS(6, "asus"),
        SAMSUNG(7, "samsung"),
        MEIZU(8, "meizu"),
        NUBIA(10, "nubia"),
        ZTE(11, "ZTE"),
        ONEPLUS(12, "OnePlus"),
        BLACKSHARK(13, "blackshark"),
        FREEMEOS(30, "freemeos"),
        SSUIOS(31, "ssui");
        
        private int index;
        private String name;

        DEVICE_PROVIDER(int i4, String str) {
            this.index = i4;
            this.name = str;
        }

        public static DEVICE_PROVIDER fromName(String str) {
            if (TextUtils.isEmpty(str)) {
                return UNSUPPORT;
            }
            DEVICE_PROVIDER[] values = values();
            for (int i4 = 0; i4 < 16; i4++) {
                DEVICE_PROVIDER device_provider = values[i4];
                if (device_provider.name.equalsIgnoreCase(str)) {
                    return device_provider;
                }
            }
            return UNSUPPORT;
        }
    }
}