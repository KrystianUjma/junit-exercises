package com.practicalunittesting.chp06.collections;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class UserListTest {

  private UserList userList = new UserList();

  @Test
  public void shouldReturnEmptyList(){

    //assert
    assertThat(userList.getUsers()).isEmpty();
  }

  @Test
  public void shouldReturnOneUser(){

    //arrange
    User user = new User();

    //act
    userList.addUser(user);

    //assert
    assertThat(userList.getUsers()).hasSize(1);

  }

  @Test
  public void shouldContainsTwoUsers(){

    //act
    userList.addUser(new User());
    userList.addUser(new User());

    //assert
    assertThat(userList.getUsers()).hasSize(2);
  }




}
