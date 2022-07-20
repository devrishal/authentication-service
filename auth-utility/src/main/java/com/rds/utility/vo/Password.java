package com.rds.utility.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Password {
    @NotEmpty
    @Schema(name = "emailOrUsername", description = "email id or username",required = true)
    private String emailOrUsername;
    @NotEmpty
    @Schema(name = "freshPassword", description = "Enter new Password",required = true)
    private String freshPassword;
    @NotEmpty
    @Schema(name = "reEntryPassword", description = "Enter new password again",required = true)
    private String reEntryPassword;
}
