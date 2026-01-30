package com.spring_boot_learning.spring_boot_learning.APIResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {

    private String status;
    private String message;
    private T data;

    // ✅ Success response
    public static <T> APIResponse<T> success(String message, T data) {
        return new APIResponse<>("success", message, data);
    }

    // ✅ Error response (no data)
    public static <T> APIResponse<T> error(String message) {
        return new APIResponse<>("error", message, null);
    }

    // ✅ Error response WITH details (recommended)
    public static <T> APIResponse<T> error(String message, T data) {
        return new APIResponse<>("error", message, data);
    }
}
