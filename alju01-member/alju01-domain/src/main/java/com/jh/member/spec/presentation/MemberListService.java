package com.jh.member.spec.presentation;

import com.jh.member.exception.InvalidParamsException;
import com.jh.member.jpo.MemberJpo;


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

    MemberJpo register(String id);

    MemberJpo saveUser(MemberJpo entity);
}
