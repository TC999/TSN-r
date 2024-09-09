package com.jmolsmobile.landscapevideocapture.camera;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class PrepareCameraException extends Exception {
    private static final String LOG_PREFIX = "Unable to unlock camera - ";
    private static final String MESSAGE = "Unable to use camera for recording";
    private static final long serialVersionUID = 6305923762266448674L;

    @Override // java.lang.Throwable
    public String getMessage() {
        com.jmolsmobile.landscapevideocapture.b.b("VideoCapture_Exception", "Unable to unlock camera - Unable to use camera for recording");
        return "Unable to use camera for recording";
    }
}
