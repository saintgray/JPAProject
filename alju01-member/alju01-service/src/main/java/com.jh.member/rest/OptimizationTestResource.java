package com.jh.member.rest;

import com.jh.member.jpo.MemberJpo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@RestController
public class OptimizationTestResource {


    @GetMapping("/test")
    public List<MemberJpo> optimizationTest(){

//        long startTime = System.currentTimeMillis();
//        Map<String, MemberJpo> jpoMap = testList.stream().collect(Collectors.toMap(MemberJpo::getMEmail, e2->e2, (p1, p2)->p1));
//        for(MemberJpo jpo : testList){
//            System.out.println(jpo);
//        }
//        for (String s : jpoMap.keySet()) {
//            System.out.println(s);
//        }
//        System.out.println(System.currentTimeMillis() - startTime);
        return null;
    }
}
