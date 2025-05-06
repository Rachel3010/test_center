package org.iav.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "测试用例信息表")
@TableName(value = "test_info")
@Data
public class TestInfo extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Schema(description = "登录用户名")
    @TableField(value = "name")
    private String phone;

    @Schema(description = "密码")
    @TableField(value = "password", select = false) //`password`字段属于敏感信息，因此在查询时应过滤掉。在@TableField字段增加参数。
    private String password;

}
