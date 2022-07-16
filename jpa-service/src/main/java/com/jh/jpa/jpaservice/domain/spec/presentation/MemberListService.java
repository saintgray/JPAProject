package com.jh.jpa.jpaservice.domain.spec.presentation;

import com.jh.jpa.jpaservice.store.jpo.MemberJpo;

import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */

public interface MemberListService {

    List<MemberJpo> getMembers();
    List<MemberJpo> findByMEmailLike(String searched);

}
