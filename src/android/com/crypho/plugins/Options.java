package com.crypho.plugins;


import org.json.JSONObject;

import java.util.Objects;

class Options {
    private static final Integer DEFAULT_AUTHENTICATION_VALIDITY_TIME = 60 * 60 * 24; // Fallback to 24h. Workaround to avoid asking for credentials too "often"

    final boolean allowInsecureHardware;
    final String packageName;
    final int userAuthenticationValidityDuration;
    final String unlockCredentialsTitle;
    final String unlockCredentialsDescription;

    private Options(boolean allowInsecureHardware, String packageName, int userAuthenticationValidityDuration, String unlockCredentialsTitle, String unlockCredentialsDescription) {
        this.allowInsecureHardware = allowInsecureHardware;
        this.packageName = packageName;
        this.userAuthenticationValidityDuration = userAuthenticationValidityDuration;
        this.unlockCredentialsTitle = unlockCredentialsTitle;
        this.unlockCredentialsDescription = unlockCredentialsDescription;
    }

    static Options fromJson(JSONObject json, String defaultPackagename) {
        Objects.requireNonNull(json, "json cannot be null");
        return new Options(
                json.optBoolean("allowInsecureHardware", false),
                json.optString("packageName", defaultPackagename),
                json.optInt("userAuthenticationValidityDuration", DEFAULT_AUTHENTICATION_VALIDITY_TIME),
                json.optString("unlockCredentialsTitle", null),
                json.optString("unlockCredentialsDescription", null));
    }
}
