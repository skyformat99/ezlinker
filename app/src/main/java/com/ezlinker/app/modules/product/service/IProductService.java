package com.ezlinker.app.modules.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ezlinker.app.modules.product.model.Product;

/**
 * <p>
 * 产品（设备的抽象模板） 服务类
 * </p>
 *
 * @author wangwenhai
 * @since 2019-11-13
 */
public interface IProductService extends IService<Product> {
    Product details(Long productId);

}
