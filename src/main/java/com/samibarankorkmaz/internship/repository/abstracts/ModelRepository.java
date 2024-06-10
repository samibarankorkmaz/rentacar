package com.samibarankorkmaz.internship.repository.abstracts;

import com.samibarankorkmaz.internship.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
}
