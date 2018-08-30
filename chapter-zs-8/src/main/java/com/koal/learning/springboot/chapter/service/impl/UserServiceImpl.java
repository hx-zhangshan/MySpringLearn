package com.koal.learning.springboot.chapter.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.koal.learning.springboot.chapter.dao.UserDao;
import com.koal.learning.springboot.chapter.entity.User;
import com.koal.learning.springboot.chapter.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangS
 * @since 2018-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
