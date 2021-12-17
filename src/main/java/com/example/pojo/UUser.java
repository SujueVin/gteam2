package com.example.pojo;

import com.example.po.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * @ClassName UUser
 * @Description 暂存于MongoDB的对象
 * @date 2021/12/16 18:56
 * @Version 1.0
 * @Author HJW
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UUser对象", description="注册的user集合")
public class UUser {
    @Id
    private String uuid;
    private User user;
}