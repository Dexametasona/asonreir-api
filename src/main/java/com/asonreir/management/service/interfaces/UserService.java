package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.UserEntity;

public interface UserService {
  UserEntity getById(long id);
}
