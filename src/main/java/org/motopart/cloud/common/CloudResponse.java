package org.motopart.cloud.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Inner "Response" object: { "Status": {...}, "Data": ... }. */
public class CloudResponse<T> {

    @JsonProperty("Status")
    private CloudStatus status;

    @JsonProperty("Data")
    private T data;

    public CloudResponse() {
    }

    public CloudResponse(CloudStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public CloudStatus getStatus() {
        return status;
    }

    public void setStatus(CloudStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
