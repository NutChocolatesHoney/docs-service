package com.docs.common;

import com.docs.exception.ExceptionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude()
@Data
public class ApiResultHelper {

    @ApiModelProperty(value = "返回代码", example = "0000", required = true)
    protected String resCode;

    @ApiModelProperty(value = "返回代码描述")
    protected String resDesc;

    public ApiResultHelper() {
    }

    public ApiResultHelper(String resCode) {
        this.resCode = resCode;
        this.resDesc = ExceptionEnum.getNameByValue(resCode);
    }

    public ApiResultHelper(String resCode, String resDesc) {
        this.resCode = resCode;
        this.resDesc = resDesc;
    }
}
