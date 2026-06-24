package org.motopart.cloud.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Top-level envelope every endpoint returns: { "Response": { "Status": {...}, "Data": ... } }.
 * The original Flutter client only treats statusCode 20001 (with HTTP 201) as success.
 */
public class ApiBaseResponse<T> {

    public static final int SUCCESS_CODE = 20001;
    public static final int ERROR_CODE = 40001;

    @JsonProperty("Response")
    private CloudResponse<T> response;

    public ApiBaseResponse() {
    }

    public ApiBaseResponse(CloudResponse<T> response) {
        this.response = response;
    }

    public static <T> ApiBaseResponse<T> success(T data) {
        return new ApiBaseResponse<>(
                new CloudResponse<>(new CloudStatus(SUCCESS_CODE, "Success"), data));
    }

    public static <T> ApiBaseResponse<T> success(T data, String message) {
        return new ApiBaseResponse<>(
                new CloudResponse<>(new CloudStatus(SUCCESS_CODE, message), data));
    }

    public static <T> ApiBaseResponse<T> error(String message) {
        return new ApiBaseResponse<>(
                new CloudResponse<>(new CloudStatus(ERROR_CODE, message), null));
    }

    public CloudResponse<T> getResponse() {
        return response;
    }

    public void setResponse(CloudResponse<T> response) {
        this.response = response;
    }
}
