package com.scoquix.deepIT.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class CustomErrorResponse {
    private int status;
    private String response;
    private long timeStamp;
}
