package com.jh.jpa.jpaservice.service;

import com.jh.jpa.jpaservice.domain.service.MemberListService;
import com.jh.jpa.jpaservice.entity.jpo.MemberJpo;
import com.jh.jpa.jpaservice.store.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@RestController
@RequiredArgsConstructor
public class ResourceTestController {

    private final MemberListService service;

    @GetMapping("/")
    public void test(){
        System.out.println("test completed");
    }

    @GetMapping("/users")
    public List<MemberJpo> getUsers(){
        List<MemberJpo> members = null;
        members = service.getMembers();
        System.out.println(members);
        return members;
    }

    @GetMapping("/users/{searched}")
    public List<MemberJpo> getUsersBySearched(@PathVariable(name = "searched") String searched){
        List<MemberJpo> members = null;
        members = service.findByMEmailLike(searched);
        return members;
    }
}
