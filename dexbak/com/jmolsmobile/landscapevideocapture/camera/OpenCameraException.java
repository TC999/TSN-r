package com.jmolsmobile.landscapevideocapture.camera;

import com.jmolsmobile.landscapevideocapture.CLog;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class OpenCameraException extends Exception {
    private static final String LOG_PREFIX = "Unable to open camera - ";
    private static final long serialVersionUID = -7340415176385044242L;
    private final OpenType mType;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum OpenType {
        INUSE("Camera disabled or in use by other process"),
        NOCAMERA("Device does not have camera");
        
        private String mMessage;

        OpenType(String str) {
            this.mMessage = str;
        }

        public String getMessage() {
            return this.mMessage;
        }
    }

    public OpenCameraException(OpenType openType) {
        super(openType.getMessage());
        this.mType = openType;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        CLog.m34553b(CLog.f24343a, LOG_PREFIX + this.mType.getMessage());
        super.printStackTrace();
    }
}