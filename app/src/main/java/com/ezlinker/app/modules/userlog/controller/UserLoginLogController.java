package com.ezlinker.app.modules.userlog.controller;


import com.ezlinker.app.common.exception.XException;
import com.ezlinker.app.common.exchange.R;
import com.ezlinker.app.common.web.CurdController;
import com.ezlinker.app.modules.userlog.model.UserLoginLog;
import com.ezlinker.app.modules.userlog.service.IUserLoginLogService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户登录日志
 * </p>
 *
 * @author wangwenhai
 * @since 2019-11-12
 */
@RestController
@RequestMapping("/userLogs")
public class UserLoginLogController extends CurdController<UserLoginLog> {
    @Resource
    IUserLoginLogService<UserLoginLog> iUserLoginLogService;

    public UserLoginLogController(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
    }

    /**
     * 获取用户的登录日志
     *
     * @return
     * @throws XException
     */
    @GetMapping
    public R queryForPage(@RequestParam(required = false, defaultValue = "0") Integer current,
                          @RequestParam(required = false, defaultValue = "20") Integer size) throws XException {
        Pageable pageable = getXPageRequest(current, size);
        return data(iUserLoginLogService.queryForPage(getUserDetail().getId(), pageable));
    }

}

