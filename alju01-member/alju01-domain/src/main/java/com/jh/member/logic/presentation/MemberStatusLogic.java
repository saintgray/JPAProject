package com.jh.member.logic.presentation;

import com.jh.member.MemberJpaRepository;
import com.jh.member.exception.InvalidParamsException;
import com.jh.member.jpo.MemberJpo;
import com.jh.member.spec.presentation.MemberListService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Service
@RequiredArgsConstructor
public class MemberStatusLogic implements MemberListService {
    private final MemberJpaRepository memberJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public List<MemberJpo> getMembers() {

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
    public Map<String, List<MemberJpo>> getMembers(String groupingBy) throws InvalidParamsException {
        List<MemberJpo> list = this.memberJpaRepository.findAll();
        Map<String, List<MemberJpo>> usersGroup = null;
        if (!ObjectUtils.isEmpty(list)) {
            switch (groupingBy.toLowerCase()) {
                case "location": {
                    usersGroup = list.stream().filter(member -> !ObjectUtils.isEmpty(member.getLocIdx()))
                            .filter(member -> "Y".equals(member.getMBlacklist()))
                            .collect(Collectors.groupingBy(MemberJpo::getLocIdx));
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
                    throw new InvalidParamsException();
                }
            }
        }
        // todo dfdsf
        return usersGroup;
    }

    @Override
    public MemberJpo register(String id) {
        MemberJpo jpo = new MemberJpo();
        jpo.setIdx(new BigDecimal(82));
        jpo.setUsrEmail("testEmail@naver.com");
        jpo.setUsrNm("test");
        return this.memberJpaRepository.save(jpo);
    }

    @Override
    public MemberJpo saveUser(MemberJpo entity) {
        return this.memberJpaRepository.save(entity);
    }
}
