package com.example.cabinetdentistspring.repos;

import com.example.cabinetdentistspring.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}
