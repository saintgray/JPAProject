package com.jh.member.rest;

import com.jh.member.exception.InvalidParamsException;
import com.jh.member.jpo.MemberJpo;
import com.jh.member.spec.presentation.MemberListService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/member")
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

    @GetMapping("/users/{searched}")
    public List<MemberJpo> getUsersBySearched(@PathVariable(name = "searched") String searched){
        return service.findByMEmailLike(searched);
    }

    @GetMapping("/{id}")
    public MemberJpo test(@PathVariable(value ="id")String id){
        return service.register(id);
    }

    @PostMapping("")
    public MemberJpo saveUser(@RequestBody MemberJpo entity) {
        return this.service.saveUser(entity);
    }
}
