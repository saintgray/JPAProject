package com.jh.jpa.jpaservice.service;

import com.jh.jpa.jpaservice.domain.spec.presentation.MemberListService;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@RestController
@RequiredArgsConstructor
public class MemberTestResource {

    private final MemberListService service;

    @GetMapping("/")
    public void test() {
        System.out.println("test completed");
    }

    @GetMapping("/users")
    public List<MemberJpo> getUsers() {
        return service.getMembers();
    }

    @GetMapping("/usersGroup/{groupingBy}")
    public Map<String, List<MemberJpo>> getUsers(@PathVariable(name = "groupingBy") String groupingBy){
        return service.getMembers(groupingBy);
    }

    @GetMapping("/users/{searched}")
    public List<MemberJpo> getUsersBySearched(@PathVariable(name = "searched") String searched){
        return service.findByMEmailLike(searched);
    }
}
