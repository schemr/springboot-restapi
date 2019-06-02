package kr.codelab.dept.service;

import kr.codelab.dept.entity.Dept;
import kr.codelab.dept.entity.DeptGroup;
import kr.codelab.dept.repository.DeptGroupRepository;
import kr.codelab.dept.repository.DeptRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class DeptService {
    private DeptGroupRepository deptGroupRepository;
    private DeptRepository deptRepository;

    public DeptService(DeptGroupRepository deptGroupRepository, DeptRepository deptRepository) {
        this.deptGroupRepository = deptGroupRepository;
        this.deptRepository = deptRepository;
    }

    public List<DeptGroup> getAllDeptGroups() {
        return deptGroupRepository.findAll();
    }

    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }

    public DeptGroup getDeptGroup(Long id) {
        DeptGroup deptGroup = deptGroupRepository.findById(id).orElse(null);

        if(deptGroup == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Dept Group Not Found"
            );
        }else {
            return deptGroup;
        }
    }

    public Dept getDept(Long id) {
        Dept dept = deptRepository.findById(id).orElse(null);

        if(dept == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Dept Not Found"
            );
        }else {
            return dept;
        }
    }

    public DeptGroup getDeptGroup(String name) {
        DeptGroup deptGroup = deptGroupRepository.findByName(name);

        return deptGroup;
    }

    public Dept getDept(String name) {
        Dept dept = deptRepository.findByName(name);

        return dept;
    }

    public DeptGroup createDeptGroup(DeptGroup deptGroup) {
        deptGroup.setCurrentTime();
        return deptGroupRepository.save(deptGroup);
    }

    public Dept createDept(Dept dept){
        dept.setCurrentTime();
        return deptRepository.save(dept);
    }

    public DeptGroup updateDeptGroup(Long id, DeptGroup deptGroup) {
        DeptGroup savedDeptGroup = deptGroupRepository.findById(id).orElse(null);
        if (savedDeptGroup == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DeptGroup Not Found");
        }else{
            savedDeptGroup.update(deptGroup);
            return deptGroupRepository.save(savedDeptGroup);
        }
    }

    public Dept updateDept(Long id, Dept dept) {
        Dept savedDept = deptRepository.findById(id).orElse(null);
        if (savedDept == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dept Not Found");
        }else{
            savedDept.update(dept);
            return deptRepository.save(savedDept);
        }
    }

    public void deleteDeptGroup(Long id) {
        if(deptGroupRepository.findById(id).isPresent()) {
            deptGroupRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "DeptGroup Not Found");
        }
    }

    public void deleteDept(Long id) {
        if(deptRepository.findById(id).isPresent()) {
            deptRepository.deleteById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Dept Not Found");
        }
    }
}
