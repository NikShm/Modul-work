package com.freshbeauty.services;/*
@author Микола
@project FreshBeauty
@class IPersonService
@version 1.0.0
@since 01.08.2022 - 16.41
*/

import com.freshbeauty.dto.UserDTO;

public interface IPersonService {
    UserDTO checkUser(String login, String password);
}
