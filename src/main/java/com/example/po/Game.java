package com.example.po;


import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 游戏表
 * </p>
 *
 * @author su_jue
 * @since 2021-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Game对象", description="游戏表")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long gameid;

    @ApiModelProperty(value = "游戏名字")
    private String gamename;

    @ApiModelProperty(value = "游戏描述")
    private String gameintroduction;

    @ApiModelProperty(value = "游戏相关，250字以下")
    private String gameabout;

    @ApiModelProperty(value = "开发者")
    private String creater;

    private String publisher;

    @ApiModelProperty(value = "系统推荐配置要求")
    private String systemcfg;

    @ApiModelProperty(value = "正常价格")
    private Double price;

    @ApiModelProperty(value = "打折后价格")
    private Double discount;

    @ApiModelProperty(value = "发行时间")
    private LocalDateTime issueddate;

    @ApiModelProperty(value = "状态，0为未上架，1为已上架，2为已下架")
    private Integer stat;

    @ApiModelProperty(value = "游戏简略图")
    private String capsuleimage;

    private Integer salenum;


}
