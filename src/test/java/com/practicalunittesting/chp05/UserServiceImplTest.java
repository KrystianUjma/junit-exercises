package com.practicalunittesting.chp05;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class UserServiceImplTest {

  //user dostaje nowe haslo
  // update user na user dao jest wywolane

  @Test
  public void shouldUpdateUserPassword() throws Exception {
    UserDAO userDAO = mock(UserDAO.class);
    SecurityService securityService = mock(SecurityService.class);
    User user = mock(User.class);

    UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    userService.assignPassword(user);

    verify(userDAO).updateUser(user);
    verify(user).setPassword(anyString());


  }



}
