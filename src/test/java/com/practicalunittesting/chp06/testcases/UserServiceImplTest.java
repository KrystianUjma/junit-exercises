package com.practicalunittesting.chp06.testcases;

import static org.mockito.Mockito.mock;

import org.junit.Test;

public class UserServiceImplTest {

  private UserServiceImpl userService;

  @Test
  public void testAssignPassword(){
    User user = mock(User.class);
    UserDAO userDAO = mock(UserDAO.class);
    SecurityService securityService = mock(SecurityService.class);

    userService = new UserServiceImpl(userDAO, securityService);

  }
}
