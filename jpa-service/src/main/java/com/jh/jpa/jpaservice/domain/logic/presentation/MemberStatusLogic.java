package com.jh.jpa.jpaservice.domain.logic.presentation;

import com.jh.jpa.jpaservice.domain.spec.presentation.MemberListService;
import com.jh.jpa.jpaservice.store.MemberJpaRepository;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Service
@RequiredArgsConstructor
public class MemberStatusLogic implements MemberListService {

    private final MemberJpaRepository memberJpaRepository;

    public List<MemberJpo> getMembers(){

        // crash Test commit

        List<MemberJpo> list = null;
//        List<MemberStatusDTO> results = null;
//        list = this.memberJpaRepository.findAll();
//        if(list!=null && !list.isEmpty()){
//            results = new ArrayList<>();
//            for(MemberJpo jpo : list){
//                MemberStatusDTO dto = new MemberStatusDTO();
//                dto.setSucscribeStatus(jpo.isSubscriber() ? "구독중" : "비구독중");
//                results.add(dto);
//            }
//        }
//        return results;
        return list;
    }

    public List<MemberJpo> findByMEmailLike(String searched){
//        return this.memberJpaRepository.findBymEmailLike("%".concat(searched).concat("%"));
        return null;
    }


}
