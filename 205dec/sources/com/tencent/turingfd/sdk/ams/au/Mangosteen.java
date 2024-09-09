package com.tencent.turingfd.sdk.ams.au;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Mangosteen {
    public static Draco a(Draco draco, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            byte[] a4 = Creturn.a(bArr, Creturn.a());
            if (a4 != null && a4.length != 0) {
                byte[] a5 = Cimport.a(a4);
                if (a5 != null && a5.length != 0) {
                    Apple apple = new Apple();
                    new HashMap();
                    HashMap hashMap = new HashMap();
                    apple.f51873c = (short) 3;
                    apple.f51876f = 3;
                    if (a5.length >= 4) {
                        try {
                            Cygnus cygnus = new Cygnus(a5, 4);
                            cygnus.f52008b = "UTF-8";
                            apple.a(cygnus);
                            cygnus.f52007a = ByteBuffer.wrap(apple.f51879i);
                            if (Mango.f52150a == null) {
                                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                                Mango.f52150a = hashMap2;
                                hashMap2.put("", new byte[0]);
                            }
                            HashMap a6 = cygnus.a((Map) Mango.f52150a, 0, false);
                            Object obj = null;
                            try {
                                if (a6.containsKey("resp")) {
                                    if (hashMap.containsKey("resp")) {
                                        obj = hashMap.get("resp");
                                    } else {
                                        byte[] bArr2 = (byte[]) a6.get("resp");
                                        try {
                                            Cygnus cygnus2 = new Cygnus();
                                            cygnus2.f52007a = ByteBuffer.wrap(bArr2);
                                            cygnus2.f52008b = "UTF-8";
                                            obj = cygnus2.a((Cygnus) draco, 0, true);
                                            if (obj != null) {
                                                hashMap.put("resp", obj);
                                            }
                                        } catch (Exception e4) {
                                            throw new Exception(e4);
                                        }
                                    }
                                }
                                return (Draco) obj;
                            } catch (Throwable th) {
                                Log.w("TuringDebug", th);
                                return draco;
                            }
                        } catch (Exception e5) {
                            throw new RuntimeException(e5);
                        }
                    }
                    throw new IllegalArgumentException("decode package must include size head");
                }
                Log.w("TuringDebug", "u3");
                return draco;
            }
            Log.w("TuringDebug", "u2");
            return draco;
        }
        Log.w("TuringDebug", "u1");
        return draco;
    }
}
