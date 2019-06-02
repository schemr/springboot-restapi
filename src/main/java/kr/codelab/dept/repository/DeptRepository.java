package kr.codelab.dept.repository;

import kr.codelab.dept.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DeptRepository extends JpaRepository<Dept, Long> {
    Dept findByName(String name);
}
