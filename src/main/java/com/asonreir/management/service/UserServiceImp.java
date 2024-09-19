package com.asonreir.management.service;

import com.asonreir.management.model.entity.UserEntity;
import com.asonreir.management.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
  @Override
  public UserEntity getById(long id) {
    return null;
  }
}
