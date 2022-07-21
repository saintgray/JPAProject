package com.jh.jpa.jpaservice.domain.spec.presentation;

import com.jh.jpa.jpaservice.domain.exception.InvalidParamsException;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */

public interface MemberListService {

    List<MemberJpo> getMembers();
    List<MemberJpo> findByMEmailLike(String searched);
    Map<String, List<MemberJpo>> getMembers(String groupingBy) throws InvalidParamsException;
    Map<String, List<MemberJpo>> getMembersByQueryDsl(String groupingBy);
}
