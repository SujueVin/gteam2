package com.example.pojo;

import com.example.po.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

/**
 * @author: tt
 * @Date: 2021/12/20 15:26
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserToken对象", description="Userid-Token对")
public class UserToken {

    @Id
    private String userid;
    private String token;
}
