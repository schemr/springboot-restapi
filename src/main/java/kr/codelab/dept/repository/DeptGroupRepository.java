package kr.codelab.dept.repository;

import kr.codelab.dept.entity.DeptGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DeptGroupRepository extends JpaRepository<DeptGroup, Long> {
    DeptGroup findByName(String name);
}
