package com.example.demo;

public class User {
        String uid;
        String name;
        int age;

        public User() {
        }

        public User(String uid, String name, int age) {
            this.uid = uid;
            this.name = name;
            this.age = age;
        }

        public User(String uid, String name) {
            this.uid = uid;
            this.name = name;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "uid='" + uid + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }