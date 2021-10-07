package com.company.classes;

import com.company.interfaces.IteratorInterface;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public UserIterator createIterator() {
        return new UserIterator(this);
    }

    public class UserIterator implements IteratorInterface {
        private UserList userList;
        private int index;

        public UserIterator(UserList userList) {
            this.userList = userList;
        }

        @Override
        public boolean hasNext() {
            return (index < userList.users.size());
        }

        @Override
        public User current() {
            return userList.users.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }
}
