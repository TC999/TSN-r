package com.p200hp.hpl.sparta;

import java.io.PrintStream;

/* renamed from: com.hp.hpl.sparta.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
class ParseSource implements ParseLog {
    @Override // com.p200hp.hpl.sparta.ParseLog
    /* renamed from: a */
    public void mo35147a(String str, String str2, int i) {
        PrintStream printStream = System.out;
        printStream.println(str2 + "(" + i + "): " + str + " (NOTE)");
    }

    @Override // com.p200hp.hpl.sparta.ParseLog
    /* renamed from: b */
    public void mo35146b(String str, String str2, int i) {
        PrintStream printStream = System.err;
        printStream.println(str2 + "(" + i + "): " + str + " (ERROR)");
    }

    @Override // com.p200hp.hpl.sparta.ParseLog
    /* renamed from: c */
    public void mo35145c(String str, String str2, int i) {
        PrintStream printStream = System.out;
        printStream.println(str2 + "(" + i + "): " + str + " (WARNING)");
    }
}
