package com.hp.hpl.sparta;

import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: ParseSource.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class c implements n {
    @Override // com.hp.hpl.sparta.n
    public void a(String str, String str2, int i4) {
        PrintStream printStream = System.out;
        printStream.println(str2 + "(" + i4 + "): " + str + " (NOTE)");
    }

    @Override // com.hp.hpl.sparta.n
    public void b(String str, String str2, int i4) {
        PrintStream printStream = System.err;
        printStream.println(str2 + "(" + i4 + "): " + str + " (ERROR)");
    }

    @Override // com.hp.hpl.sparta.n
    public void c(String str, String str2, int i4) {
        PrintStream printStream = System.out;
        printStream.println(str2 + "(" + i4 + "): " + str + " (WARNING)");
    }
}
