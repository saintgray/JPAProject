package com.jh.jpa.jpaservice.domain.service;

import com.jh.jpa.jpaservice.entity.jpo.MemberJpo;
import com.jh.jpa.jpaservice.store.MemberJpaRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */

@Service
@RequiredArgsConstructor
public class MemberListService {

    private final MemberJpaRepository memberJpaRepository;

    public List<MemberJpo> getMembers(){
        return this.memberJpaRepository.findAll();
    }

    public List<MemberJpo> findByMEmailLike(String searched){
        return this.memberJpaRepository.findBymEmailLike("%".concat(searched).concat("%"));
    }


}
