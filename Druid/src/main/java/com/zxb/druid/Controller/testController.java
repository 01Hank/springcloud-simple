package com.zxb.druid.Controller;

import com.zxb.druid.Mapper.ego.egoMapper;
import com.zxb.druid.Mapper.tpc.tpcMapper;
import com.zxb.druid.Pojo.Student;
import com.zxb.druid.Pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {
    @Autowired
    private egoMapper  ego;

    @Autowired
    private tpcMapper  tpc;

    @CrossOrigin("*")
    @GetMapping("/tpc")
    public List<Student> getTpc(){
        return tpc.selectAll();
    }

    @CrossOrigin("*")
    @GetMapping("/ego")
    public List<TbUser> getEgo(){
        return ego.selectAll();
    }
}
