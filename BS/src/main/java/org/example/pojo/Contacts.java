package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@TableName(value ="phone")
@Data
public class Contacts{
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String number;
}