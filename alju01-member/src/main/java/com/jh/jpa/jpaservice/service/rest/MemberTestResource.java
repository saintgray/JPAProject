package com.jh.jpa.jpaservice.service.rest;

import com.jh.jpa.jpaservice.domain.exception.InvalidParamsException;
import com.jh.jpa.jpaservice.domain.spec.presentation.MemberListService;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
    @ApiResponses({
            @ApiResponse(code = 200, message = "그룹화된 Map<String(지역코드), List<MemberJpo>(해당 지역에 거주하는 회원들)> 반환"),
            @ApiResponse(code = 505, message = "올바른 그룹 기준이 아닙니다"),
            @ApiResponse(code = 204, message ="조회 결과가 없습니다")})
    public ResponseEntity<?> getUsers(@PathVariable(name = "groupingBy") String groupingBy){

        ResponseEntity<?> result = null;
        try{
            Map<String, List<MemberJpo>> usersGroup = service.getMembers(groupingBy);
            if(ObjectUtils.isEmpty(usersGroup)) {
                result = ResponseEntity.status(204).body("조회 결과가 없습니다");
            }else {
                result = ResponseEntity.ok(usersGroup);
            }
        }catch(InvalidParamsException e){
            result = ResponseEntity.status(505).body("올바른 그룹 기준을 선택하세요");
        }
        return result;
    }


    @GetMapping("/uers/{groupingBy}/{queryDslSelected}")
    public ResponseEntity<?> getUsers(@PathVariable(name = "groupingBy") String groupingBy,
                                      @PathVariable(name = "queryDslSelected") String selected) {
        ResponseEntity<?> result = null;
        if (!selected.equalsIgnoreCase("Y")) {
            result = getUsers(groupingBy);
        } else {
            try{
                Map<String, List<MemberJpo>> usersGroup = service.getMembersByQueryDsl(groupingBy);
                if (!ObjectUtils.isEmpty(usersGroup)) {
                    result = ResponseEntity.ok(usersGroup);
                }
            }catch(NoSuchElementException e){
                result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("올바른 그룹 기준을 선택하세요");
            }
        }
        return result;
    }

    @GetMapping("/users/{searched}")
    public List<MemberJpo> getUsersBySearched(@PathVariable(name = "searched") String searched){
        return service.findByMEmailLike(searched);
    }
}
