package com.jmolsmobile.landscapevideocapture.camera;

import com.jmolsmobile.landscapevideocapture.CLog;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class PrepareCameraException extends Exception {
    private static final String LOG_PREFIX = "Unable to unlock camera - ";
    private static final String MESSAGE = "Unable to use camera for recording";
    private static final long serialVersionUID = 6305923762266448674L;

    @Override // java.lang.Throwable
    public String getMessage() {
        CLog.m34553b(CLog.f24343a, "Unable to unlock camera - Unable to use camera for recording");
        return MESSAGE;
    }
}
