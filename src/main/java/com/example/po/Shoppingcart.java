package com.example.po;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Shoppingcart对象", description="用于进行购物车信息传输")
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private String gamename;

    private Long gameid;

    private Double discount;

    private Double price;

    private String capsuleimage;


}
