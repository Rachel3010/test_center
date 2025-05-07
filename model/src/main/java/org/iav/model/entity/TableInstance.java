package org.iav.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@TableName("test_instance")
public class TableInstance implements Serializable {
    @TableId(value = "instance_id", type = IdType.NONE)
    private String instanceId;
    @TableField("bench_name")
    private String benchName;

    private String coreStatus;

    private String powerStatus;

    private String ecuHw;

    private String ecuSw;

    // date_submit字段，对应数据库的timestamp类型，在Java中用LocalDateTime表示
    //private LocalDateTime dateSubmit;

    // date_update字段，对应数据库的timestamp类型，在Java中用LocalDateTime表示
    //private LocalDateTime dateUpdate;
}
