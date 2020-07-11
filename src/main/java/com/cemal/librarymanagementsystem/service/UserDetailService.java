package com.cemal.librarymanagementsystem.service;

import com.cemal.librarymanagementsystem.entity.User;

public interface UserDetailService  {
	User getByUsername(String username);

}
