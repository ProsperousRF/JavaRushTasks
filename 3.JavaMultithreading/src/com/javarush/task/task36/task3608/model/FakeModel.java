package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislav Rakitov
 */
public class FakeModel implements Model{

  private ModelData modelData = new ModelData();

  @Override
  public ModelData getModelData() {
    return modelData;
  }

  @Override
  public void loadUsers() {
    List<User> fakeUsers = new ArrayList<>();
    fakeUsers.add(new User("U1", 1, 1));
    fakeUsers.add(new User("U2", 2, 1));

    modelData.setUsers(fakeUsers);
  }
}
