package com.freshbeauty.repositories;/*
@author Микола
@project FreshBeauty
@class PersonRepository
@version 1.0.0
@since 01.08.2022 - 16.39
*/

import com.freshbeauty.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
    Person findByLogin(String login);
}
