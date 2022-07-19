package com.jh.jpa.jpaservice.domain.logic.presentation;

import com.jh.jpa.jpaservice.domain.spec.presentation.MemberListService;
import com.jh.jpa.jpaservice.store.MemberJpaRepository;
import com.jh.jpa.jpaservice.store.jpo.MemberJpo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Service
@RequiredArgsConstructor
public class MemberStatusLogic implements MemberListService {

    // test commit 1 in dev branch
    // test commit 2 in dev branch

    private final MemberJpaRepository memberJpaRepository;

    public List<MemberJpo> getMembers(){

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
        return this.memberJpaRepository.findAll();
    }

    public List<MemberJpo> findByMEmailLike(String searched) {
//        return this.memberJpaRepository.findBymEmailLike("%".concat(searched).concat("%"));
        return null;
    }

    @Override
    public Map<String, List<MemberJpo>> getMembers(String groupingBy) {
        List<MemberJpo> list = this.memberJpaRepository.findAll();
        Map<String, List<MemberJpo>> usersGroup = null;
        if (!ObjectUtils.isEmpty(list)) {
            switch (groupingBy.toLowerCase()) {
                case "location": {
                    usersGroup = list.stream().collect(Collectors.groupingBy(MemberJpo::getLocIdx));
                    break;
                }
                case "subscriber": {
                    usersGroup = list.stream()
                            .collect(Collectors.groupingBy(e ->
                                    "Y".equals(e.getMAdyn()) ?
                                            "subscriber" : "nonSubscriber"));
                    break;
                }
                default: {
                }
            }
        }
        return usersGroup;
    }


}
