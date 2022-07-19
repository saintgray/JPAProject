package com.jh.jpa.jpaservice.service;

import com.jh.jpa.jpaservice.domain.spec.presentation.MemberListService;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
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
    @ApiOperation(
            value = "회원정보 조회 (그룹)",
            notes = "구독자별, 지역별로 그룹화한 회원들의 정보를 조회한다")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "groupingBy", required = true, value = "그룹 기준(location, subscriber)"))
    @ApiResponse(
            code = 200, message = "success")
    public ResponseEntity<?> getUsers(@PathVariable(name = "groupingBy") String groupingBy){
        Map<String, List<MemberJpo>> usersGroup = service.getMembers(groupingBy);
        ResponseEntity<?> result;
        if(ObjectUtils.isEmpty(usersGroup)) {
            result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("올바른 그룹 기준을 선택하세요");
        }else {
            result = ResponseEntity.ok(usersGroup);
        }
        return result;
    }

    @GetMapping("/users/{searched}")
    public List<MemberJpo> getUsersBySearched(@PathVariable(name = "searched") String searched){
        return service.findByMEmailLike(searched);
    }
}
