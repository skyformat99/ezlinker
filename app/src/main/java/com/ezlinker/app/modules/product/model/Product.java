package com.ezlinker.app.modules.product.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.GsonTypeHandler;
import com.ezlinker.app.common.model.XEntity;
import com.ezlinker.app.modules.device.pojo.FieldParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 产品（设备的抽象模板）
 * </p>
 *
 * @author wangwenhai
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "ez_product", autoResultMap = true)
public class Product extends XEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 项目ID
     */
    @NotNull(message = "项目不能为空")
    private Long projectId;

    /**
     * 产品名称
     */
    @NotEmpty(message = "名称不能为空")
    private String name;
    /**
     * 产品logo
     */

    private String logo;

    /**
     * 参数
     */
    @TableField(typeHandler = GsonTypeHandler.class)
    private List<FieldParam> fieldParams;

    /**
     * 描述文字
     */
    private String description;


    /**
     * 协议类型,到时候还需要根据协议配置加载的模块类型,协议没那么多支持
     * TCP 0
     * MQTT 1
     * HTTP 2
     * COAP 3
     */
    public static final int TCP = 0;
    public static final int MQTT = 1;
    public static final int HTTP = 2;
    public static final int COAP = 3;

    /**
     * 2020-8-20: 生产的设备数量
     */
    @TableField(exist = false)
    private long deviceCount;
}
