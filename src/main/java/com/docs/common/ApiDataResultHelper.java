package com.docs.common;

import com.docs.constant.CommonConstant;
import com.docs.exception.ExceptionEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude()
@Data
public class ApiDataResultHelper<D> extends ApiResultHelper {

    private D data;

    public ApiDataResultHelper(D data) {
        this.data = data;
        this.resCode = CommonConstant.RE_SUCCESS_CODE;
        this.resDesc = ExceptionEnum.getNameByValue(resCode);
    }
}
